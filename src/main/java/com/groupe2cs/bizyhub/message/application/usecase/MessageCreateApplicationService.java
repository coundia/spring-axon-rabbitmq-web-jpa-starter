package com.groupe2cs.bizyhub.message.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import com.groupe2cs.bizyhub.message.application.mapper.*;
import com.groupe2cs.bizyhub.message.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.message.application.dto.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageCreateApplicationService {
private final CommandGateway commandGateway;

public MessageResponse createMessage(MessageRequest request,
MetaRequest metaRequest
){

CreateMessageCommand command = MessageMapper.toCommand(
request
);

command.setCreatedBy(MessageCreatedBy.create(metaRequest.getUserId()));
command.setTenant(MessageTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return MessageMapper.toResponse(command);
}


}
