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
		return RoleResponse.builder()
				.id(entity.getId())
				.name(entity.getName())
				.createdBy(entity.getCreatedBy().getUsername())
				.tenant(entity.getTenant().getName())
				.build();
	}

	public static RoleResponse toResponse(CreateRoleCommand command) {
		return RoleResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.build();
	}

	public static RoleResponse toResponse(UpdateRoleCommand command) {
		return RoleResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.build();
	}

	public static CreateRoleCommand toCommand(
			RoleRequest request
	) {
		return CreateRoleCommand.builder()
				.name(RoleName.create(request.getName()))
				.build();
	}

	public static UpdateRoleCommand toUpdateCommand(RoleId id, RoleRequest request) {
		return UpdateRoleCommand.builder()
				.id(id)
				.name(RoleName.create(request.getName()))
				.build();
	}


	public static DeleteRoleCommand toDeleteCommand(RoleId id) {
		return DeleteRoleCommand.builder()
				.id(id)
				.build();
	}
}
