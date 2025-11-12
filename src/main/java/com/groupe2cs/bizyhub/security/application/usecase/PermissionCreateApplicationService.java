package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreatePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.PermissionRequest;
import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.PermissionMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionCreateApplicationService {
	private final CommandGateway commandGateway;

	public PermissionResponse createPermission(PermissionRequest request,
											   MetaRequest metaRequest
	) {

		CreatePermissionCommand command = PermissionMapper.toCommand(
				request
		);

		command.setCreatedBy(PermissionCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(PermissionTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return PermissionMapper.toResponse(command);
	}


}
