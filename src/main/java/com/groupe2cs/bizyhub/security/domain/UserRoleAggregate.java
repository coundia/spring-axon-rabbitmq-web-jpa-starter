package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.domain.event.*;
import com.groupe2cs.bizyhub.security.application.command.*;
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
public class UserRoleAggregate {

	@AggregateIdentifier
	private UserRoleId id;
	private UserRoleUser user;
	private UserRoleRole role;
	private UserRoleCreatedBy createdBy;
	private UserRoleTenant tenant;


	@CommandHandler
	public UserRoleAggregate(CreateUserRoleCommand command) {
		apply(new UserRoleCreatedEvent(
				command.getId(),
				command.getUser(),
				command.getRole(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteUserRoleCommand command) {
		apply(new UserRoleDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateUserRoleCommand command) {
		apply(new UserRoleUpdatedEvent(
				command.getId(),
				command.getUser(),
				command.getRole(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(UserRoleCreatedEvent event) {
		this.id = event.getId();
		this.user = event.getUser();
		this.role = event.getRole();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(UserRoleDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(UserRoleUpdatedEvent event) {
		this.id = event.getId();
		this.user = event.getUser();
		this.role = event.getRole();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
