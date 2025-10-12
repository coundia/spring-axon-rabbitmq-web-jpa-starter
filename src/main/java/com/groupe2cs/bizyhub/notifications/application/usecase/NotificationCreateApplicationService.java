package com.groupe2cs.bizyhub.notifications.application.usecase;

import com.groupe2cs.bizyhub.notifications.application.command.CreateNotificationCommand;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationRequest;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
import com.groupe2cs.bizyhub.notifications.application.mapper.NotificationMapper;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationCreatedBy;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationCreateApplicationService {
	private final CommandGateway commandGateway;

	public NotificationResponse createNotification(NotificationRequest request,
												   MetaRequest metaRequest
	) {

		CreateNotificationCommand command = NotificationMapper.toCommand(
				request
		);

		command.setCreatedBy(NotificationCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(NotificationTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return NotificationMapper.toResponse(command);
	}


}
