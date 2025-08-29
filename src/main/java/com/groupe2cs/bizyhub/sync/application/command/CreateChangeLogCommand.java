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
public class CreateChangeLogCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private ChangeLogId id = ChangeLogId.create(UUID.randomUUID().toString());
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

	public CreateChangeLogCommand(

			ChangeLogEntityTable entityTable,
			ChangeLogAccount account,
			ChangeLogRemoteId remoteId,
			ChangeLogLocalId localId,
			ChangeLogOperation operation,
			ChangeLogPayload payload,
			ChangeLogStatus status,
			ChangeLogSyncAt syncAt,
			ChangeLogAttempts attempts,
			ChangeLogError error,
			ChangeLogCreatedBy createdBy,
			ChangeLogTenant tenant
	) {
		this.id = ChangeLogId.create(UUID.randomUUID().toString());

		this.entityTable = entityTable;
		this.account = account;
		this.remoteId = remoteId;
		this.localId = localId;
		this.operation = operation;
		this.payload = payload;
		this.status = status;
		this.syncAt = syncAt;
		this.attempts = attempts;
		this.error = error;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
