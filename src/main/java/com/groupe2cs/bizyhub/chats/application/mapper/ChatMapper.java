package com.groupe2cs.bizyhub.chats.application.mapper;

import com.groupe2cs.bizyhub.chats.application.command.CreateChatCommand;
import com.groupe2cs.bizyhub.chats.application.command.DeleteChatCommand;
import com.groupe2cs.bizyhub.chats.application.command.UpdateChatCommand;
import com.groupe2cs.bizyhub.chats.application.dto.ChatRequest;
import com.groupe2cs.bizyhub.chats.application.dto.ChatResponse;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.Chat;

public class ChatMapper {

	public static ChatResponse toResponse(Chat entity) {
		return ChatResponse.builder()
				.id(entity.getId())
				.messages(entity.getMessages())
				.responsesJson(entity.getResponsesJson())
				.responses(entity.getResponses())
				.state(entity.getState())
				.account(entity.getAccount() != null ? entity.getAccount().getId() : null)
				.createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername() : null)
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
				.account(command.getAccount().value())
				.build();
	}

	public static ChatResponse toResponse(UpdateChatCommand command) {
		return ChatResponse.builder()
				.id(command.getId().value())
				.messages(command.getMessages().value())
				.responsesJson(command.getResponsesJson().value())
				.responses(command.getResponses().value())
				.state(command.getState().value())
				.account(command.getAccount().value())
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
				.account(ChatAccount.create(request.getAccount()))
				.build();
	}


	public static UpdateChatCommand toUpdateCommand(
			ChatId id, ChatMessages messages, ChatResponsesJson responsesJson, ChatResponses responses, ChatState state, ChatAccount account
	) {
		return UpdateChatCommand.builder()
				.id(id)
				.messages(messages)
				.responsesJson(responsesJson)
				.responses(responses)
				.state(state)
				.account(account)
				.build();
	}

	public static DeleteChatCommand toDeleteCommand(ChatId id) {
		return DeleteChatCommand.builder()
				.id(id)
				.build();
	}
}
