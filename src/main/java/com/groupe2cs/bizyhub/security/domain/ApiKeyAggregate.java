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
public class ApiKeyAggregate {

@AggregateIdentifier
private ApiKeyId id;
private ApiKeyKey key;
private ApiKeyUsername username;
private ApiKeyCreatedAt createdAt;
private ApiKeyExpiration expiration;


@CommandHandler
public ApiKeyAggregate(CreateApiKeyCommand command) {
apply(new ApiKeyCreatedEvent(
		command.getId(),
		command.getKey(),
		command.getUsername(),
		command.getCreatedAt(),
		command.getExpiration()
));
}

@CommandHandler
public void handle(DeleteApiKeyCommand command) {
	apply(new ApiKeyDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateApiKeyCommand command) {
apply(new ApiKeyUpdatedEvent(
		command.getId(),
		command.getKey(),
		command.getUsername(),
		command.getCreatedAt(),
		command.getExpiration()
));
}

@EventSourcingHandler
public void on(ApiKeyCreatedEvent event) {
	this.id = event.getId();
	this.key = event.getKey();
	this.username = event.getUsername();
	this.createdAt = event.getCreatedAt();
	this.expiration = event.getExpiration();
}

@EventSourcingHandler
public void on(ApiKeyDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(ApiKeyUpdatedEvent event) {
this.id = event.getId();
	this.key = event.getKey();
	this.username = event.getUsername();
	this.createdAt = event.getCreatedAt();
	this.expiration = event.getExpiration();
}

}
