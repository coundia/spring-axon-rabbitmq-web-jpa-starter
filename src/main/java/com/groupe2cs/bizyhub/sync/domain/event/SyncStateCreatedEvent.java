package com.groupe2cs.bizyhub.sync.domain.event;

	import com.groupe2cs.bizyhub.sync.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SyncStateCreatedEvent implements Serializable {

	private SyncStateId id;
	private SyncStateEntityTable entityTable;
	private SyncStateRemoteId remoteId;
	private SyncStateLocalId localId;
	private SyncStateSyncAt syncAt;
	private SyncStateLastSyncAt lastSyncAt;
	private SyncStateLastCursor lastCursor;
	private SyncStateCreatedBy createdBy;
	private SyncStateTenant tenant;



}
