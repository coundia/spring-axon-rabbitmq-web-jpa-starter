package com.groupe2cs.bizyhub.notifications.domain;

import com.groupe2cs.bizyhub.notifications.application.command.CreateNotificationCommand;
import com.groupe2cs.bizyhub.notifications.application.command.DeleteNotificationCommand;
import com.groupe2cs.bizyhub.notifications.application.command.UpdateNotificationCommand;
import com.groupe2cs.bizyhub.notifications.domain.event.NotificationCreatedEvent;
import com.groupe2cs.bizyhub.notifications.domain.event.NotificationDeletedEvent;
import com.groupe2cs.bizyhub.notifications.domain.event.NotificationUpdatedEvent;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
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
public class NotificationAggregate {

	@AggregateIdentifier
	private NotificationId id;
	private NotificationDeviceToken deviceToken;
	private NotificationTitle title;
	private NotificationMessage message;
	private NotificationStatus status;
	private NotificationRemoteId remoteId;
	private NotificationAccount account;
	private NotificationLocalId localId;
	private NotificationSyncAt syncAt;
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
				command.getRemoteId(),
				command.getAccount(),
				command.getLocalId(),
				command.getSyncAt(),
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
				command.getRemoteId(),
				command.getAccount(),
				command.getLocalId(),
				command.getSyncAt(),
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
		this.remoteId = event.getRemoteId();
		this.account = event.getAccount();
		this.localId = event.getLocalId();
		this.syncAt = event.getSyncAt();
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
		this.remoteId = event.getRemoteId();
		this.account = event.getAccount();
		this.localId = event.getLocalId();
		this.syncAt = event.getSyncAt();
		this.reserved = event.getReserved();
		this.errorMessage = event.getErrorMessage();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
