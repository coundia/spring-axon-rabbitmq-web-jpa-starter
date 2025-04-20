package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.domain.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.command.*;


public class PermissionMapper {

public static PermissionResponse toResponse(Permission entity) {
return new PermissionResponse(
		entity.getId(), 
		entity.getName()
);
}

public static PermissionResponse toResponse(CreatePermissionCommand command) {
return new PermissionResponse(
command.getId().value(), command.getName().value()
);
}

public static PermissionResponse toResponse(UpdatePermissionCommand command) {
return new PermissionResponse(
command.getId().value(), command.getName().value()
);
}


public static CreatePermissionCommand toCommand(
PermissionRequest request
) {
return new CreatePermissionCommand(
PermissionName.create(request.getName())
);
}
public static UpdatePermissionCommand toUpdateCommand(PermissionId id, PermissionRequest request) {
return new UpdatePermissionCommand(
id, PermissionName.create(request.getName())
);
}


public static DeletePermissionCommand toDeleteCommand(PermissionId id) {
return new DeletePermissionCommand(id);
}
}
