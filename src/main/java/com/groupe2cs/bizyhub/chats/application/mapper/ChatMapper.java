package com.groupe2cs.bizyhub.chats.application.mapper;

	import com.groupe2cs.bizyhub.chats.application.dto.*;
	import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
	import com.groupe2cs.bizyhub.chats.domain.*;
	import com.groupe2cs.bizyhub.chats.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.chats.application.command.*;

public class ChatMapper {

public static ChatResponse toResponse(Chat entity) {
return ChatResponse.builder()
		.id(entity.getId())
		.messages(entity.getMessages())
		.responsesJson(entity.getResponsesJson())
		.responses(entity.getResponses())
		.state(entity.getState())
		.syncAt(entity.getSyncAt())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.account(entity.getAccount())
		.dateTransaction(entity.getDateTransaction())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static ChatResponse toResponse(CreateChatCommand command) {
return ChatResponse.builder()
	.id(command.getId().value())
	.messages(command.getMessages().value())
	.responsesJson(command.getResponsesJson().value())
	.responses(command.getResponses().value())
	.state(command.getState().value())
	.syncAt(command.getSyncAt().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.account(command.getAccount().value())
	.dateTransaction(command.getDateTransaction().value())
.build();
}

public static ChatResponse toResponse(UpdateChatCommand command) {
return ChatResponse.builder()
	.id(command.getId().value())
	.messages(command.getMessages().value())
	.responsesJson(command.getResponsesJson().value())
	.responses(command.getResponses().value())
	.state(command.getState().value())
	.syncAt(command.getSyncAt().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.account(command.getAccount().value())
	.dateTransaction(command.getDateTransaction().value())
.build();
}

public static CreateChatCommand toCommand(
ChatRequest request
) {
return CreateChatCommand.builder()
	.messages(ChatMessages.create(request.getMessages()))
	.responsesJson(ChatResponsesJson.create(request.getResponsesJson()))
	.responses(ChatResponses.create(request.getResponses()))
	.state(ChatState.create(request.getState()))
	.syncAt(ChatSyncAt.create(request.getSyncAt()))
	.remoteId(ChatRemoteId.create(request.getRemoteId()))
	.localId(ChatLocalId.create(request.getLocalId()))
	.account(ChatAccount.create(request.getAccount()))
	.dateTransaction(ChatDateTransaction.create(request.getDateTransaction()))
.build();
}

	public static UpdateChatCommand toUpdateCommand(ChatId id, ChatRequest request) {
	return UpdateChatCommand.builder()
	.id(id)
		.messages(ChatMessages.create(request.getMessages()))
		.responsesJson(ChatResponsesJson.create(request.getResponsesJson()))
		.responses(ChatResponses.create(request.getResponses()))
		.state(ChatState.create(request.getState()))
		.syncAt(ChatSyncAt.create(request.getSyncAt()))
		.remoteId(ChatRemoteId.create(request.getRemoteId()))
		.localId(ChatLocalId.create(request.getLocalId()))
		.account(ChatAccount.create(request.getAccount()))
		.dateTransaction(ChatDateTransaction.create(request.getDateTransaction()))
	.build();
	}


public static DeleteChatCommand toDeleteCommand(ChatId id) {
return DeleteChatCommand.builder()
.id(id)
.build();
}
}
