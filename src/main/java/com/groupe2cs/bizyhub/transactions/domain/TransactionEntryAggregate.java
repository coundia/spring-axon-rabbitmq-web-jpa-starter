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
public class TransactionEntryAggregate {

@AggregateIdentifier
private TransactionEntryId id;
private TransactionEntryRemoteId remoteId;
private TransactionEntryCode code;
private TransactionEntryDescription description;
private TransactionEntryAmount amount;
private TransactionEntryTypeEntry typeEntry;
private TransactionEntryDateTransaction dateTransaction;
private TransactionEntryStatus status;
private TransactionEntryEntityName entityName;
private TransactionEntryEntityId entityId;
private TransactionEntryAccount account;
private TransactionEntrySyncAt syncAt;
private TransactionEntryCategory category;
private TransactionEntryCompany company;
private TransactionEntryCustomer customer;
private TransactionEntryDebt debt;
private TransactionEntryCreatedBy createdBy;
private TransactionEntryTenant tenant;


@CommandHandler
public TransactionEntryAggregate(CreateTransactionEntryCommand command) {
apply(new TransactionEntryCreatedEvent(
		command.getId(),
		command.getRemoteId(),
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
public void handle(DeleteTransactionEntryCommand command) {
	apply(new TransactionEntryDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateTransactionEntryCommand command) {
apply(new TransactionEntryUpdatedEvent(
		command.getId(),
		command.getRemoteId(),
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
public void on(TransactionEntryCreatedEvent event) {
	this.id = event.getId();
	this.remoteId = event.getRemoteId();
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
public void on(TransactionEntryDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(TransactionEntryUpdatedEvent event) {
this.id = event.getId();
	this.remoteId = event.getRemoteId();
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
