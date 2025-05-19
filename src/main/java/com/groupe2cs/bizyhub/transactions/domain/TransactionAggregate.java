package com.groupe2cs.bizyhub.transactions.domain;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.domain.event.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
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
public class TransactionAggregate {

@AggregateIdentifier
private TransactionId id;
private TransactionName name;
private TransactionAmount amount;
private TransactionDetails details;
private TransactionIsActive isActive;
private TransactionAccount account;
private TransactionCategory category;
private TransactionTypeTransactionRaw typeTransactionRaw;
private TransactionDateTransaction dateTransaction;
private TransactionUpdatedAt updatedAt;
private TransactionReference reference;
private TransactionCreatedBy createdBy;
private TransactionTenant tenant;


@CommandHandler
public TransactionAggregate(CreateTransactionCommand command) {
apply(new TransactionCreatedEvent(
		command.getId(),
		command.getName(),
		command.getAmount(),
		command.getDetails(),
		command.getIsActive(),
		command.getAccount(),
		command.getCategory(),
		command.getTypeTransactionRaw(),
		command.getDateTransaction(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteTransactionCommand command) {
	apply(new TransactionDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateTransactionCommand command) {
apply(new TransactionUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getAmount(),
		command.getDetails(),
		command.getIsActive(),
		command.getAccount(),
		command.getCategory(),
		command.getTypeTransactionRaw(),
		command.getDateTransaction(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(TransactionCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.amount = event.getAmount();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.account = event.getAccount();
	this.category = event.getCategory();
	this.typeTransactionRaw = event.getTypeTransactionRaw();
	this.dateTransaction = event.getDateTransaction();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(TransactionDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(TransactionUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
	this.amount = event.getAmount();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.account = event.getAccount();
	this.category = event.getCategory();
	this.typeTransactionRaw = event.getTypeTransactionRaw();
	this.dateTransaction = event.getDateTransaction();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
