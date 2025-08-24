package com.groupe2cs.bizyhub.units.domain;

import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import com.groupe2cs.bizyhub.units.domain.event.*;
import com.groupe2cs.bizyhub.units.application.command.*;
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
public class UnitAggregate {

@AggregateIdentifier
private UnitId id;
private UnitRemoteId remoteId;
private UnitLocalId localId;
private UnitCode code;
private UnitName name;
private UnitSyncAt syncAt;
private UnitDescription description;
private UnitCreatedBy createdBy;
private UnitTenant tenant;


@CommandHandler
public UnitAggregate(CreateUnitCommand command) {
apply(new UnitCreatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getCode(),
		command.getName(),
		command.getSyncAt(),
		command.getDescription(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteUnitCommand command) {
	apply(new UnitDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateUnitCommand command) {
apply(new UnitUpdatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getCode(),
		command.getName(),
		command.getSyncAt(),
		command.getDescription(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(UnitCreatedEvent event) {
	this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.code = event.getCode();
	this.name = event.getName();
	this.syncAt = event.getSyncAt();
	this.description = event.getDescription();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(UnitDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(UnitUpdatedEvent event) {
this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.code = event.getCode();
	this.name = event.getName();
	this.syncAt = event.getSyncAt();
	this.description = event.getDescription();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
