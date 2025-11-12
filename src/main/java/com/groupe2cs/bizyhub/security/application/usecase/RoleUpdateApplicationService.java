package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.UpdateRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.RoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RoleMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public RoleResponse updateRole(RoleId id, RoleRequest request,
								   MetaRequest metaRequest
	) {

		UpdateRoleCommand command = RoleMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(RoleCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(RoleTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return RoleMapper.toResponse(command);
	}

}
