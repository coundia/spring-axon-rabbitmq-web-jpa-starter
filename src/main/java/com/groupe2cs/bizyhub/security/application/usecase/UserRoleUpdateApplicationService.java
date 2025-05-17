package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.UpdateUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.UserRoleMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public UserRoleResponse updateUserRole(UserRoleId id, UserRoleRequest request,
										   MetaRequest metaRequest
	) {

		UpdateUserRoleCommand command = UserRoleMapper.toUpdateCommand(
				id,
				request
		);

		if (metaRequest.getTenantId() != null) {
			//command.setTenant(UserRoleTenant.create(metaRequest.getTenantId()));
		}

		commandGateway.sendAndWait(command);

		return UserRoleMapper.toResponse(command);
	}

}
