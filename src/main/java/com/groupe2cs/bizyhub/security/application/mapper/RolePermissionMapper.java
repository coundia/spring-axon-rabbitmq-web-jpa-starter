package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.domain.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.command.*;


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
id, RolePermissionRole.create(request.getRole()), RolePermissionPermission.create(request.getPermission())
);
}


public static DeleteRolePermissionCommand toDeleteCommand(RolePermissionId id) {
return new DeleteRolePermissionCommand(id);
}
}
