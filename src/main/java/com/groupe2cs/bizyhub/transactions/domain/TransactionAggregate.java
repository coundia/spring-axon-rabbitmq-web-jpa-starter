package com.groupe2cs.bizyhub.transactions.domain;

import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionDeletedEvent;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionUpdatedEvent;
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
public class TransactionAggregate {

	@AggregateIdentifier
	private TransactionId id;
	private TransactionAmount amount;
	private TransactionDateOperation dateOperation;
	private TransactionDescription description;
	private TransactionReference reference;
	private TransactionIsRecurring isRecurring;
	private TransactionIsExcluToRapport isExcluToRapport;
	private TransactionStatus status;
	private TransactionBalance balance;
	private TransactionCategory category;
	private TransactionUpdatedAt updatedAt;
	private TransactionCreatedAt createdAt;
	private TransactionCreatedBy createdBy;
	private TransactionTenant tenant;


	@CommandHandler
	public TransactionAggregate(CreateTransactionCommand command) {
		apply(new TransactionCreatedEvent(
				command.getId(),
				command.getAmount(),
				command.getDateOperation(),
				command.getDescription(),
				command.getReference(),
				command.getIsRecurring(),
				command.getIsExcluToRapport(),
				command.getStatus(),
				command.getBalance(),
				command.getCategory(),
				command.getUpdatedAt(),
				command.getCreatedAt(),
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
				command.getAmount(),
				command.getDateOperation(),
				command.getDescription(),
				command.getReference(),
				command.getIsRecurring(),
				command.getIsExcluToRapport(),
				command.getStatus(),
				command.getBalance(),
				command.getCategory(),
				command.getUpdatedAt(),
				command.getCreatedAt(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(TransactionCreatedEvent event) {
		this.id = event.getId();
		this.amount = event.getAmount();
		this.dateOperation = event.getDateOperation();
		this.description = event.getDescription();
		this.reference = event.getReference();
		this.isRecurring = event.getIsRecurring();
		this.isExcluToRapport = event.getIsExcluToRapport();
		this.status = event.getStatus();
		this.balance = event.getBalance();
		this.category = event.getCategory();
		this.updatedAt = event.getUpdatedAt();
		this.createdAt = event.getCreatedAt();
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
		this.amount = event.getAmount();
		this.dateOperation = event.getDateOperation();
		this.description = event.getDescription();
		this.reference = event.getReference();
		this.isRecurring = event.getIsRecurring();
		this.isExcluToRapport = event.getIsExcluToRapport();
		this.status = event.getStatus();
		this.balance = event.getBalance();
		this.category = event.getCategory();
		this.updatedAt = event.getUpdatedAt();
		this.createdAt = event.getCreatedAt();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
