package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.DeleteRolePermissionCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolePermissionDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteRolePermission(RolePermissionId idVo) {

		DeleteRolePermissionCommand command = new DeleteRolePermissionCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
