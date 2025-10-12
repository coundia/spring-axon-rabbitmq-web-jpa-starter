package com.groupe2cs.bizyhub.security.application.mapper;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.domain.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.command.*;

public class PermissionMapper {

	public static PermissionResponse toResponse(Permission entity) {
		return PermissionResponse.builder()
				.id(entity.getId())
				.name(entity.getName())
				.createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername() : null)
				.tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
				.build();
	}

	public static PermissionResponse toResponse(CreatePermissionCommand command) {
		return PermissionResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.build();
	}

	public static PermissionResponse toResponse(UpdatePermissionCommand command) {
		return PermissionResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.build();
	}

	public static CreatePermissionCommand toCommand(
			PermissionRequest request
	) {
		return CreatePermissionCommand.builder()
				.name(PermissionName.create(request.getName()))
				.build();
	}

	public static UpdatePermissionCommand toUpdateCommand(PermissionId id, PermissionRequest request) {
		return UpdatePermissionCommand.builder()
				.id(id)
				.name(PermissionName.create(request.getName()))
				.build();
	}


	public static DeletePermissionCommand toDeleteCommand(PermissionId id) {
		return DeletePermissionCommand.builder()
				.id(id)
				.build();
	}
}
