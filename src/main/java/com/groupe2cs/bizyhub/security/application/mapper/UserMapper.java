package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteUserCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateUserCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;


public class UserMapper {

	public static UserResponse toResponse(User entity) {
		return new UserResponse(
				entity.getId(),
				entity.getUsername(),
				entity.getPassword()
		);
	}

	public static UserResponse toResponse(CreateUserCommand command) {
		return new UserResponse(
				command.getId().value(), command.getUsername().value(), command.getPassword().value()
		);
	}

	public static UserResponse toResponse(UpdateUserCommand command) {
		return new UserResponse(
				command.getId().value(), command.getUsername().value(), command.getPassword().value()
		);
	}


	public static CreateUserCommand toCommand(
			UserRequest request
	) {
		return new CreateUserCommand(
				UserUsername.create(request.getUsername()), UserPassword.create(request.getPassword())
		);
	}

	public static UpdateUserCommand toUpdateCommand(UserId id, UserRequest request) {
		return new UpdateUserCommand(
				id, UserUsername.create(request.getUsername()), UserPassword.create(request.getPassword())
		);
	}


	public static DeleteUserCommand toDeleteCommand(UserId id) {
		return new DeleteUserCommand(id);
	}
}
