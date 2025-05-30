package com.groupe2cs.bizyhub.notifications.application.command;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNotificationCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private NotificationId id = NotificationId.create(UUID.randomUUID().toString());
	private NotificationDeviceToken deviceToken;
	private NotificationTitle title;
	private NotificationMessage message;
	private NotificationStatus status;
	private NotificationReserved reserved;
	private NotificationErrorMessage errorMessage;
	private NotificationCreatedBy createdBy;
	private NotificationTenant tenant;

	public CreateNotificationCommand(

			NotificationDeviceToken deviceToken,
			NotificationTitle title,
			NotificationMessage message,
			NotificationStatus status,
			NotificationReserved reserved,
			NotificationErrorMessage errorMessage,
			NotificationCreatedBy createdBy,
			NotificationTenant tenant
	) {
		this.id = NotificationId.create(UUID.randomUUID().toString());

		this.deviceToken = deviceToken;
		this.title = title;
		this.message = message;
		this.status = status;
		this.reserved = reserved;
		this.errorMessage = errorMessage;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
