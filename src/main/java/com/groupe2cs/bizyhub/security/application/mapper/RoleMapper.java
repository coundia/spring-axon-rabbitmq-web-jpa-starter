package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.domain.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.command.*;


public class RoleMapper {

public static RoleResponse toResponse(Role entity) {
return new RoleResponse(
		entity.getId(), 
		entity.getName()
);
}

public static RoleResponse toResponse(CreateRoleCommand command) {
return new RoleResponse(
command.getId().value(), command.getName().value()
);
}

public static RoleResponse toResponse(UpdateRoleCommand command) {
return new RoleResponse(
command.getId().value(), command.getName().value()
);
}


public static CreateRoleCommand toCommand(
RoleRequest request
) {
return new CreateRoleCommand(
RoleName.create(request.getName())
);
}
public static UpdateRoleCommand toUpdateCommand(RoleId id, RoleRequest request) {
return new UpdateRoleCommand(
id, RoleName.create(request.getName())
);
}


public static DeleteRoleCommand toDeleteCommand(RoleId id) {
return new DeleteRoleCommand(id);
}
}
