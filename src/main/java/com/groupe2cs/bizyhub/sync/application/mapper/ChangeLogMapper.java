package com.groupe2cs.bizyhub.sync.application.mapper;

	import com.groupe2cs.bizyhub.sync.application.dto.*;
	import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
	import com.groupe2cs.bizyhub.sync.domain.*;
	import com.groupe2cs.bizyhub.sync.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.sync.application.command.*;

public class ChangeLogMapper {

public static ChangeLogResponse toResponse(ChangeLog entity) {
return ChangeLogResponse.builder()
		.id(entity.getId())
		.entityTable(entity.getEntityTable())
		.account(entity.getAccount())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.operation(entity.getOperation())
		.payload(entity.getPayload())
		.status(entity.getStatus())
		.syncAt(entity.getSyncAt())
		.attempts(entity.getAttempts())
		.error(entity.getError())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static ChangeLogResponse toResponse(CreateChangeLogCommand command) {
return ChangeLogResponse.builder()
	.id(command.getId().value())
	.entityTable(command.getEntityTable().value())
	.account(command.getAccount().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.operation(command.getOperation().value())
	.payload(command.getPayload().value())
	.status(command.getStatus().value())
	.syncAt(command.getSyncAt().value())
	.attempts(command.getAttempts().value())
	.error(command.getError().value())
.build();
}

public static ChangeLogResponse toResponse(UpdateChangeLogCommand command) {
return ChangeLogResponse.builder()
	.id(command.getId().value())
	.entityTable(command.getEntityTable().value())
	.account(command.getAccount().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.operation(command.getOperation().value())
	.payload(command.getPayload().value())
	.status(command.getStatus().value())
	.syncAt(command.getSyncAt().value())
	.attempts(command.getAttempts().value())
	.error(command.getError().value())
.build();
}

public static CreateChangeLogCommand toCommand(
ChangeLogRequest request
) {
return CreateChangeLogCommand.builder()
	.entityTable(ChangeLogEntityTable.create(request.getEntityTable()))
	.account(ChangeLogAccount.create(request.getAccount()))
	.remoteId(ChangeLogRemoteId.create(request.getRemoteId()))
	.localId(ChangeLogLocalId.create(request.getLocalId()))
	.operation(ChangeLogOperation.create(request.getOperation()))
	.payload(ChangeLogPayload.create(request.getPayload()))
	.status(ChangeLogStatus.create(request.getStatus()))
	.syncAt(ChangeLogSyncAt.create(request.getSyncAt()))
	.attempts(ChangeLogAttempts.create(request.getAttempts()))
	.error(ChangeLogError.create(request.getError()))
.build();
}

	public static UpdateChangeLogCommand toUpdateCommand(ChangeLogId id, ChangeLogRequest request) {
	return UpdateChangeLogCommand.builder()
	.id(id)
		.entityTable(ChangeLogEntityTable.create(request.getEntityTable()))
		.account(ChangeLogAccount.create(request.getAccount()))
		.remoteId(ChangeLogRemoteId.create(request.getRemoteId()))
		.localId(ChangeLogLocalId.create(request.getLocalId()))
		.operation(ChangeLogOperation.create(request.getOperation()))
		.payload(ChangeLogPayload.create(request.getPayload()))
		.status(ChangeLogStatus.create(request.getStatus()))
		.syncAt(ChangeLogSyncAt.create(request.getSyncAt()))
		.attempts(ChangeLogAttempts.create(request.getAttempts()))
		.error(ChangeLogError.create(request.getError()))
	.build();
	}


public static DeleteChangeLogCommand toDeleteCommand(ChangeLogId id) {
return DeleteChangeLogCommand.builder()
.id(id)
.build();
}
}
