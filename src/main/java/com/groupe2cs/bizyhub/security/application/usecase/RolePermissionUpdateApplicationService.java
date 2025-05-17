package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.UpdateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionRequest;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.mapper.RolePermissionMapper;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolePermissionUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public RolePermissionResponse updateRolePermission(RolePermissionId id, RolePermissionRequest request,
													   MetaRequest metaRequest
	) {

		UpdateRolePermissionCommand command = RolePermissionMapper.toUpdateCommand(
				id,
				request
		);

		if (metaRequest.getTenantId() != null) {
			//command.setTenant(RolePermissionTenant.create(metaRequest.getTenantId()));
		}

		commandGateway.sendAndWait(command);

		return RolePermissionMapper.toResponse(command);
	}

}
