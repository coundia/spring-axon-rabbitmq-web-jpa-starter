package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.chats.application.command.UpdateChatCommand;
import com.groupe2cs.bizyhub.chats.application.dto.ChatResponse;
import com.groupe2cs.bizyhub.chats.application.mapper.ChatMapper;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;

	public ChatResponse updateChat(
			ChatId id, List<MultipartFile> filesMultipartFile,
			String messages,
			String responsesJson,
			String responses,
			String state,
			String account
			,
			MetaRequest metaRequest
	) {

		UpdateChatCommand command = ChatMapper.toUpdateCommand(
				id,
				new ChatMessages(messages),
				new ChatResponsesJson(responsesJson),
				new ChatResponses(responses),
				new ChatState(state),
				new ChatAccount(account)
		);

		command.setCreatedBy(ChatCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(ChatTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		metaRequest.setObjectId(command.getId().value());
		metaRequest.setObjectName("chat");
		fileStorageService.storeFile(filesMultipartFile, metaRequest);

		return ChatMapper.toResponse(command);
	}


}
