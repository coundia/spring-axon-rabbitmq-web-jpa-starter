package com.groupe2cs.bizyhub.notifications.application.usecase;

import com.groupe2cs.bizyhub.notifications.application.command.DeleteNotificationCommand;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteNotification(NotificationId idVo, MetaRequest metaRequest) {

		DeleteNotificationCommand command = new DeleteNotificationCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
