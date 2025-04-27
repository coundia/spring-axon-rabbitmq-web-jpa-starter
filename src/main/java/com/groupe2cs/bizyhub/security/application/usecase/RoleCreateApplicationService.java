package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.RoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RoleMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleCreateApplicationService {
	private final CommandGateway commandGateway;

	public RoleResponse createRole(RoleRequest request,
								   MetaRequest metaRequest
	) {

		CreateRoleCommand command = RoleMapper.toCommand(
				request
		);

		command.setCreatedBy(RoleCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(RoleTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return RoleMapper.toResponse(command);
	}


}
