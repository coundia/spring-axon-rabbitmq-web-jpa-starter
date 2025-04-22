package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.command.CreateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionRequest;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionPermission;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionRole;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;


public class RolePermissionMapper {

	public static RolePermissionResponse toResponse(RolePermission entity) {
		return new RolePermissionResponse(
				entity.getId(),
				entity.getRole().getId(),
				entity.getPermission().getId()
		);
	}

	public static RolePermissionResponse toResponse(CreateRolePermissionCommand command) {
		return new RolePermissionResponse(
				command.getId().value(), command.getRole().value(), command.getPermission().value()
		);
	}

	public static RolePermissionResponse toResponse(UpdateRolePermissionCommand command) {
		return new RolePermissionResponse(
				command.getId().value(), command.getRole().value(), command.getPermission().value()
		);
	}


	public static CreateRolePermissionCommand toCommand(
			RolePermissionRequest request
	) {
		return new CreateRolePermissionCommand(
				RolePermissionRole.create(request.getRole()), RolePermissionPermission.create(request.getPermission())
		);
	}

	public static UpdateRolePermissionCommand toUpdateCommand(RolePermissionId id, RolePermissionRequest request) {
		return new UpdateRolePermissionCommand(
				id,
				RolePermissionRole.create(request.getRole()),
				RolePermissionPermission.create(request.getPermission())
		);
	}


	public static DeleteRolePermissionCommand toDeleteCommand(RolePermissionId id) {
		return new DeleteRolePermissionCommand(id);
	}
}
