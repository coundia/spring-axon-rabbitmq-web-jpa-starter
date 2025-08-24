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
private TransactionRemoteId remoteId;
private TransactionLocalId localId;
private TransactionDetails details;
private TransactionIsActive isActive;
private TransactionSyncAt syncAt;
private TransactionAccount account;
private TransactionCategory category;
private TransactionTypeEntry typeEntry;
private TransactionTypeTransactionRaw typeTransactionRaw;
private TransactionDateTransaction dateTransaction;
private TransactionCreatedBy createdBy;
private TransactionTenant tenant;


@CommandHandler
public TransactionAggregate(CreateTransactionCommand command) {
apply(new TransactionCreatedEvent(
		command.getId(),
		command.getName(),
		command.getAmount(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getDetails(),
		command.getIsActive(),
		command.getSyncAt(),
		command.getAccount(),
		command.getCategory(),
		command.getTypeEntry(),
		command.getTypeTransactionRaw(),
		command.getDateTransaction(),
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
		command.getRemoteId(),
		command.getLocalId(),
		command.getDetails(),
		command.getIsActive(),
		command.getSyncAt(),
		command.getAccount(),
		command.getCategory(),
		command.getTypeEntry(),
		command.getTypeTransactionRaw(),
		command.getDateTransaction(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(TransactionCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.amount = event.getAmount();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.syncAt = event.getSyncAt();
	this.account = event.getAccount();
	this.category = event.getCategory();
	this.typeEntry = event.getTypeEntry();
	this.typeTransactionRaw = event.getTypeTransactionRaw();
	this.dateTransaction = event.getDateTransaction();
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
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.syncAt = event.getSyncAt();
	this.account = event.getAccount();
	this.category = event.getCategory();
	this.typeEntry = event.getTypeEntry();
	this.typeTransactionRaw = event.getTypeTransactionRaw();
	this.dateTransaction = event.getDateTransaction();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
