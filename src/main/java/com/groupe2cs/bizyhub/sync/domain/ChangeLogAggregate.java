package com.groupe2cs.bizyhub.sync.domain;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.domain.event.*;
import com.groupe2cs.bizyhub.sync.application.command.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class ChangeLogAggregate {

@AggregateIdentifier
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


@CommandHandler
public ChangeLogAggregate(CreateChangeLogCommand command) {
apply(new ChangeLogCreatedEvent(
		command.getId(),
		command.getEntityTable(),
		command.getEntityId(),
		command.getRemoteId(),
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
		command.getEntityId(),
		command.getRemoteId(),
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
	this.entityId = event.getEntityId();
	this.remoteId = event.getRemoteId();
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
	this.entityId = event.getEntityId();
	this.remoteId = event.getRemoteId();
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
