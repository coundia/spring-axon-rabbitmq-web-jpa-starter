package com.groupe2cs.bizyhub.notifications.domain.event;

	import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

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
	private NotificationReserved reserved;
	private NotificationErrorMessage errorMessage;
	private NotificationUpdatedAt updatedAt;
	private NotificationReference reference;
	private NotificationCreatedBy createdBy;
	private NotificationTenant tenant;



}
