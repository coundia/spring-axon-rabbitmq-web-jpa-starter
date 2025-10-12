package com.groupe2cs.bizyhub.notifications.domain.event;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationCreatedEvent implements Serializable {

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
