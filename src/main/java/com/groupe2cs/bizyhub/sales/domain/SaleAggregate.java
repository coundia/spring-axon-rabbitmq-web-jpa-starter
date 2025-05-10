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
public class SaleAggregate {

@AggregateIdentifier
private SaleId id;
private SaleName name;
private SaleAmount amount;
private SaleDetails details;
private SaleIsActive isActive;
private SaleAccount account;
private SaleCategory category;
private SaleUpdatedAt updatedAt;
private SaleReference reference;
private SaleCreatedBy createdBy;
private SaleTenant tenant;


@CommandHandler
public SaleAggregate(CreateSaleCommand command) {
apply(new SaleCreatedEvent(
		command.getId(),
		command.getName(),
		command.getAmount(),
		command.getDetails(),
		command.getIsActive(),
		command.getAccount(),
		command.getCategory(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteSaleCommand command) {
	apply(new SaleDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateSaleCommand command) {
apply(new SaleUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getAmount(),
		command.getDetails(),
		command.getIsActive(),
		command.getAccount(),
		command.getCategory(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(SaleCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.amount = event.getAmount();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.account = event.getAccount();
	this.category = event.getCategory();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(SaleDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(SaleUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
	this.amount = event.getAmount();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.account = event.getAccount();
	this.category = event.getCategory();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
