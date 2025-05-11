package com.groupe2cs.bizyhub.balances.domain;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.balances.domain.event.*;
import com.groupe2cs.bizyhub.balances.application.command.*;
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
public class BalanceAggregate {

@AggregateIdentifier
private BalanceId id;
private BalanceName name;
private BalanceCurrency currency;
private BalanceCurrentBalance currentBalance;
private BalancePreviousBalance previousBalance;
private BalanceLastUpdated lastUpdated;
private BalanceIsDefault isDefault;
private BalanceOrdre ordre;
private BalanceIsArchived isArchived;
private BalanceIsAllowDebit isAllowDebit;
private BalanceIsAllowCredit isAllowCredit;
private BalanceIsExcluTotal isExcluTotal;
private BalanceActivateNotification activateNotification;
private BalanceSyncedAt syncedAt;
private BalanceUpdatedAt updatedAt;
private BalanceReference reference;
private BalanceCreatedBy createdBy;
private BalanceTenant tenant;


@CommandHandler
public BalanceAggregate(CreateBalanceCommand command) {
apply(new BalanceCreatedEvent(
		command.getId(),
		command.getName(),
		command.getCurrency(),
		command.getCurrentBalance(),
		command.getPreviousBalance(),
		command.getLastUpdated(),
		command.getIsDefault(),
		command.getOrdre(),
		command.getIsArchived(),
		command.getIsAllowDebit(),
		command.getIsAllowCredit(),
		command.getIsExcluTotal(),
		command.getActivateNotification(),
		command.getSyncedAt(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteBalanceCommand command) {
	apply(new BalanceDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateBalanceCommand command) {
apply(new BalanceUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getCurrency(),
		command.getCurrentBalance(),
		command.getPreviousBalance(),
		command.getLastUpdated(),
		command.getIsDefault(),
		command.getOrdre(),
		command.getIsArchived(),
		command.getIsAllowDebit(),
		command.getIsAllowCredit(),
		command.getIsExcluTotal(),
		command.getActivateNotification(),
		command.getSyncedAt(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(BalanceCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.currency = event.getCurrency();
	this.currentBalance = event.getCurrentBalance();
	this.previousBalance = event.getPreviousBalance();
	this.lastUpdated = event.getLastUpdated();
	this.isDefault = event.getIsDefault();
	this.ordre = event.getOrdre();
	this.isArchived = event.getIsArchived();
	this.isAllowDebit = event.getIsAllowDebit();
	this.isAllowCredit = event.getIsAllowCredit();
	this.isExcluTotal = event.getIsExcluTotal();
	this.activateNotification = event.getActivateNotification();
	this.syncedAt = event.getSyncedAt();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(BalanceDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(BalanceUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
	this.currency = event.getCurrency();
	this.currentBalance = event.getCurrentBalance();
	this.previousBalance = event.getPreviousBalance();
	this.lastUpdated = event.getLastUpdated();
	this.isDefault = event.getIsDefault();
	this.ordre = event.getOrdre();
	this.isArchived = event.getIsArchived();
	this.isAllowDebit = event.getIsAllowDebit();
	this.isAllowCredit = event.getIsAllowCredit();
	this.isExcluTotal = event.getIsExcluTotal();
	this.activateNotification = event.getActivateNotification();
	this.syncedAt = event.getSyncedAt();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
