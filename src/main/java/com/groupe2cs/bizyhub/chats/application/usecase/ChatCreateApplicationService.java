package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.chats.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.chats.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatCreateApplicationService {
private final CommandGateway commandGateway;

public ChatResponse createChat(ChatRequest request,
MetaRequest metaRequest
){

CreateChatCommand command = ChatMapper.toCommand(
request
);

command.setCreatedBy(ChatCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(ChatTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return ChatMapper.toResponse(command);
}


}
