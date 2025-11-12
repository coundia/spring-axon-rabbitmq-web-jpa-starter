package com.groupe2cs.bizyhub.message.application.usecase;

import com.groupe2cs.bizyhub.message.application.command.DeleteMessageCommand;
import com.groupe2cs.bizyhub.message.domain.valueObject.MessageId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteMessage(MessageId idVo, MetaRequest metaRequest) {

		DeleteMessageCommand command = new DeleteMessageCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
