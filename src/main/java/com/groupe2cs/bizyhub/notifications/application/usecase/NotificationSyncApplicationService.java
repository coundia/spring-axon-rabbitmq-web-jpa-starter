package com.groupe2cs.bizyhub.notifications.application.usecase;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import com.groupe2cs.bizyhub.notifications.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.notifications.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class NotificationSyncApplicationService {

	private final NotificationGate gateService;
	private final CommandGateway commandGateway;

	public void syncNotification(NotificationSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateNotificationCommand command = CreateNotificationCommand.builder()
								.deviceToken(NotificationDeviceToken.create(d.getDeviceToken()))
								.title(NotificationTitle.create(d.getTitle()))
								.message(NotificationMessage.create(d.getMessage()))
								.status(NotificationStatus.create(d.getStatus()))
								.remoteId(NotificationRemoteId.create(d.getRemoteId()))
								.account(NotificationAccount.create(d.getAccount()))
								.localId(NotificationLocalId.create(d.getLocalId()))
								.syncAt(NotificationSyncAt.create(d.getSyncAt()))
								.reserved(NotificationReserved.create(d.getReserved()))
								.errorMessage(NotificationErrorMessage.create(d.getErrorMessage()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(NotificationTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(NotificationCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Notification with id " + d.getId());
					}

					UpdateNotificationCommand update = UpdateNotificationCommand.builder()
							.id(NotificationId.create(d.getId()))
							.deviceToken(NotificationDeviceToken.create(d.getDeviceToken()))
							.title(NotificationTitle.create(d.getTitle()))
							.message(NotificationMessage.create(d.getMessage()))
							.status(NotificationStatus.create(d.getStatus()))
							.remoteId(NotificationRemoteId.create(d.getRemoteId()))
							.account(NotificationAccount.create(d.getAccount()))
							.localId(NotificationLocalId.create(d.getLocalId()))
							.syncAt(NotificationSyncAt.create(d.getSyncAt()))
							.reserved(NotificationReserved.create(d.getReserved()))
							.errorMessage(NotificationErrorMessage.create(d.getErrorMessage()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Notification with id " + d.getId());
					}

					DeleteNotificationCommand delete = DeleteNotificationCommand.builder()
						.id(NotificationId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
