package com.groupe2cs.bizyhub.security.application.mapper;

	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.application.command.*;

public class UserMapper {

public static UserResponse toResponse(User entity) {
return UserResponse.builder()
		.id(entity.getId())
		.username(entity.getUsername())
		.password(entity.getPassword())
.build();
}

public static UserResponse toResponse(CreateUserCommand command) {
return UserResponse.builder()
	.id(command.getId().value())
	.username(command.getUsername().value())
	.password(command.getPassword().value())
.build();
}

public static UserResponse toResponse(UpdateUserCommand command) {
return UserResponse.builder()
	.id(command.getId().value())
	.username(command.getUsername().value())
	.password(command.getPassword().value())
.build();
}

public static CreateUserCommand toCommand(
UserRequest request
) {
return CreateUserCommand.builder()
	.username(UserUsername.create(request.getUsername()))
	.password(UserPassword.create(request.getPassword()))
.build();
}

	public static UpdateUserCommand toUpdateCommand(UserId id, UserRequest request) {
	return UpdateUserCommand.builder()
	.id(id)
		.username(UserUsername.create(request.getUsername()))
		.password(UserPassword.create(request.getPassword()))
	.build();
	}


public static DeleteUserCommand toDeleteCommand(UserId id) {
return DeleteUserCommand.builder()
.id(id)
.build();
}
}
