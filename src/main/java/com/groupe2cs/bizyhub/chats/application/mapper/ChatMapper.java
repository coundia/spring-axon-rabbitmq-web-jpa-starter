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
		.responses(entity.getResponses())
		.state(entity.getState())
		.account(entity.getAccount() != null ? entity.getAccount().getId() : null)
		.updatedAt(entity.getUpdatedAt())
		.reference(entity.getReference())
.build();
}

public static ChatResponse toResponse(CreateChatCommand command) {
return ChatResponse.builder()
	.id(command.getId().value())
	.messages(command.getMessages().value())
	.responses(command.getResponses().value())
	.state(command.getState().value())
	.account(command.getAccount().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static ChatResponse toResponse(UpdateChatCommand command) {
return ChatResponse.builder()
	.id(command.getId().value())
	.messages(command.getMessages().value())
	.responses(command.getResponses().value())
	.state(command.getState().value())
	.account(command.getAccount().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CreateChatCommand toCommand(
ChatRequest request
) {
return CreateChatCommand.builder()
	.messages(ChatMessages.create(request.getMessages()))
	.responses(ChatResponses.create(request.getResponses()))
	.state(ChatState.create(request.getState()))
	.account(ChatAccount.create(request.getAccount()))
	.updatedAt(ChatUpdatedAt.create(request.getUpdatedAt()))
	.reference(ChatReference.create(request.getReference()))
.build();
}

	public static UpdateChatCommand toUpdateCommand(ChatId id, ChatRequest request) {
	return UpdateChatCommand.builder()
	.id(id)
		.messages(ChatMessages.create(request.getMessages()))
		.responses(ChatResponses.create(request.getResponses()))
		.state(ChatState.create(request.getState()))
		.account(ChatAccount.create(request.getAccount()))
		.updatedAt(ChatUpdatedAt.create(request.getUpdatedAt()))
		.reference(ChatReference.create(request.getReference()))
	.build();
	}


public static DeleteChatCommand toDeleteCommand(ChatId id) {
return DeleteChatCommand.builder()
.id(id)
.build();
}
}
