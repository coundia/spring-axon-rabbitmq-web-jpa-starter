package com.groupe2cs.bizyhub.notifications.application.command;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteNotificationCommand implements Serializable {
	@TargetAggregateIdentifier
	private NotificationId id;


}
