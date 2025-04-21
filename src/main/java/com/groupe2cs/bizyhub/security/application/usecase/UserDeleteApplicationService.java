package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeleteUserCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteUser(UserId idVo) {

		DeleteUserCommand command = new DeleteUserCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
