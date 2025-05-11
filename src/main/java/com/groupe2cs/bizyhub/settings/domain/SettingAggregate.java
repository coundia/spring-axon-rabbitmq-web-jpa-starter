package com.groupe2cs.bizyhub.settings.domain;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.settings.domain.event.*;
import com.groupe2cs.bizyhub.settings.application.command.*;
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
public class SettingAggregate {

@AggregateIdentifier
private SettingId id;
private SettingName name;
private SettingStringValue stringValue;
private SettingDescription description;
private SettingIsActive isActive;
private SettingUpdatedAt updatedAt;
private SettingReference reference;
private SettingCreatedBy createdBy;
private SettingTenant tenant;


@CommandHandler
public SettingAggregate(CreateSettingCommand command) {
apply(new SettingCreatedEvent(
		command.getId(),
		command.getName(),
		command.getStringValue(),
		command.getDescription(),
		command.getIsActive(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteSettingCommand command) {
	apply(new SettingDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateSettingCommand command) {
apply(new SettingUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getStringValue(),
		command.getDescription(),
		command.getIsActive(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(SettingCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.stringValue = event.getStringValue();
	this.description = event.getDescription();
	this.isActive = event.getIsActive();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(SettingDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(SettingUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
	this.stringValue = event.getStringValue();
	this.description = event.getDescription();
	this.isActive = event.getIsActive();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
