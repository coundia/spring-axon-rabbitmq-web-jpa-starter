package com.groupe2cs.bizyhub.units.application.mapper;

	import com.groupe2cs.bizyhub.units.application.dto.*;
	import com.groupe2cs.bizyhub.units.domain.valueObject.*;
	import com.groupe2cs.bizyhub.units.domain.*;
	import com.groupe2cs.bizyhub.units.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.units.application.command.*;

public class UnitMapper {

public static UnitResponse toResponse(Unit entity) {
return UnitResponse.builder()
		.id(entity.getId())
		.remoteId(entity.getRemoteId())
		.code(entity.getCode())
		.name(entity.getName())
		.syncAt(entity.getSyncAt())
		.description(entity.getDescription())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static UnitResponse toResponse(CreateUnitCommand command) {
return UnitResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.code(command.getCode().value())
	.name(command.getName().value())
	.syncAt(command.getSyncAt().value())
	.description(command.getDescription().value())
.build();
}

public static UnitResponse toResponse(UpdateUnitCommand command) {
return UnitResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.code(command.getCode().value())
	.name(command.getName().value())
	.syncAt(command.getSyncAt().value())
	.description(command.getDescription().value())
.build();
}

public static CreateUnitCommand toCommand(
UnitRequest request
) {
return CreateUnitCommand.builder()
	.remoteId(UnitRemoteId.create(request.getRemoteId()))
	.code(UnitCode.create(request.getCode()))
	.name(UnitName.create(request.getName()))
	.syncAt(UnitSyncAt.create(request.getSyncAt()))
	.description(UnitDescription.create(request.getDescription()))
.build();
}

	public static UpdateUnitCommand toUpdateCommand(UnitId id, UnitRequest request) {
	return UpdateUnitCommand.builder()
	.id(id)
		.remoteId(UnitRemoteId.create(request.getRemoteId()))
		.code(UnitCode.create(request.getCode()))
		.name(UnitName.create(request.getName()))
		.syncAt(UnitSyncAt.create(request.getSyncAt()))
		.description(UnitDescription.create(request.getDescription()))
	.build();
	}


public static DeleteUnitCommand toDeleteCommand(UnitId id) {
return DeleteUnitCommand.builder()
.id(id)
.build();
}
}
