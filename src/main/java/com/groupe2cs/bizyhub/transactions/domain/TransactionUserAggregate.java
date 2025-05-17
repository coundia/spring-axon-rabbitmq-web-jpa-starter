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
public class TransactionUserAggregate {

@AggregateIdentifier
private TransactionUserId id;
private TransactionUserName name;
private TransactionUserTransaction transaction;
private TransactionUserUser user;
private TransactionUserUsername username;
private TransactionUserDetails details;
private TransactionUserIsActive isActive;
private TransactionUserUpdatedAt updatedAt;
private TransactionUserReference reference;
private TransactionUserCreatedBy createdBy;
private TransactionUserTenant tenant;


@CommandHandler
public TransactionUserAggregate(CreateTransactionUserCommand command) {
apply(new TransactionUserCreatedEvent(
		command.getId(),
		command.getName(),
		command.getTransaction(),
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
public void handle(DeleteTransactionUserCommand command) {
	apply(new TransactionUserDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateTransactionUserCommand command) {
apply(new TransactionUserUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getTransaction(),
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
public void on(TransactionUserCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.transaction = event.getTransaction();
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
public void on(TransactionUserDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(TransactionUserUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
	this.transaction = event.getTransaction();
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
