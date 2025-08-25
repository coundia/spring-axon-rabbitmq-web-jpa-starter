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
private TransactionRemoteId remoteId;
private TransactionLocalId localId;
private TransactionCode code;
private TransactionDescription description;
private TransactionAmount amount;
private TransactionTypeEntry typeEntry;
private TransactionDateTransaction dateTransaction;
private TransactionStatus status;
private TransactionEntityName entityName;
private TransactionEntityId entityId;
private TransactionAccount account;
private TransactionSyncAt syncAt;
private TransactionCategory category;
private TransactionCompany company;
private TransactionCustomer customer;
private TransactionDebt debt;
private TransactionCreatedBy createdBy;
private TransactionTenant tenant;


@CommandHandler
public TransactionAggregate(CreateTransactionCommand command) {
apply(new TransactionCreatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getCode(),
		command.getDescription(),
		command.getAmount(),
		command.getTypeEntry(),
		command.getDateTransaction(),
		command.getStatus(),
		command.getEntityName(),
		command.getEntityId(),
		command.getAccount(),
		command.getSyncAt(),
		command.getCategory(),
		command.getCompany(),
		command.getCustomer(),
		command.getDebt(),
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
		command.getRemoteId(),
		command.getLocalId(),
		command.getCode(),
		command.getDescription(),
		command.getAmount(),
		command.getTypeEntry(),
		command.getDateTransaction(),
		command.getStatus(),
		command.getEntityName(),
		command.getEntityId(),
		command.getAccount(),
		command.getSyncAt(),
		command.getCategory(),
		command.getCompany(),
		command.getCustomer(),
		command.getDebt(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(TransactionCreatedEvent event) {
	this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.code = event.getCode();
	this.description = event.getDescription();
	this.amount = event.getAmount();
	this.typeEntry = event.getTypeEntry();
	this.dateTransaction = event.getDateTransaction();
	this.status = event.getStatus();
	this.entityName = event.getEntityName();
	this.entityId = event.getEntityId();
	this.account = event.getAccount();
	this.syncAt = event.getSyncAt();
	this.category = event.getCategory();
	this.company = event.getCompany();
	this.customer = event.getCustomer();
	this.debt = event.getDebt();
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
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.code = event.getCode();
	this.description = event.getDescription();
	this.amount = event.getAmount();
	this.typeEntry = event.getTypeEntry();
	this.dateTransaction = event.getDateTransaction();
	this.status = event.getStatus();
	this.entityName = event.getEntityName();
	this.entityId = event.getEntityId();
	this.account = event.getAccount();
	this.syncAt = event.getSyncAt();
	this.category = event.getCategory();
	this.company = event.getCompany();
	this.customer = event.getCustomer();
	this.debt = event.getDebt();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
