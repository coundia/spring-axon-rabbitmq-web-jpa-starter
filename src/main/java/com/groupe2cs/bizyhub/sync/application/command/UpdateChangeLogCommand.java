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
public class UpdateChangeLogCommand implements Serializable {
	@TargetAggregateIdentifier
	private ChangeLogId id;
	private ChangeLogEntityTable entityTable;
	private ChangeLogAccount account;
	private ChangeLogRemoteId remoteId;
	private ChangeLogLocalId localId;
	private ChangeLogOperation operation;
	private ChangeLogPayload payload;
	private ChangeLogStatus status;
	private ChangeLogSyncAt syncAt;
	private ChangeLogAttempts attempts;
	private ChangeLogError error;
	private ChangeLogCreatedBy createdBy;
	private ChangeLogTenant tenant;


}
