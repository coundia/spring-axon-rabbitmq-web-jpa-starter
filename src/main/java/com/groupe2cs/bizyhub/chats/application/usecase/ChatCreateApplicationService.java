package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.chats.application.command.CreateChatCommand;
import com.groupe2cs.bizyhub.chats.application.dto.ChatRequest;
import com.groupe2cs.bizyhub.chats.application.dto.ChatResponse;
import com.groupe2cs.bizyhub.chats.application.mapper.ChatMapper;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatCreatedBy;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatFiles;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatCreateApplicationService {
	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;

	public ChatResponse createChat(
			List<MultipartFile> files,
			String messages,
			String responsesJson,
			String responses,
			String state,
			String account
			,
			MetaRequest metaRequest
	) {

		ChatRequest request = new ChatRequest(
				messages,
				responsesJson,
				responses,
				state,
				account
		);

		CreateChatCommand command = ChatMapper.toCommand(
				request
		);

		command.setCreatedBy(ChatCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(ChatTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		metaRequest.setObjectId(command.getId().value());
		metaRequest.setObjectName("chat");
		ChatFiles.create(
				fileStorageService.storeFile(files, metaRequest)
		);
		return ChatMapper.toResponse(command);
	}


}
