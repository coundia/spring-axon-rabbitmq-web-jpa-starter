package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserRoleMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleCreateApplicationService {
	private final CommandGateway commandGateway;

	public UserRoleResponse createUserRole(UserRoleRequest request,
										   MetaRequest metaRequest
	) {

		CreateUserRoleCommand command = UserRoleMapper.toCommand(
				request
		);

		command.setCreatedBy(UserRoleCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(UserRoleTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return UserRoleMapper.toResponse(command);
	}


}
