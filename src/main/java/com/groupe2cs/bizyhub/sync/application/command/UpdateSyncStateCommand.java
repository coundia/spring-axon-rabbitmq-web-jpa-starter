package com.groupe2cs.bizyhub.sync.application.command;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateSyncStateCommand implements Serializable {
	@TargetAggregateIdentifier
	private SyncStateId id;
	private SyncStateEntityTable entityTable;
	private SyncStateRemoteId remoteId;
	private SyncStateLocalId localId;
	private SyncStateAccount account;
	private SyncStateSyncAt syncAt;
	private SyncStateLastSyncAt lastSyncAt;
	private SyncStateLastCursor lastCursor;
	private SyncStateCreatedBy createdBy;
	private SyncStateTenant tenant;


}
