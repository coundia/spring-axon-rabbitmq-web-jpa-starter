package com.groupe2cs.bizyhub.tenant.domain;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.domain.event.*;
import com.groupe2cs.bizyhub.tenant.application.command.*;
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
public class TenantAggregate {

@AggregateIdentifier
private TenantId id;
private TenantName name;
private TenantDescription description;
private TenantDomain domain;
private TenantLanguage language;
private TenantActive active;
private TenantTenant tenant;
private TenantCreatedBy createdBy;


@CommandHandler
public TenantAggregate(CreateTenantCommand command) {
apply(new TenantCreatedEvent(
		command.getId(),
		command.getName(),
		command.getDescription(),
		command.getDomain(),
		command.getLanguage(),
		command.getActive(),
		command.getTenant(),
		command.getCreatedBy()
));
}

@CommandHandler
public void handle(DeleteTenantCommand command) {
	apply(new TenantDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateTenantCommand command) {
apply(new TenantUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getDescription(),
		command.getDomain(),
		command.getLanguage(),
		command.getActive(),
		command.getTenant(),
		command.getCreatedBy()
));
}

@EventSourcingHandler
public void on(TenantCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.description = event.getDescription();
	this.domain = event.getDomain();
	this.language = event.getLanguage();
	this.active = event.getActive();
	this.tenant = event.getTenant();
	this.createdBy = event.getCreatedBy();
}

@EventSourcingHandler
public void on(TenantDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(TenantUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
	this.description = event.getDescription();
	this.domain = event.getDomain();
	this.language = event.getLanguage();
	this.active = event.getActive();
	this.tenant = event.getTenant();
	this.createdBy = event.getCreatedBy();
}

}
