package com.groupe2cs.bizyhub.sales.domain;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.domain.event.*;
import com.groupe2cs.bizyhub.sales.application.command.*;
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
public class SaleUserAggregate {

@AggregateIdentifier
private SaleUserId id;
private SaleUserName name;
private SaleUserSale sale;
private SaleUserUser user;
private SaleUserUsername username;
private SaleUserDetails details;
private SaleUserIsActive isActive;
private SaleUserUpdatedAt updatedAt;
private SaleUserReference reference;
private SaleUserCreatedBy createdBy;
private SaleUserTenant tenant;


@CommandHandler
public SaleUserAggregate(CreateSaleUserCommand command) {
apply(new SaleUserCreatedEvent(
		command.getId(),
		command.getName(),
		command.getSale(),
		command.getUser(),
		command.getUsername(),
		command.getDetails(),
		command.getIsActive(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteSaleUserCommand command) {
	apply(new SaleUserDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateSaleUserCommand command) {
apply(new SaleUserUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getSale(),
		command.getUser(),
		command.getUsername(),
		command.getDetails(),
		command.getIsActive(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(SaleUserCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.sale = event.getSale();
	this.user = event.getUser();
	this.username = event.getUsername();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(SaleUserDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(SaleUserUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
	this.sale = event.getSale();
	this.user = event.getUser();
	this.username = event.getUsername();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
