package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreatePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.PermissionRequest;
import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PermissionMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionCreateApplicationService {
	private final CommandGateway commandGateway;

	public PermissionResponse createPermission(PermissionRequest request) {

		CreatePermissionCommand command = PermissionMapper.toCommand(
				request
		);
		commandGateway.sendAndWait(command);
		return PermissionMapper.toResponse(command);
	}


}
