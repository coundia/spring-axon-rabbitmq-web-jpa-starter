package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.chats.application.command.CreateChatCommand;
import com.groupe2cs.bizyhub.chats.application.command.DeleteChatCommand;
import com.groupe2cs.bizyhub.chats.application.command.UpdateChatCommand;
import com.groupe2cs.bizyhub.chats.application.dto.ChatSyncRequest;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatSyncApplicationService {

	private final ChatGate gateService;
	private final CommandGateway commandGateway;
	private final UserValidationService userValidationService;

	public void syncChat(ChatSyncRequest request, MetaRequest metaRequest) {

		userValidationService.shouldBePremiumUser(metaRequest.getUserId()) ;

		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateChatCommand command = CreateChatCommand.builder()
							.messages(ChatMessages.create(d.getMessages()))
							.responsesJson(ChatResponsesJson.create(d.getResponsesJson()))
							.responses(ChatResponses.create(d.getResponses()))
							.state(ChatState.create(d.getState()))
							.syncAt(ChatSyncAt.create(d.getSyncAt()))
							.remoteId(ChatRemoteId.create(d.getRemoteId()))
							.localId(ChatLocalId.create(d.getLocalId()))
							.account(ChatAccount.create(d.getAccount()))
							.dateTransaction(ChatDateTransaction.create(d.getDateTransaction()))
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
							.syncAt(ChatSyncAt.create(d.getSyncAt()))
							.remoteId(ChatRemoteId.create(d.getRemoteId()))
							.localId(ChatLocalId.create(d.getLocalId()))
							.account(ChatAccount.create(d.getAccount()))
							.dateTransaction(ChatDateTransaction.create(d.getDateTransaction()))
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
