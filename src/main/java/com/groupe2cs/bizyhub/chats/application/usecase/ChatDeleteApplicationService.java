package com.groupe2cs.bizyhub.chats.application.usecase;

import com.groupe2cs.bizyhub.chats.application.command.DeleteChatCommand;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteChat(ChatId idVo, MetaRequest metaRequest) {

		DeleteChatCommand command = new DeleteChatCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
