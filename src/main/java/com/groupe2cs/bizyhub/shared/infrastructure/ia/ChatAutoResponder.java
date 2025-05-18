package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.groupe2cs.bizyhub.chats.application.command.UpdateChatCommand;
import com.groupe2cs.bizyhub.chats.domain.event.ChatCreatedEvent;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatResponses;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatResponsesJson;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatState;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatUpdatedAt;
import com.groupe2cs.bizyhub.shared.application.DateUtils;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionDeltaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Component
@RequiredArgsConstructor
public class ChatAutoResponder {

	private final IAService iaService;
	private final CommandGateway commandGateway;


	@EventHandler
	public void on(ChatCreatedEvent event) {
		log.info("[ChatAutoResponder] Auto-responding to chat: {}", event.getId());

		if (event.getResponses() != null && !event.getResponses().value().isBlank()) return;

		String response = iaService.generateResponse(event.getMessages().value());

		log.info("[ChatAutoResponder] Generated response: {}", response);

		UpdateChatCommand updateChatCommand = UpdateChatCommand.builder()
				.id(event.getId())
				.messages(event.getMessages())
				.responses(new ChatResponses(response))
				.state(event.getState())
				.account(event.getAccount())
				.updatedAt(event.getUpdatedAt())
				.reference(event.getReference())
				.createdBy(event.getCreatedBy())
				.tenant(event.getTenant())
				.build();

		try {
			ObjectMapper mapper = new ObjectMapper()
					.registerModule(new JavaTimeModule())
					.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

			JsonNode root = mapper.readTree(response);
			JsonNode deltaNode = root.get("deltas").get(0);

			TransactionDeltaDto dto = mapper.treeToValue(deltaNode, TransactionDeltaDto.class);

			String categoryName = dto.getCategory();
			log.warn("❌ Category not found in response, falling back to default category");
			dto.setCategory(
					iaService.getCategory(
					dto.getTypeTransactionRaw(),
					event.getCreatedBy().value(),
							categoryName,
					event.getTenant().value()
					)
			);

			String confirmation = "Voulez-vous confirmer la création de cette transaction ?\n" +
					"Description : " + dto.getDetails() + "\n" +
					"Montant : " + dto.getAmount() + "\n" +
					"Date : " + dto.getDateTransaction() + "\n" +
					"Catégorie : " + categoryName + "\n";

			dto.setId(UUID.randomUUID().toString());
			dto.setReference(UUID.randomUUID().toString());
			dto.setName(dto.getDetails());
			dto.setUpdatedAt(Instant.now());
			dto.setIsActive(true);

			String updatedResponseJson = mapper.writeValueAsString(Map.of("deltas", List.of(dto)));
			updateChatCommand.setResponsesJson(new ChatResponsesJson(updatedResponseJson));
			updateChatCommand.setState(new ChatState("REPLIED"));

			updateChatCommand.setResponses(new ChatResponses(confirmation));

			log.info("Confirmation message: {}", confirmation);
			log.info("Category: {}", dto.getCategory());

		} catch (Exception e) {
			log.error("❌ Parsing or category fallback failed", e);
			updateChatCommand.setState(new ChatState("ERROR"));
			updateChatCommand.setResponses(new ChatResponses("Erreur lors de la génération."));
			updateChatCommand.setResponsesJson(new ChatResponsesJson(response));
		}

		updateChatCommand.setUpdatedAt(new ChatUpdatedAt(Instant.now()));

		commandGateway.send(updateChatCommand);
	}


}
