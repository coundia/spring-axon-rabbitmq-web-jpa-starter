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
		return RolePermissionResponse.builder()
				.id(entity.getId())
				.role(entity.getRole() != null ? entity.getRole().getId() : null)
				.permission(entity.getPermission() != null ? entity.getPermission().getId() : null)
				.createdBy(entity.getCreatedBy().getUsername())
				.tenant(entity.getTenant().getName())
				.build();
	}

	public static RolePermissionResponse toResponse(CreateRolePermissionCommand command) {
		return RolePermissionResponse.builder()
				.id(command.getId().value())
				.role(command.getRole().value())
				.permission(command.getPermission().value())
				.build();
	}

	public static RolePermissionResponse toResponse(UpdateRolePermissionCommand command) {
		return RolePermissionResponse.builder()
				.id(command.getId().value())
				.role(command.getRole().value())
				.permission(command.getPermission().value())
				.build();
	}

	public static CreateRolePermissionCommand toCommand(
			RolePermissionRequest request
	) {
		return CreateRolePermissionCommand.builder()
				.role(RolePermissionRole.create(request.getRole()))
				.permission(RolePermissionPermission.create(request.getPermission()))
				.build();
	}

	public static UpdateRolePermissionCommand toUpdateCommand(RolePermissionId id, RolePermissionRequest request) {
		return UpdateRolePermissionCommand.builder()
				.id(id)
				.role(RolePermissionRole.create(request.getRole()))
				.permission(RolePermissionPermission.create(request.getPermission()))
				.build();
	}


	public static DeleteRolePermissionCommand toDeleteCommand(RolePermissionId id) {
		return DeleteRolePermissionCommand.builder()
				.id(id)
				.build();
	}
}
