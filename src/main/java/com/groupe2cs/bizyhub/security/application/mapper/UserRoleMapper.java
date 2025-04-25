package com.groupe2cs.bizyhub.security.application.mapper;

	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.application.command.*;

public class UserRoleMapper {

public static UserRoleResponse toResponse(UserRole entity) {
return UserRoleResponse.builder()
		.id(entity.getId())
		.user(entity.getUser().getId())
		.role(entity.getRole().getId())
.build();
}

public static UserRoleResponse toResponse(CreateUserRoleCommand command) {
return UserRoleResponse.builder()
	.id(command.getId().value())
	.user(command.getUser().value())
	.role(command.getRole().value())
.build();
}

public static UserRoleResponse toResponse(UpdateUserRoleCommand command) {
return UserRoleResponse.builder()
	.id(command.getId().value())
	.user(command.getUser().value())
	.role(command.getRole().value())
.build();
}

public static CreateUserRoleCommand toCommand(
UserRoleRequest request
) {
return CreateUserRoleCommand.builder()
	.user(UserRoleUser.create(request.getUser()))
	.role(UserRoleRole.create(request.getRole()))
.build();
}

	public static UpdateUserRoleCommand toUpdateCommand(UserRoleId id, UserRoleRequest request) {
	return UpdateUserRoleCommand.builder()
	.id(id)
		.user(UserRoleUser.create(request.getUser()))
		.role(UserRoleRole.create(request.getRole()))
	.build();
	}


public static DeleteUserRoleCommand toDeleteCommand(UserRoleId id) {
return DeleteUserRoleCommand.builder()
.id(id)
.build();
}
}
