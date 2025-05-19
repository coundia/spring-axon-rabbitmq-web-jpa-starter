package com.groupe2cs.bizyhub.notifications.application.mapper;

	import com.groupe2cs.bizyhub.notifications.application.dto.*;
	import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
	import com.groupe2cs.bizyhub.notifications.domain.*;
	import com.groupe2cs.bizyhub.notifications.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.notifications.application.command.*;

public class NotificationMapper {

public static NotificationResponse toResponse(Notification entity) {
return NotificationResponse.builder()
		.id(entity.getId())
		.deviceToken(entity.getDeviceToken())
		.title(entity.getTitle())
		.message(entity.getMessage())
		.status(entity.getStatus())
		.reserved(entity.getReserved())
		.errorMessage(entity.getErrorMessage())
		.updatedAt(entity.getUpdatedAt())
		.reference(entity.getReference())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static NotificationResponse toResponse(CreateNotificationCommand command) {
return NotificationResponse.builder()
	.id(command.getId().value())
	.deviceToken(command.getDeviceToken().value())
	.title(command.getTitle().value())
	.message(command.getMessage().value())
	.status(command.getStatus().value())
	.reserved(command.getReserved().value())
	.errorMessage(command.getErrorMessage().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static NotificationResponse toResponse(UpdateNotificationCommand command) {
return NotificationResponse.builder()
	.id(command.getId().value())
	.deviceToken(command.getDeviceToken().value())
	.title(command.getTitle().value())
	.message(command.getMessage().value())
	.status(command.getStatus().value())
	.reserved(command.getReserved().value())
	.errorMessage(command.getErrorMessage().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CreateNotificationCommand toCommand(
NotificationRequest request
) {
return CreateNotificationCommand.builder()
	.deviceToken(NotificationDeviceToken.create(request.getDeviceToken()))
	.title(NotificationTitle.create(request.getTitle()))
	.message(NotificationMessage.create(request.getMessage()))
	.status(NotificationStatus.create(request.getStatus()))
	.reserved(NotificationReserved.create(request.getReserved()))
	.errorMessage(NotificationErrorMessage.create(request.getErrorMessage()))
	.updatedAt(NotificationUpdatedAt.create(request.getUpdatedAt()))
	.reference(NotificationReference.create(request.getReference()))
.build();
}

	public static UpdateNotificationCommand toUpdateCommand(NotificationId id, NotificationRequest request) {
	return UpdateNotificationCommand.builder()
	.id(id)
		.deviceToken(NotificationDeviceToken.create(request.getDeviceToken()))
		.title(NotificationTitle.create(request.getTitle()))
		.message(NotificationMessage.create(request.getMessage()))
		.status(NotificationStatus.create(request.getStatus()))
		.reserved(NotificationReserved.create(request.getReserved()))
		.errorMessage(NotificationErrorMessage.create(request.getErrorMessage()))
		.updatedAt(NotificationUpdatedAt.create(request.getUpdatedAt()))
		.reference(NotificationReference.create(request.getReference()))
	.build();
	}


public static DeleteNotificationCommand toDeleteCommand(NotificationId id) {
return DeleteNotificationCommand.builder()
.id(id)
.build();
}
}
