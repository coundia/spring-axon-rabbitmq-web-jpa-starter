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
public class AccountUserAggregate {

@AggregateIdentifier
private AccountUserId id;
private AccountUserAccount account;
private AccountUserUser user;
private AccountUserPhone phone;
private AccountUserRole role;
private AccountUserStatus status;
private AccountUserInvitedBy invitedBy;
private AccountUserSyncAt syncAt;
private AccountUserAcceptedAt acceptedAt;
private AccountUserRevokedAt revokedAt;
private AccountUserMessage message;
private AccountUserRemoteId remoteId;
private AccountUserLocalId localId;
private AccountUserIsActive isActive;
private AccountUserCreatedBy createdBy;
private AccountUserTenant tenant;


@CommandHandler
public AccountUserAggregate(CreateAccountUserCommand command) {
apply(new AccountUserCreatedEvent(
		command.getId(),
		command.getAccount(),
		command.getUser(),
		command.getPhone(),
		command.getRole(),
		command.getStatus(),
		command.getInvitedBy(),
		command.getSyncAt(),
		command.getAcceptedAt(),
		command.getRevokedAt(),
		command.getMessage(),
		command.getRemoteId(),
		command.getLocalId(),
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
		command.getAccount(),
		command.getUser(),
		command.getPhone(),
		command.getRole(),
		command.getStatus(),
		command.getInvitedBy(),
		command.getSyncAt(),
		command.getAcceptedAt(),
		command.getRevokedAt(),
		command.getMessage(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getIsActive(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(AccountUserCreatedEvent event) {
	this.id = event.getId();
	this.account = event.getAccount();
	this.user = event.getUser();
	this.phone = event.getPhone();
	this.role = event.getRole();
	this.status = event.getStatus();
	this.invitedBy = event.getInvitedBy();
	this.syncAt = event.getSyncAt();
	this.acceptedAt = event.getAcceptedAt();
	this.revokedAt = event.getRevokedAt();
	this.message = event.getMessage();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
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
	this.account = event.getAccount();
	this.user = event.getUser();
	this.phone = event.getPhone();
	this.role = event.getRole();
	this.status = event.getStatus();
	this.invitedBy = event.getInvitedBy();
	this.syncAt = event.getSyncAt();
	this.acceptedAt = event.getAcceptedAt();
	this.revokedAt = event.getRevokedAt();
	this.message = event.getMessage();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.isActive = event.getIsActive();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
