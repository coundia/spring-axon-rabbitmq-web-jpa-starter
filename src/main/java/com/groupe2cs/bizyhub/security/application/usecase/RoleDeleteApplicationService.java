package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeleteRoleCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteRole(RoleId idVo) {

		DeleteRoleCommand command = new DeleteRoleCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
