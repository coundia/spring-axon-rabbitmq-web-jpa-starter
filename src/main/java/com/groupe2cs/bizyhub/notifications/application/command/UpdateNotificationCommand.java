package com.groupe2cs.bizyhub.notifications.application.command;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateNotificationCommand implements Serializable {
	@TargetAggregateIdentifier
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


}
