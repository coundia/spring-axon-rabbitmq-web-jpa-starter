package com.groupe2cs.bizyhub.message.application.mapper;

	import com.groupe2cs.bizyhub.message.application.dto.*;
	import com.groupe2cs.bizyhub.message.domain.valueObject.*;
	import com.groupe2cs.bizyhub.message.domain.*;
	import com.groupe2cs.bizyhub.message.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.message.application.command.*;

public class MessageMapper {

public static MessageResponse toResponse(Message entity) {
return MessageResponse.builder()
		.id(entity.getId())
		.code(entity.getCode())
		.email(entity.getEmail())
		.phone(entity.getPhone())
		.content(entity.getContent())
		.plateforme(entity.getPlateforme())
		.source(entity.getSource())
		.agent(entity.getAgent())
		.status(entity.getStatus())
		.description(entity.getDescription())
		.isActive(entity.getIsActive())
		.isDefault(entity.getIsDefault())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.depotAt(entity.getDepotAt())
		.syncAt(entity.getSyncAt())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static MessageResponse toResponse(CreateMessageCommand command) {
return MessageResponse.builder()
	.id(command.getId().value())
	.code(command.getCode().value())
	.email(command.getEmail().value())
	.phone(command.getPhone().value())
	.content(command.getContent().value())
	.plateforme(command.getPlateforme().value())
	.source(command.getSource().value())
	.agent(command.getAgent().value())
	.status(command.getStatus().value())
	.description(command.getDescription().value())
	.isActive(command.getIsActive().value())
	.isDefault(command.getIsDefault().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.depotAt(command.getDepotAt().value())
	.syncAt(command.getSyncAt().value())
.build();
}

public static MessageResponse toResponse(UpdateMessageCommand command) {
return MessageResponse.builder()
	.id(command.getId().value())
	.code(command.getCode().value())
	.email(command.getEmail().value())
	.phone(command.getPhone().value())
	.content(command.getContent().value())
	.plateforme(command.getPlateforme().value())
	.source(command.getSource().value())
	.agent(command.getAgent().value())
	.status(command.getStatus().value())
	.description(command.getDescription().value())
	.isActive(command.getIsActive().value())
	.isDefault(command.getIsDefault().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.depotAt(command.getDepotAt().value())
	.syncAt(command.getSyncAt().value())
.build();
}

public static CreateMessageCommand toCommand(
MessageRequest request
) {
return CreateMessageCommand.builder()
	.code(MessageCode.create(request.getCode()))
	.email(MessageEmail.create(request.getEmail()))
	.phone(MessagePhone.create(request.getPhone()))
	.content(MessageContent.create(request.getContent()))
	.plateforme(MessagePlateforme.create(request.getPlateforme()))
	.source(MessageSource.create(request.getSource()))
	.agent(MessageAgent.create(request.getAgent()))
	.status(MessageStatus.create(request.getStatus()))
	.description(MessageDescription.create(request.getDescription()))
	.isActive(MessageIsActive.create(request.getIsActive()))
	.isDefault(MessageIsDefault.create(request.getIsDefault()))
	.remoteId(MessageRemoteId.create(request.getRemoteId()))
	.localId(MessageLocalId.create(request.getLocalId()))
	.depotAt(MessageDepotAt.create(request.getDepotAt()))
	.syncAt(MessageSyncAt.create(request.getSyncAt()))
.build();
}

	public static UpdateMessageCommand toUpdateCommand(MessageId id, MessageRequest request) {
	return UpdateMessageCommand.builder()
	.id(id)
		.code(MessageCode.create(request.getCode()))
		.email(MessageEmail.create(request.getEmail()))
		.phone(MessagePhone.create(request.getPhone()))
		.content(MessageContent.create(request.getContent()))
		.plateforme(MessagePlateforme.create(request.getPlateforme()))
		.source(MessageSource.create(request.getSource()))
		.agent(MessageAgent.create(request.getAgent()))
		.status(MessageStatus.create(request.getStatus()))
		.description(MessageDescription.create(request.getDescription()))
		.isActive(MessageIsActive.create(request.getIsActive()))
		.isDefault(MessageIsDefault.create(request.getIsDefault()))
		.remoteId(MessageRemoteId.create(request.getRemoteId()))
		.localId(MessageLocalId.create(request.getLocalId()))
		.depotAt(MessageDepotAt.create(request.getDepotAt()))
		.syncAt(MessageSyncAt.create(request.getSyncAt()))
	.build();
	}


public static DeleteMessageCommand toDeleteCommand(MessageId id) {
return DeleteMessageCommand.builder()
.id(id)
.build();
}
}
