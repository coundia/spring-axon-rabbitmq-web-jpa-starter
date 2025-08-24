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
public class ChangeLogCreatedEvent implements Serializable {

	private ChangeLogId id;
	private ChangeLogEntityTable entityTable;
	private ChangeLogEntityId entityId;
	private ChangeLogRemoteId remoteId;
	private ChangeLogOperation operation;
	private ChangeLogPayload payload;
	private ChangeLogStatus status;
	private ChangeLogSyncAt syncAt;
	private ChangeLogAttempts attempts;
	private ChangeLogError error;
	private ChangeLogCreatedBy createdBy;
	private ChangeLogTenant tenant;



}
