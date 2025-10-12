package com.groupe2cs.bizyhub.sync.domain;

import com.groupe2cs.bizyhub.sync.application.command.CreateChangeLogCommand;
import com.groupe2cs.bizyhub.sync.application.command.DeleteChangeLogCommand;
import com.groupe2cs.bizyhub.sync.application.command.UpdateChangeLogCommand;
import com.groupe2cs.bizyhub.sync.domain.event.ChangeLogCreatedEvent;
import com.groupe2cs.bizyhub.sync.domain.event.ChangeLogDeletedEvent;
import com.groupe2cs.bizyhub.sync.domain.event.ChangeLogUpdatedEvent;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class ChangeLogAggregate {

	@AggregateIdentifier
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


	@CommandHandler
	public ChangeLogAggregate(CreateChangeLogCommand command) {
		apply(new ChangeLogCreatedEvent(
				command.getId(),
				command.getEntityTable(),
				command.getAccount(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getOperation(),
				command.getPayload(),
				command.getStatus(),
				command.getSyncAt(),
				command.getAttempts(),
				command.getError(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteChangeLogCommand command) {
		apply(new ChangeLogDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateChangeLogCommand command) {
		apply(new ChangeLogUpdatedEvent(
				command.getId(),
				command.getEntityTable(),
				command.getAccount(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getOperation(),
				command.getPayload(),
				command.getStatus(),
				command.getSyncAt(),
				command.getAttempts(),
				command.getError(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(ChangeLogCreatedEvent event) {
		this.id = event.getId();
		this.entityTable = event.getEntityTable();
		this.account = event.getAccount();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.operation = event.getOperation();
		this.payload = event.getPayload();
		this.status = event.getStatus();
		this.syncAt = event.getSyncAt();
		this.attempts = event.getAttempts();
		this.error = event.getError();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(ChangeLogDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(ChangeLogUpdatedEvent event) {
		this.id = event.getId();
		this.entityTable = event.getEntityTable();
		this.account = event.getAccount();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.operation = event.getOperation();
		this.payload = event.getPayload();
		this.status = event.getStatus();
		this.syncAt = event.getSyncAt();
		this.attempts = event.getAttempts();
		this.error = event.getError();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
