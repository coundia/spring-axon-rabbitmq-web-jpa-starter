package com.groupe2cs.bizyhub.settings.application.mapper;

	import com.groupe2cs.bizyhub.settings.application.dto.*;
	import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
	import com.groupe2cs.bizyhub.settings.domain.*;
	import com.groupe2cs.bizyhub.settings.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.settings.application.command.*;

public class SettingMapper {

public static SettingResponse toResponse(Setting entity) {
return SettingResponse.builder()
		.id(entity.getId())
		.name(entity.getName())
		.stringValue(entity.getStringValue())
		.description(entity.getDescription())
		.isActive(entity.getIsActive())
		.updatedAt(entity.getUpdatedAt())
		.reference(entity.getReference())
.build();
}

public static SettingResponse toResponse(CreateSettingCommand command) {
return SettingResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.stringValue(command.getStringValue().value())
	.description(command.getDescription().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static SettingResponse toResponse(UpdateSettingCommand command) {
return SettingResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.stringValue(command.getStringValue().value())
	.description(command.getDescription().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CreateSettingCommand toCommand(
SettingRequest request
) {
return CreateSettingCommand.builder()
	.name(SettingName.create(request.getName()))
	.stringValue(SettingStringValue.create(request.getStringValue()))
	.description(SettingDescription.create(request.getDescription()))
	.isActive(SettingIsActive.create(request.getIsActive()))
	.updatedAt(SettingUpdatedAt.create(request.getUpdatedAt()))
	.reference(SettingReference.create(request.getReference()))
.build();
}

	public static UpdateSettingCommand toUpdateCommand(SettingId id, SettingRequest request) {
	return UpdateSettingCommand.builder()
	.id(id)
		.name(SettingName.create(request.getName()))
		.stringValue(SettingStringValue.create(request.getStringValue()))
		.description(SettingDescription.create(request.getDescription()))
		.isActive(SettingIsActive.create(request.getIsActive()))
		.updatedAt(SettingUpdatedAt.create(request.getUpdatedAt()))
		.reference(SettingReference.create(request.getReference()))
	.build();
	}


public static DeleteSettingCommand toDeleteCommand(SettingId id) {
return DeleteSettingCommand.builder()
.id(id)
.build();
}
}
