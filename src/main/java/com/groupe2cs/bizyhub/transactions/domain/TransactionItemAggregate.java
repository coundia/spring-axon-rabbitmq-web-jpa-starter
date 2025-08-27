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
public class TransactionItemAggregate {

@AggregateIdentifier
private TransactionItemId id;
private TransactionItemTransaction transaction;
private TransactionItemProduct product;
private TransactionItemLabel label;
private TransactionItemQuantity quantity;
private TransactionItemUnit unit;
private TransactionItemRemoteId remoteId;
private TransactionItemLocalId localId;
private TransactionItemSyncAt syncAt;
private TransactionItemUnitPrice unitPrice;
private TransactionItemTotal total;
private TransactionItemNotes notes;
private TransactionItemCreatedBy createdBy;
private TransactionItemTenant tenant;


@CommandHandler
public TransactionItemAggregate(CreateTransactionItemCommand command) {
apply(new TransactionItemCreatedEvent(
		command.getId(),
		command.getTransaction(),
		command.getProduct(),
		command.getLabel(),
		command.getQuantity(),
		command.getUnit(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getSyncAt(),
		command.getUnitPrice(),
		command.getTotal(),
		command.getNotes(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteTransactionItemCommand command) {
	apply(new TransactionItemDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateTransactionItemCommand command) {
apply(new TransactionItemUpdatedEvent(
		command.getId(),
		command.getTransaction(),
		command.getProduct(),
		command.getLabel(),
		command.getQuantity(),
		command.getUnit(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getSyncAt(),
		command.getUnitPrice(),
		command.getTotal(),
		command.getNotes(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(TransactionItemCreatedEvent event) {
	this.id = event.getId();
	this.transaction = event.getTransaction();
	this.product = event.getProduct();
	this.label = event.getLabel();
	this.quantity = event.getQuantity();
	this.unit = event.getUnit();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.syncAt = event.getSyncAt();
	this.unitPrice = event.getUnitPrice();
	this.total = event.getTotal();
	this.notes = event.getNotes();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(TransactionItemDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(TransactionItemUpdatedEvent event) {
this.id = event.getId();
	this.transaction = event.getTransaction();
	this.product = event.getProduct();
	this.label = event.getLabel();
	this.quantity = event.getQuantity();
	this.unit = event.getUnit();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.syncAt = event.getSyncAt();
	this.unitPrice = event.getUnitPrice();
	this.total = event.getTotal();
	this.notes = event.getNotes();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
