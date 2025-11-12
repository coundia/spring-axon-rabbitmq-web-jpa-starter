package com.groupe2cs.bizyhub.message.domain;

import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import com.groupe2cs.bizyhub.message.domain.event.*;
import com.groupe2cs.bizyhub.message.application.command.*;
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
public class MessageAggregate {

@AggregateIdentifier
private MessageId id;
private MessageCode code;
private MessageEmail email;
private MessagePhone phone;
private MessageContent content;
private MessagePlateforme plateforme;
private MessageSource source;
private MessageAgent agent;
private MessageStatus status;
private MessageDescription description;
private MessageIsActive isActive;
private MessageIsDefault isDefault;
private MessageRemoteId remoteId;
private MessageLocalId localId;
private MessageDepotAt depotAt;
private MessageSyncAt syncAt;
private MessageCreatedBy createdBy;
private MessageTenant tenant;


@CommandHandler
public MessageAggregate(CreateMessageCommand command) {
apply(new MessageCreatedEvent(
		command.getId(),
		command.getCode(),
		command.getEmail(),
		command.getPhone(),
		command.getContent(),
		command.getPlateforme(),
		command.getSource(),
		command.getAgent(),
		command.getStatus(),
		command.getDescription(),
		command.getIsActive(),
		command.getIsDefault(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getDepotAt(),
		command.getSyncAt(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteMessageCommand command) {
	apply(new MessageDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateMessageCommand command) {
apply(new MessageUpdatedEvent(
		command.getId(),
		command.getCode(),
		command.getEmail(),
		command.getPhone(),
		command.getContent(),
		command.getPlateforme(),
		command.getSource(),
		command.getAgent(),
		command.getStatus(),
		command.getDescription(),
		command.getIsActive(),
		command.getIsDefault(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getDepotAt(),
		command.getSyncAt(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(MessageCreatedEvent event) {
	this.id = event.getId();
	this.code = event.getCode();
	this.email = event.getEmail();
	this.phone = event.getPhone();
	this.content = event.getContent();
	this.plateforme = event.getPlateforme();
	this.source = event.getSource();
	this.agent = event.getAgent();
	this.status = event.getStatus();
	this.description = event.getDescription();
	this.isActive = event.getIsActive();
	this.isDefault = event.getIsDefault();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.depotAt = event.getDepotAt();
	this.syncAt = event.getSyncAt();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(MessageDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(MessageUpdatedEvent event) {
this.id = event.getId();
	this.code = event.getCode();
	this.email = event.getEmail();
	this.phone = event.getPhone();
	this.content = event.getContent();
	this.plateforme = event.getPlateforme();
	this.source = event.getSource();
	this.agent = event.getAgent();
	this.status = event.getStatus();
	this.description = event.getDescription();
	this.isActive = event.getIsActive();
	this.isDefault = event.getIsDefault();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.depotAt = event.getDepotAt();
	this.syncAt = event.getSyncAt();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
