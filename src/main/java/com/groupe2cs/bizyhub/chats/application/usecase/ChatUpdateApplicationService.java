package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.chats.application.command.UpdateChatCommand;
import com.groupe2cs.bizyhub.chats.application.dto.ChatRequest;
import com.groupe2cs.bizyhub.chats.application.dto.ChatResponse;
import com.groupe2cs.bizyhub.chats.application.mapper.ChatMapper;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public ChatResponse updateChat(ChatId id, ChatRequest request,
								   MetaRequest metaRequest
	) {

		UpdateChatCommand command = ChatMapper.toUpdateCommand(
				id,
				request
		);

		if (metaRequest.getTenantId() != null) {
			//command.setTenant(ChatTenant.create(metaRequest.getTenantId()));
		}

		commandGateway.sendAndWait(command);

		return ChatMapper.toResponse(command);
	}

}
