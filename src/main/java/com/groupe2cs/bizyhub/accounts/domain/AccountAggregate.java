package com.groupe2cs.bizyhub.accounts.domain;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.domain.event.*;
import com.groupe2cs.bizyhub.accounts.application.command.*;
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
public class AccountAggregate {

@AggregateIdentifier
private AccountId id;
private AccountName name;
private AccountCurrency currency;
private AccountCurrentBalance currentBalance;
private AccountPreviousBalance previousBalance;
private AccountDetails details;
private AccountIsActive isActive;
private AccountCreatedBy createdBy;
private AccountTenant tenant;


@CommandHandler
public AccountAggregate(CreateAccountCommand command) {
apply(new AccountCreatedEvent(
		command.getId(),
		command.getName(),
		command.getCurrency(),
		command.getCurrentBalance(),
		command.getPreviousBalance(),
		command.getDetails(),
		command.getIsActive(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteAccountCommand command) {
	apply(new AccountDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateAccountCommand command) {
apply(new AccountUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getCurrency(),
		command.getCurrentBalance(),
		command.getPreviousBalance(),
		command.getDetails(),
		command.getIsActive(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(AccountCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.currency = event.getCurrency();
	this.currentBalance = event.getCurrentBalance();
	this.previousBalance = event.getPreviousBalance();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(AccountDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(AccountUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
	this.currency = event.getCurrency();
	this.currentBalance = event.getCurrentBalance();
	this.previousBalance = event.getPreviousBalance();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
