package com.groupe2cs.bizyhub.sync.application.command;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSyncStateCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private SyncStateId id = SyncStateId.create(UUID.randomUUID().toString());
	private SyncStateEntityTable entityTable;
	private SyncStateRemoteId remoteId;
	private SyncStateLocalId localId;
	private SyncStateAccount account;
	private SyncStateSyncAt syncAt;
	private SyncStateLastSyncAt lastSyncAt;
	private SyncStateLastCursor lastCursor;
	private SyncStateCreatedBy createdBy;
	private SyncStateTenant tenant;

	public CreateSyncStateCommand(

			SyncStateEntityTable entityTable,
			SyncStateRemoteId remoteId,
			SyncStateLocalId localId,
			SyncStateAccount account,
			SyncStateSyncAt syncAt,
			SyncStateLastSyncAt lastSyncAt,
			SyncStateLastCursor lastCursor,
			SyncStateCreatedBy createdBy,
			SyncStateTenant tenant
	) {
		this.id = SyncStateId.create(UUID.randomUUID().toString());

		this.entityTable = entityTable;
		this.remoteId = remoteId;
		this.localId = localId;
		this.account = account;
		this.syncAt = syncAt;
		this.lastSyncAt = lastSyncAt;
		this.lastCursor = lastCursor;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
