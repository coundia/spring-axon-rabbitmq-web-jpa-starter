package com.groupe2cs.bizyhub.debts.domain;

import com.groupe2cs.bizyhub.debts.application.command.CreateDebtCommand;
import com.groupe2cs.bizyhub.debts.application.command.DeleteDebtCommand;
import com.groupe2cs.bizyhub.debts.application.command.UpdateDebtCommand;
import com.groupe2cs.bizyhub.debts.domain.event.DebtCreatedEvent;
import com.groupe2cs.bizyhub.debts.domain.event.DebtDeletedEvent;
import com.groupe2cs.bizyhub.debts.domain.event.DebtUpdatedEvent;
import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
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
public class DebtAggregate {

	@AggregateIdentifier
	private DebtId id;
	private DebtRemoteId remoteId;
	private DebtLocalId localId;
	private DebtCode code;
	private DebtNotes notes;
	private DebtBalance balance;
	private DebtBalanceDebt balanceDebt;
	private DebtDueDate dueDate;
	private DebtStatuses statuses;
	private DebtAccount account;
	private DebtSyncAt syncAt;
	private DebtCustomer customer;
	private DebtIsActive isActive;
	private DebtCreatedBy createdBy;
	private DebtTenant tenant;


	@CommandHandler
	public DebtAggregate(CreateDebtCommand command) {
		apply(new DebtCreatedEvent(
				command.getId(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getCode(),
				command.getNotes(),
				command.getBalance(),
				command.getBalanceDebt(),
				command.getDueDate(),
				command.getStatuses(),
				command.getAccount(),
				command.getSyncAt(),
				command.getCustomer(),
				command.getIsActive(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteDebtCommand command) {
		apply(new DebtDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateDebtCommand command) {
		apply(new DebtUpdatedEvent(
				command.getId(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getCode(),
				command.getNotes(),
				command.getBalance(),
				command.getBalanceDebt(),
				command.getDueDate(),
				command.getStatuses(),
				command.getAccount(),
				command.getSyncAt(),
				command.getCustomer(),
				command.getIsActive(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(DebtCreatedEvent event) {
		this.id = event.getId();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.code = event.getCode();
		this.notes = event.getNotes();
		this.balance = event.getBalance();
		this.balanceDebt = event.getBalanceDebt();
		this.dueDate = event.getDueDate();
		this.statuses = event.getStatuses();
		this.account = event.getAccount();
		this.syncAt = event.getSyncAt();
		this.customer = event.getCustomer();
		this.isActive = event.getIsActive();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(DebtDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(DebtUpdatedEvent event) {
		this.id = event.getId();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.code = event.getCode();
		this.notes = event.getNotes();
		this.balance = event.getBalance();
		this.balanceDebt = event.getBalanceDebt();
		this.dueDate = event.getDueDate();
		this.statuses = event.getStatuses();
		this.account = event.getAccount();
		this.syncAt = event.getSyncAt();
		this.customer = event.getCustomer();
		this.isActive = event.getIsActive();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
