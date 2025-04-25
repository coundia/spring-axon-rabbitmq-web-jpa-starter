package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeletePasswordResetCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordResetDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deletePasswordReset(PasswordResetId idVo) {

		DeletePasswordResetCommand command = new DeletePasswordResetCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
