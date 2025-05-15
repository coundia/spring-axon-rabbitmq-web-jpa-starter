package com.groupe2cs.bizyhub.shared.infrastructure.ia;

import com.groupe2cs.bizyhub.chats.application.command.UpdateChatCommand;
import com.groupe2cs.bizyhub.chats.domain.event.ChatCreatedEvent;
import com.groupe2cs.bizyhub.chats.domain.event.ChatUpdatedEvent;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

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

		if (response == null || response.isBlank()) {
			response = "Je suis désolé, je n’ai pas pu générer de réponse.";
		}

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

		commandGateway.send(updateChatCommand);
	}


}
