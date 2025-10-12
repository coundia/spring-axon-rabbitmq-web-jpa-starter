// File: ChatAutoResponder.java
// Normalize AI delta JSON before mapping to DTO, add robust logs, and ignore unknown properties.

package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.groupe2cs.bizyhub.chats.application.command.UpdateChatCommand;
import com.groupe2cs.bizyhub.chats.domain.event.ChatCreatedEvent;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatResponses;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatResponsesJson;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatState;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionDeltaDto;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatAutoResponder {

	private static final ObjectMapper MAPPER = new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
			// ⬇️ Empêche l’échec si l’IA ajoute des champs non prévus (ex: "details")
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	private final IAService iaService;
	private final CommandGateway commandGateway;

	private static ObjectNode normalizeDeltaNode(JsonNode n) {
		ObjectNode out = n.isObject() ? ((ObjectNode) n).deepCopy() : MAPPER.createObjectNode();

		// description: accepte "description" ou "details"
		if (isBlank(out.path("description")) && !isBlank(out.path("details"))) {
			out.put("description", out.path("details").asText());
		}

		// type: unifie depuis "typeTransactionRaw", "typeEntry" ou "type"
		String type = null;
		if (!isBlank(out.path("typeTransactionRaw"))) type = out.path("typeTransactionRaw").asText();
		else if (!isBlank(out.path("typeEntry"))) type = out.path("typeEntry").asText();
		else if (!isBlank(out.path("type"))) type = out.path("type").asText();
		if (type == null || type.isBlank()) type = "IN";
		out.put("type", type);        // pour DTO (au cas où)
		out.put("typeEntry", type);   // si DTO attend "typeEntry"

		// dateTransaction: garde tel quel si présent
		// amount: si string, essaye de parser
		if (out.has("amount") && out.path("amount").isTextual()) {
			try {
				out.put("amount", Double.parseDouble(out.path("amount").asText().replace(" ", "")));
			} catch (Exception ignore) {
			}
		}

		// category: accept "category" (label); l’id sera résolu ensuite
		// rien à faire ici, mais on garantit la présence du champ
		if (isBlank(out.path("category")) && !isBlank(out.path("categoryName"))) {
			out.put("category", out.path("categoryName").asText());
		}

		return out;
	}

	// ---------------- helpers ----------------

	private static boolean isBlank(JsonNode n) {
		return n == null || n.isMissingNode() || n.isNull()
				|| (n.isTextual() && n.asText().trim().isEmpty());
	}

	private static String extractJsonOrNullBalanced(String s) {
		if (s == null) return null;
		int depth = 0, start = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{') {
				if (depth == 0) start = i;
				depth++;
			} else if (c == '}') {
				depth--;
				if (depth == 0 && start >= 0) {
					String candidate = s.substring(start, i + 1).trim();
					if (candidate.startsWith("{") && candidate.endsWith("}")) return candidate;
					start = -1;
				}
			}
		}
		return null;
	}

	private static String text(JsonNode node, String field, String def) {
		JsonNode n = node.path(field);
		if (n.isMissingNode() || n.isNull()) return def;
		String v = n.asText();
		return (v == null || v.isBlank()) ? def : v;
	}

	private static String safe(String v) {
		if (v == null) return "null";
		return v.length() > 256 ? v.substring(0, 256) + "…" : v;
	}

	private static String preview(String v) {
		if (v == null) return "null";
		String s = v.replace("\n", " ").replace("\r", " ");
		return s.length() > 200 ? s.substring(0, 200) + "…" : s;
	}

	@EventHandler
	public void on(ChatCreatedEvent event) {
		final String correlation = event.getId().value();
		String aiRaw = null;

		log.info("[ChatAutoResponder] on(ChatCreatedEvent) corrId={} user={} tenant={} msg='{}'",
				correlation, safe(event.getCreatedBy().value()), safe(event.getTenant().value()),
				safe(event.getMessages().value()));

		UpdateChatCommand update = UpdateChatCommand.builder()
				.id(event.getId())
				.messages(event.getMessages())
				.state(new ChatState("PROCESSING"))
				.build();

		try {
			aiRaw = iaService.generateResponse(event.getMessages().value());
			update.setResponsesJson(new ChatResponsesJson(aiRaw == null ? "" : aiRaw));
			log.info("[ChatAutoResponder] IA raw corrId={} preview={}", correlation, preview(aiRaw));

			String candidate = extractJsonOrNullBalanced(aiRaw);
			if (candidate == null) {
				update.setState(new ChatState("FAIL"));
				update.setResponses(new ChatResponses("Réponse IA non exploitable."));
				commandGateway.send(update);
				log.warn("[ChatAutoResponder] No JSON extracted corrId={}", correlation);
				return;
			}

			JsonNode root = MAPPER.readTree(candidate);
			JsonNode deltas = root.path("deltas");
			if (!deltas.isArray() || deltas.isEmpty()) {
				update.setState(new ChatState("FAIL"));
				update.setResponses(new ChatResponses("Aucune transaction détectée."));
				commandGateway.send(update);
				log.warn("[ChatAutoResponder] Empty deltas corrId={} json={}", correlation, candidate);
				return;
			}

			JsonNode deltaNode = deltas.get(0);
			log.info("[ChatAutoResponder] Delta[0] corrId={} raw={}", correlation, deltaNode);

			// ️ Normalisation avant mapping DTO (gère "details" -> description, "typeTransactionRaw" -> type/typeEntry, etc.)
			ObjectNode normalized = normalizeDeltaNode(deltaNode);
			log.info("[ChatAutoResponder] Delta[0] normalized corrId={} {}", correlation, normalized);

			TransactionDeltaDto dto = MAPPER.treeToValue(normalized, TransactionDeltaDto.class);

			// Résolution catégorie (création si nécessaire via IA service)
			final String categoryLabel = text(normalized, "category", "Autre");
			final String typeRaw = text(normalized, "type", "CREDIT"); // déjà normalisé
			String resolvedCategoryId = iaService.getCategory(
					typeRaw,
					event.getCreatedBy().value(),
					categoryLabel,
					event.getTenant().value()
			);
			log.info("[ChatAutoResponder] Category resolved corrId={} '{}' -> id={}",
					correlation, categoryLabel, resolvedCategoryId);

			dto.setCategory(resolvedCategoryId);
			if (dto.getId() == null || dto.getId().isBlank()) {
				dto.setId(UUID.randomUUID().toString());
			}

			Double amount = dto.getAmount() == null ? 0d : dto.getAmount();
			String description = (dto.getDescription() == null || dto.getDescription().isBlank())
					? "" : dto.getDescription();
			Instant when = dto.getDateTransaction() == null ? Instant.now() : dto.getDateTransaction();
			String entityId = event.getId().value();

			//  Vérifie l’unité attendue par TransactionAmount (double unité vs cents).
			CreateTransactionCommand tx = CreateTransactionCommand.builder()
					.localId(TransactionLocalId.create(UUID.randomUUID().toString()))
					.code(TransactionCode.create(UUID.randomUUID().toString()))
					.description(TransactionDescription.create(description))
					.amount(TransactionAmount.create(amount * 100))
					.account(TransactionAccount.create(event.getAccount().value()))
					.typeEntry(TransactionTypeEntry.create(typeRaw))
					.dateTransaction(TransactionDateTransaction.create(when))
					.status(TransactionStatus.create("INIT"))
					.entityName(TransactionEntityName.create("chat"))
					.entityId(TransactionEntityId.create(entityId))
					.syncAt(TransactionSyncAt.create(Instant.now()))
					.category(TransactionCategory.create(resolvedCategoryId))
					.createdBy(TransactionCreatedBy.create(event.getCreatedBy().value()))
					.tenant(TransactionTenant.create(event.getTenant().value()))
					.build();

			log.info(
					"[ChatAutoResponder] Dispatch CreateTransaction corrId={} amount={} type={} date={} catId={} desc='{}'",
					correlation,
					amount,
					typeRaw,
					when,
					resolvedCategoryId,
					description);

			try {
				Object result = commandGateway.sendAndWait(tx, 30, TimeUnit.SECONDS);
				log.info("[ChatAutoResponder] Command OK corrId={} resultClass={}",
						correlation, (result == null ? "null" : result.getClass().getName()));
			} catch (Exception dispatchErr) {
				log.error("[ChatAutoResponder] Command failed corrId={} err={}",
						correlation, dispatchErr.toString(), dispatchErr);
				UpdateChatCommand fail = UpdateChatCommand.builder()
						.id(event.getId())
						.messages(event.getMessages())
						.responses(new ChatResponses("Échec de création transaction: " +
								safe(dispatchErr.getMessage())))
						.responsesJson(new ChatResponsesJson(aiRaw == null ? "" : aiRaw))
						.state(new ChatState("FAIL"))
						.build();
				commandGateway.send(fail);
				return;
			}

			update.setResponses(new ChatResponses("Transaction créée."));
			update.setState(new ChatState("COMPLETED"));
			commandGateway.send(update);
			log.info("[ChatAutoResponder] Completed corrId={} state=COMPLETED", correlation);

		} catch (Exception e) {
			log.error("[ChatAutoResponder] Fatal error corrId={} err={}", correlation, e.toString(), e);
			UpdateChatCommand fail = UpdateChatCommand.builder()
					.id(event.getId())
					.messages(event.getMessages())
					.responses(new ChatResponses("Échec de traitement."))
					.responsesJson(new ChatResponsesJson(aiRaw == null ? "" : aiRaw))
					.state(new ChatState("FAIL"))
					.build();
			commandGateway.send(fail);
		}
	}
}
