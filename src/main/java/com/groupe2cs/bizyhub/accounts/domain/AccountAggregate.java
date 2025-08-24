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
private AccountCode code;
private AccountName name;
private AccountStatus status;
private AccountCurrency currency;
private AccountTypeAccount typeAccount;
private AccountBalance balance;
private AccountBalancePrev balancePrev;
private AccountBalanceBlocked balanceBlocked;
private AccountBalanceInit balanceInit;
private AccountBalanceGoal balanceGoal;
private AccountBalanceLimit balanceLimit;
private AccountDescription description;
private AccountIsActive isActive;
private AccountIsDefault isDefault;
private AccountRemoteId remoteId;
private AccountLocalId localId;
private AccountSyncAt syncAt;
private AccountCreatedBy createdBy;
private AccountTenant tenant;


@CommandHandler
public AccountAggregate(CreateAccountCommand command) {
apply(new AccountCreatedEvent(
		command.getId(),
		command.getCode(),
		command.getName(),
		command.getStatus(),
		command.getCurrency(),
		command.getTypeAccount(),
		command.getBalance(),
		command.getBalancePrev(),
		command.getBalanceBlocked(),
		command.getBalanceInit(),
		command.getBalanceGoal(),
		command.getBalanceLimit(),
		command.getDescription(),
		command.getIsActive(),
		command.getIsDefault(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getSyncAt(),
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
		command.getCode(),
		command.getName(),
		command.getStatus(),
		command.getCurrency(),
		command.getTypeAccount(),
		command.getBalance(),
		command.getBalancePrev(),
		command.getBalanceBlocked(),
		command.getBalanceInit(),
		command.getBalanceGoal(),
		command.getBalanceLimit(),
		command.getDescription(),
		command.getIsActive(),
		command.getIsDefault(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getSyncAt(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(AccountCreatedEvent event) {
	this.id = event.getId();
	this.code = event.getCode();
	this.name = event.getName();
	this.status = event.getStatus();
	this.currency = event.getCurrency();
	this.typeAccount = event.getTypeAccount();
	this.balance = event.getBalance();
	this.balancePrev = event.getBalancePrev();
	this.balanceBlocked = event.getBalanceBlocked();
	this.balanceInit = event.getBalanceInit();
	this.balanceGoal = event.getBalanceGoal();
	this.balanceLimit = event.getBalanceLimit();
	this.description = event.getDescription();
	this.isActive = event.getIsActive();
	this.isDefault = event.getIsDefault();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.syncAt = event.getSyncAt();
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
	this.code = event.getCode();
	this.name = event.getName();
	this.status = event.getStatus();
	this.currency = event.getCurrency();
	this.typeAccount = event.getTypeAccount();
	this.balance = event.getBalance();
	this.balancePrev = event.getBalancePrev();
	this.balanceBlocked = event.getBalanceBlocked();
	this.balanceInit = event.getBalanceInit();
	this.balanceGoal = event.getBalanceGoal();
	this.balanceLimit = event.getBalanceLimit();
	this.description = event.getDescription();
	this.isActive = event.getIsActive();
	this.isDefault = event.getIsDefault();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.syncAt = event.getSyncAt();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
