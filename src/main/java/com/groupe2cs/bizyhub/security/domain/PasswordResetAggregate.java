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
public class PasswordResetAggregate {

@AggregateIdentifier
private PasswordResetId id;
private PasswordResetToken token;
private PasswordResetUsername username;
private PasswordResetExpiration expiration;


@CommandHandler
public PasswordResetAggregate(CreatePasswordResetCommand command) {
apply(new PasswordResetCreatedEvent(
		command.getId(),
		command.getToken(),
		command.getUsername(),
		command.getExpiration()
));
}

@CommandHandler
public void handle(DeletePasswordResetCommand command) {
	apply(new PasswordResetDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdatePasswordResetCommand command) {
apply(new PasswordResetUpdatedEvent(
		command.getId(),
		command.getToken(),
		command.getUsername(),
		command.getExpiration()
));
}

@EventSourcingHandler
public void on(PasswordResetCreatedEvent event) {
	this.id = event.getId();
	this.token = event.getToken();
	this.username = event.getUsername();
	this.expiration = event.getExpiration();
}

@EventSourcingHandler
public void on(PasswordResetDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(PasswordResetUpdatedEvent event) {
this.id = event.getId();
	this.token = event.getToken();
	this.username = event.getUsername();
	this.expiration = event.getExpiration();
}

}
