package com.groupe2cs.bizyhub.transactions.domain;

import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionUserCommand;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionUserCommand;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionUserCommand;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUserCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUserDeletedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUserUpdatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

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
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
