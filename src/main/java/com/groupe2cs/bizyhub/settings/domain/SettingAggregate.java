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
private SettingReference reference;
private SettingUpdatedAt updatedAt;
private SettingStringValue stringValue;
private SettingDescriptions descriptions;
private SettingIsActive isActive;
private SettingCreatedBy createdBy;
private SettingTenant tenant;


@CommandHandler
public SettingAggregate(CreateSettingCommand command) {
apply(new SettingCreatedEvent(
		command.getId(),
		command.getName(),
		command.getReference(),
		command.getUpdatedAt(),
		command.getStringValue(),
		command.getDescriptions(),
		command.getIsActive(),
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
		command.getReference(),
		command.getUpdatedAt(),
		command.getStringValue(),
		command.getDescriptions(),
		command.getIsActive(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(SettingCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.reference = event.getReference();
	this.updatedAt = event.getUpdatedAt();
	this.stringValue = event.getStringValue();
	this.descriptions = event.getDescriptions();
	this.isActive = event.getIsActive();
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
	this.reference = event.getReference();
	this.updatedAt = event.getUpdatedAt();
	this.stringValue = event.getStringValue();
	this.descriptions = event.getDescriptions();
	this.isActive = event.getIsActive();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
