package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteUserCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateUserCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;

public class UserMapper {

	public static UserResponse toResponse(CustomUser entity) {
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
