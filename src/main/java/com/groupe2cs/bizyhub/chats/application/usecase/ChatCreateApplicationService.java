package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.chats.application.command.CreateChatCommand;
import com.groupe2cs.bizyhub.chats.application.dto.ChatRequest;
import com.groupe2cs.bizyhub.chats.application.dto.ChatResponse;
import com.groupe2cs.bizyhub.chats.application.mapper.ChatMapper;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatCreatedBy;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatCreateApplicationService {
	private final CommandGateway commandGateway;

	public ChatResponse createChat(ChatRequest request,
								   MetaRequest metaRequest
	) {

		CreateChatCommand command = ChatMapper.toCommand(
				request
		);

		command.setCreatedBy(ChatCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(ChatTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return ChatMapper.toResponse(command);
	}


}
