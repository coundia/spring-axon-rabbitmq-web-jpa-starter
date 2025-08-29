package com.groupe2cs.bizyhub.sync.domain.event;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SyncStateCreatedEvent implements Serializable {

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
