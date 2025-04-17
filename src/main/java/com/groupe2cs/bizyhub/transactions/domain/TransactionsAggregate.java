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
public class TransactionsAggregate {

@AggregateIdentifier
private TransactionsId id;
private TransactionsReference reference;
private TransactionsAmount amount;


@CommandHandler
public TransactionsAggregate(CreateTransactionsCommand command) {
apply(new TransactionsCreatedEvent(
		command.getId(),
		command.getReference(),
		command.getAmount()
));
}

@CommandHandler
public void handle(DeleteTransactionsCommand command) {
	apply(new TransactionsDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateTransactionsCommand command) {
apply(new TransactionsUpdatedEvent(
		command.getId(),
		command.getReference(),
		command.getAmount()
));
}

@EventSourcingHandler
public void on(TransactionsCreatedEvent event) {
	this.id = event.getId();
	this.reference = event.getReference();
	this.amount = event.getAmount();
}

@EventSourcingHandler
public void on(TransactionsDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(TransactionsUpdatedEvent event) {
this.id = event.getId();
	this.reference = event.getReference();
	this.amount = event.getAmount();
}

}
