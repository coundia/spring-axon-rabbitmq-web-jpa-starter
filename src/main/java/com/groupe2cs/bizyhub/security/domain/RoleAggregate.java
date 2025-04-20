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
public class RoleAggregate {

@AggregateIdentifier
private RoleId id;
private RoleName name;


@CommandHandler
public RoleAggregate(CreateRoleCommand command) {
apply(new RoleCreatedEvent(
		command.getId(),
		command.getName()
));
}

@CommandHandler
public void handle(DeleteRoleCommand command) {
	apply(new RoleDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateRoleCommand command) {
apply(new RoleUpdatedEvent(
		command.getId(),
		command.getName()
));
}

@EventSourcingHandler
public void on(RoleCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
}

@EventSourcingHandler
public void on(RoleDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(RoleUpdatedEvent event) {
this.id = event.getId();
	this.name = event.getName();
}

}
