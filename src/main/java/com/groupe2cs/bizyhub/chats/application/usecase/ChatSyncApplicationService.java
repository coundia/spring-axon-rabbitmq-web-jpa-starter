package com.groupe2cs.bizyhub.chats.application.usecase;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.chats.application.command.*;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ChatSyncApplicationService {

	private final ChatGate gateService;
	private final CommandGateway commandGateway;

	public void syncChat(ChatSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateChatCommand command = CreateChatCommand.builder()
								.messages(ChatMessages.create(d.getMessages()))
								.responsesJson(ChatResponsesJson.create(d.getResponsesJson()))
								.responses(ChatResponses.create(d.getResponses()))
								.state(ChatState.create(d.getState()))
								.account(ChatAccount.create(d.getAccount()))
								.updatedAt(ChatUpdatedAt.create(d.getUpdatedAt()))
								.reference(ChatReference.create(d.getReference()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(ChatTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(ChatCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Chat with id " + d.getId());
					}

					UpdateChatCommand update = UpdateChatCommand.builder()
							.id(ChatId.create(d.getId()))
							.messages(ChatMessages.create(d.getMessages()))
							.responsesJson(ChatResponsesJson.create(d.getResponsesJson()))
							.responses(ChatResponses.create(d.getResponses()))
							.state(ChatState.create(d.getState()))
							.account(ChatAccount.create(d.getAccount()))
							.updatedAt(ChatUpdatedAt.create(d.getUpdatedAt()))
							.reference(ChatReference.create(d.getReference()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Chat with id " + d.getId());
					}

					DeleteChatCommand delete = DeleteChatCommand.builder()
						.id(ChatId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
