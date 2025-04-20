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
public class UserAggregate {

@AggregateIdentifier
private UserId id;
private UserUsername username;
private UserPassword password;
private UserEmail email;


@CommandHandler
public UserAggregate(CreateUserCommand command) {
apply(new UserCreatedEvent(
		command.getId(),
		command.getUsername(),
		command.getPassword(),
		command.getEmail()
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
		command.getPassword(),
		command.getEmail()
));
}

@EventSourcingHandler
public void on(UserCreatedEvent event) {
	this.id = event.getId();
	this.username = event.getUsername();
	this.password = event.getPassword();
	this.email = event.getEmail();
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
	this.email = event.getEmail();
}

}
