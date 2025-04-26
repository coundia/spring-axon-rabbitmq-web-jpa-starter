package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.CreateUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserRoleMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleCreatedBy;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleCreateApplicationService {
	private final CommandGateway commandGateway;

	public UserRoleResponse createUserRole(UserRoleRequest request,
										   String createdBy) {

		CreateUserRoleCommand command = UserRoleMapper.toCommand(
				request
		);

		if (createdBy != null) {
			command.setCreatedBy(UserRoleCreatedBy.create(createdBy));
		}

		commandGateway.sendAndWait(command);
		return UserRoleMapper.toResponse(command);
	}


}
