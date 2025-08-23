package com.groupe2cs.bizyhub.sync.application.command;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateChangeLogCommand implements Serializable {
@TargetAggregateIdentifier
	private ChangeLogId id;
 	private ChangeLogEntityTable entityTable;
 	private ChangeLogEntityId entityId;
 	private ChangeLogOperation operation;
 	private ChangeLogPayload payload;
 	private ChangeLogStatus status;
 	private ChangeLogSyncAt syncAt;
 	private ChangeLogAttempts attempts;
 	private ChangeLogError error;
 	private ChangeLogCreatedBy createdBy;
 	private ChangeLogTenant tenant;


}
