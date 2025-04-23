package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.application.command.CreateUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateUserRoleCommand;
import com.groupe2cs.bizyhub.security.domain.event.UserRoleCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserRoleDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserRoleUpdatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleRole;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleUser;
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
public class UserRoleAggregate {

	@AggregateIdentifier
	private UserRoleId id;
	private UserRoleUser user;
	private UserRoleRole role;


	@CommandHandler
	public UserRoleAggregate(CreateUserRoleCommand command) {
		apply(new UserRoleCreatedEvent(
				command.getId(),
				command.getUser(),
				command.getRole()
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
				command.getRole()
		));
	}

	@EventSourcingHandler
	public void on(UserRoleCreatedEvent event) {
		this.id = event.getId();
		this.user = event.getUser();
		this.role = event.getRole();
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
	}

}
