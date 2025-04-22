package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionRequest;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RolePermissionMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolePermissionCreateApplicationService {
	private final CommandGateway commandGateway;

	public RolePermissionResponse createRolePermission(RolePermissionRequest request) {

		CreateRolePermissionCommand command = RolePermissionMapper.toCommand(
				request
		);
		commandGateway.sendAndWait(command);
		return RolePermissionMapper.toResponse(command);
	}


}
