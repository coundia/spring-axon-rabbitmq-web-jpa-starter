package com.groupe2cs.bizyhub.accounts.domain;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.application.command.DeleteAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.application.command.UpdateAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.domain.event.AccountUserCreatedEvent;
import com.groupe2cs.bizyhub.accounts.domain.event.AccountUserDeletedEvent;
import com.groupe2cs.bizyhub.accounts.domain.event.AccountUserUpdatedEvent;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
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
public class AccountUserAggregate {

	@AggregateIdentifier
	private AccountUserId id;
	private AccountUserName name;
	private AccountUserAccount account;
	private AccountUserUser user;
	private AccountUserUsername username;
	private AccountUserDetails details;
	private AccountUserIsActive isActive;
	private AccountUserCreatedBy createdBy;
	private AccountUserTenant tenant;


	@CommandHandler
	public AccountUserAggregate(CreateAccountUserCommand command) {
		apply(new AccountUserCreatedEvent(
				command.getId(),
				command.getName(),
				command.getAccount(),
				command.getUser(),
				command.getUsername(),
				command.getDetails(),
				command.getIsActive(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteAccountUserCommand command) {
		apply(new AccountUserDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateAccountUserCommand command) {
		apply(new AccountUserUpdatedEvent(
				command.getId(),
				command.getName(),
				command.getAccount(),
				command.getUser(),
				command.getUsername(),
				command.getDetails(),
				command.getIsActive(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(AccountUserCreatedEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.account = event.getAccount();
		this.user = event.getUser();
		this.username = event.getUsername();
		this.details = event.getDetails();
		this.isActive = event.getIsActive();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(AccountUserDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(AccountUserUpdatedEvent event) {
		this.id = event.getId();
		this.name = event.getName();
		this.account = event.getAccount();
		this.user = event.getUser();
		this.username = event.getUsername();
		this.details = event.getDetails();
		this.isActive = event.getIsActive();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
