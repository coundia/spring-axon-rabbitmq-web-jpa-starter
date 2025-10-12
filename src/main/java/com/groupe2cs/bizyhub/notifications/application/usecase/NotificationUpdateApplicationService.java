package com.groupe2cs.bizyhub.notifications.application.usecase;

import com.groupe2cs.bizyhub.notifications.application.command.UpdateNotificationCommand;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationRequest;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
import com.groupe2cs.bizyhub.notifications.application.mapper.NotificationMapper;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationCreatedBy;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationId;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public NotificationResponse updateNotification(NotificationId id, NotificationRequest request,
												   MetaRequest metaRequest
	) {

		UpdateNotificationCommand command = NotificationMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(NotificationCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(NotificationTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return NotificationMapper.toResponse(command);
	}

}
