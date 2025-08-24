package com.groupe2cs.bizyhub.sync.application.mapper;

	import com.groupe2cs.bizyhub.sync.application.dto.*;
	import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
	import com.groupe2cs.bizyhub.sync.domain.*;
	import com.groupe2cs.bizyhub.sync.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.sync.application.command.*;

public class SyncStateMapper {

public static SyncStateResponse toResponse(SyncState entity) {
return SyncStateResponse.builder()
		.id(entity.getId())
		.entityTable(entity.getEntityTable())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.syncAt(entity.getSyncAt())
		.lastSyncAt(entity.getLastSyncAt())
		.lastCursor(entity.getLastCursor())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static SyncStateResponse toResponse(CreateSyncStateCommand command) {
return SyncStateResponse.builder()
	.id(command.getId().value())
	.entityTable(command.getEntityTable().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.syncAt(command.getSyncAt().value())
	.lastSyncAt(command.getLastSyncAt().value())
	.lastCursor(command.getLastCursor().value())
.build();
}

public static SyncStateResponse toResponse(UpdateSyncStateCommand command) {
return SyncStateResponse.builder()
	.id(command.getId().value())
	.entityTable(command.getEntityTable().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.syncAt(command.getSyncAt().value())
	.lastSyncAt(command.getLastSyncAt().value())
	.lastCursor(command.getLastCursor().value())
.build();
}

public static CreateSyncStateCommand toCommand(
SyncStateRequest request
) {
return CreateSyncStateCommand.builder()
	.entityTable(SyncStateEntityTable.create(request.getEntityTable()))
	.remoteId(SyncStateRemoteId.create(request.getRemoteId()))
	.localId(SyncStateLocalId.create(request.getLocalId()))
	.syncAt(SyncStateSyncAt.create(request.getSyncAt()))
	.lastSyncAt(SyncStateLastSyncAt.create(request.getLastSyncAt()))
	.lastCursor(SyncStateLastCursor.create(request.getLastCursor()))
.build();
}

	public static UpdateSyncStateCommand toUpdateCommand(SyncStateId id, SyncStateRequest request) {
	return UpdateSyncStateCommand.builder()
	.id(id)
		.entityTable(SyncStateEntityTable.create(request.getEntityTable()))
		.remoteId(SyncStateRemoteId.create(request.getRemoteId()))
		.localId(SyncStateLocalId.create(request.getLocalId()))
		.syncAt(SyncStateSyncAt.create(request.getSyncAt()))
		.lastSyncAt(SyncStateLastSyncAt.create(request.getLastSyncAt()))
		.lastCursor(SyncStateLastCursor.create(request.getLastCursor()))
	.build();
	}


public static DeleteSyncStateCommand toDeleteCommand(SyncStateId id) {
return DeleteSyncStateCommand.builder()
.id(id)
.build();
}
}
