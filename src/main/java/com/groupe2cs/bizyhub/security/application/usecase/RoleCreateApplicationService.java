package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.RoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleCreateApplicationService {
	private final CommandGateway commandGateway;

	public RoleResponse createRole(RoleRequest request) {

		CreateRoleCommand command = RoleMapper.toCommand(
				request
		);
		commandGateway.sendAndWait(command);
		return RoleMapper.toResponse(command);
	}


}
