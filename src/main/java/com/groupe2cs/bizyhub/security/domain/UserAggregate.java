package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.application.command.DeleteUserCommand;
import com.groupe2cs.bizyhub.security.application.command.UpdateUserCommand;
import com.groupe2cs.bizyhub.security.domain.event.UserCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserDeletedEvent;
import com.groupe2cs.bizyhub.security.domain.event.UserUpdatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
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
public class UserAggregate {

	@AggregateIdentifier
	private UserId id;
	private UserUsername username;
	private UserPassword password;


	@CommandHandler
	public UserAggregate(CreateUserCommand command) {
		apply(new UserCreatedEvent(
				command.getId(),
				command.getUsername(),
				command.getPassword()
		));
	}

	@CommandHandler
	public void handle(DeleteUserCommand command) {
		apply(new UserDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateUserCommand command) {
		apply(new UserUpdatedEvent(
				command.getId(),
				command.getUsername(),
				command.getPassword()
		));
	}

	@EventSourcingHandler
	public void on(UserCreatedEvent event) {
		this.id = event.getId();
		this.username = event.getUsername();
		this.password = event.getPassword();
	}

	@EventSourcingHandler
	public void on(UserDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(UserUpdatedEvent event) {
		this.id = event.getId();
		this.username = event.getUsername();
		this.password = event.getPassword();
	}

}
