package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.command.CreateRoleCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteRoleCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.RoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleName;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;


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
