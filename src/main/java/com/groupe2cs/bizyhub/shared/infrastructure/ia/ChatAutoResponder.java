package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.chats.application.command.UpdateChatCommand;
import com.groupe2cs.bizyhub.chats.domain.event.ChatCreatedEvent;
import com.groupe2cs.bizyhub.chats.domain.event.ChatUpdatedEvent;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatResponses;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatResponsesJson;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatState;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionDeltaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionDeltaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

			//if (dto.getCategory() == null) {
				log.warn("❌ Category not found in response, falling back to default category");
				dto.setCategory(iaService.getCategory(dto.getTypeTransactionRaw(), event.getCreatedBy().value()));
			//}

			String updatedResponseJson = mapper.writeValueAsString(Map.of("deltas", List.of(dto)));
			updateChatCommand.setResponsesJson(new ChatResponsesJson(updatedResponseJson));
			updateChatCommand.setState(new ChatState("REPLIED"));
			updateChatCommand.setResponses(new ChatResponses("Transaction préparée."));

		} catch (Exception e) {
			log.error("❌ Parsing or category fallback failed", e);
			updateChatCommand.setState(new ChatState("ERROR"));
			updateChatCommand.setResponses(new ChatResponses("Erreur lors de la génération."));
			updateChatCommand.setResponsesJson(new ChatResponsesJson(response));
		}

		commandGateway.send(updateChatCommand);
	}


}
