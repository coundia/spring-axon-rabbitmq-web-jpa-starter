package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionRequest;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RolePermissionMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolePermissionCreateApplicationService {
	private final CommandGateway commandGateway;

	public RolePermissionResponse createRolePermission(RolePermissionRequest request,
													   MetaRequest metaRequest
	) {

		CreateRolePermissionCommand command = RolePermissionMapper.toCommand(
				request
		);

		command.setCreatedBy(RolePermissionCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(RolePermissionTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return RolePermissionMapper.toResponse(command);
	}


}
