package com.groupe2cs.bizyhub.notifications.application.command;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

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
 	private NotificationSyncAt syncAt;
 	private NotificationReserved reserved;
 	private NotificationErrorMessage errorMessage;
 	private NotificationCreatedBy createdBy;
 	private NotificationTenant tenant;


}
