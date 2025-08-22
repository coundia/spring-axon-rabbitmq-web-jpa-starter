package com.groupe2cs.bizyhub.notifications.domain;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import com.groupe2cs.bizyhub.notifications.domain.event.*;
import com.groupe2cs.bizyhub.notifications.application.command.*;
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
public class NotificationAggregate {

@AggregateIdentifier
private NotificationId id;
private NotificationDeviceToken deviceToken;
private NotificationTitle title;
private NotificationMessage message;
private NotificationStatus status;
private NotificationReserved reserved;
private NotificationErrorMessage errorMessage;
private NotificationCreatedBy createdBy;
private NotificationTenant tenant;


@CommandHandler
public NotificationAggregate(CreateNotificationCommand command) {
apply(new NotificationCreatedEvent(
		command.getId(),
		command.getDeviceToken(),
		command.getTitle(),
		command.getMessage(),
		command.getStatus(),
		command.getReserved(),
		command.getErrorMessage(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteNotificationCommand command) {
	apply(new NotificationDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateNotificationCommand command) {
apply(new NotificationUpdatedEvent(
		command.getId(),
		command.getDeviceToken(),
		command.getTitle(),
		command.getMessage(),
		command.getStatus(),
		command.getReserved(),
		command.getErrorMessage(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(NotificationCreatedEvent event) {
	this.id = event.getId();
	this.deviceToken = event.getDeviceToken();
	this.title = event.getTitle();
	this.message = event.getMessage();
	this.status = event.getStatus();
	this.reserved = event.getReserved();
	this.errorMessage = event.getErrorMessage();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(NotificationDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(NotificationUpdatedEvent event) {
this.id = event.getId();
	this.deviceToken = event.getDeviceToken();
	this.title = event.getTitle();
	this.message = event.getMessage();
	this.status = event.getStatus();
	this.reserved = event.getReserved();
	this.errorMessage = event.getErrorMessage();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
