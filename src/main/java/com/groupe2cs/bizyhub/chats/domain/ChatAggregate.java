package com.groupe2cs.bizyhub.chats.domain;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.chats.domain.event.*;
import com.groupe2cs.bizyhub.chats.application.command.*;
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
public class ChatAggregate {

@AggregateIdentifier
private ChatId id;
private ChatMessages messages;
private ChatResponses responses;
private ChatState state;
private ChatAccount account;
private ChatUpdatedAt updatedAt;
private ChatReference reference;
private ChatCreatedBy createdBy;
private ChatTenant tenant;


@CommandHandler
public ChatAggregate(CreateChatCommand command) {
apply(new ChatCreatedEvent(
		command.getId(),
		command.getMessages(),
		command.getResponses(),
		command.getState(),
		command.getAccount(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteChatCommand command) {
	apply(new ChatDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateChatCommand command) {
apply(new ChatUpdatedEvent(
		command.getId(),
		command.getMessages(),
		command.getResponses(),
		command.getState(),
		command.getAccount(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(ChatCreatedEvent event) {
	this.id = event.getId();
	this.messages = event.getMessages();
	this.responses = event.getResponses();
	this.state = event.getState();
	this.account = event.getAccount();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(ChatDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(ChatUpdatedEvent event) {
this.id = event.getId();
	this.messages = event.getMessages();
	this.responses = event.getResponses();
	this.state = event.getState();
	this.account = event.getAccount();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
