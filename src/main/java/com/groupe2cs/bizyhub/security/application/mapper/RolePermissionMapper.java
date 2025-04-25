package com.groupe2cs.bizyhub.security.application.mapper;

	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.application.command.*;

public class RolePermissionMapper {

public static RolePermissionResponse toResponse(RolePermission entity) {
return RolePermissionResponse.builder()
		.id(entity.getId())
		.role(entity.getRole().getId())
		.permission(entity.getPermission().getId())
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
