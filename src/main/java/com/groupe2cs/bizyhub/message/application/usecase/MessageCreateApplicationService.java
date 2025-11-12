package com.groupe2cs.bizyhub.message.application.usecase;

import com.groupe2cs.bizyhub.message.application.command.CreateMessageCommand;
import com.groupe2cs.bizyhub.message.application.dto.MessageRequest;
import com.groupe2cs.bizyhub.message.application.dto.MessageResponse;
import com.groupe2cs.bizyhub.message.application.mapper.MessageMapper;
import com.groupe2cs.bizyhub.message.domain.valueObject.MessageCreatedBy;
import com.groupe2cs.bizyhub.message.domain.valueObject.MessageTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageCreateApplicationService {
	private final CommandGateway commandGateway;

	public MessageResponse createMessage(MessageRequest request,
										 MetaRequest metaRequest
	) {

		CreateMessageCommand command = MessageMapper.toCommand(
				request
		);

		command.setCreatedBy(MessageCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(MessageTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return MessageMapper.toResponse(command);
	}


}
