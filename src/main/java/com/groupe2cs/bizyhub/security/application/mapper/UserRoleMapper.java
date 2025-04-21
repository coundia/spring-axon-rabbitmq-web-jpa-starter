package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.command.CreateUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleRole;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleUser;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;


public class UserRoleMapper {

	public static UserRoleResponse toResponse(UserRole entity) {
		return new UserRoleResponse(
				entity.getId(),
				entity.getUser().getId(),
				entity.getRole().getId()
		);
	}

	public static UserRoleResponse toResponse(CreateUserRoleCommand command) {
		return new UserRoleResponse(
				command.getId().value(), command.getUser().value(), command.getRole().value()
		);
	}

	public static UserRoleResponse toResponse(UpdateUserRoleCommand command) {
		return new UserRoleResponse(
				command.getId().value(), command.getUser().value(), command.getRole().value()
		);
	}


	public static CreateUserRoleCommand toCommand(
			UserRoleRequest request
	) {
		return new CreateUserRoleCommand(
				UserRoleUser.create(request.getUser()), UserRoleRole.create(request.getRole())
		);
	}

	public static UpdateUserRoleCommand toUpdateCommand(UserRoleId id, UserRoleRequest request) {
		return new UpdateUserRoleCommand(
				id, UserRoleUser.create(request.getUser()), UserRoleRole.create(request.getRole())
		);
	}


	public static DeleteUserRoleCommand toDeleteCommand(UserRoleId id) {
		return new DeleteUserRoleCommand(id);
	}
}
