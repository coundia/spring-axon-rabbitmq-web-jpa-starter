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
		.reference(entity.getReference())
		.updatedAt(entity.getUpdatedAt())
		.stringValue(entity.getStringValue())
		.descriptions(entity.getDescriptions())
		.isActive(entity.getIsActive())
.build();
}

public static SettingResponse toResponse(CreateSettingCommand command) {
return SettingResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.reference(command.getReference().value())
	.updatedAt(command.getUpdatedAt().value())
	.stringValue(command.getStringValue().value())
	.descriptions(command.getDescriptions().value())
	.isActive(command.getIsActive().value())
.build();
}

public static SettingResponse toResponse(UpdateSettingCommand command) {
return SettingResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.reference(command.getReference().value())
	.updatedAt(command.getUpdatedAt().value())
	.stringValue(command.getStringValue().value())
	.descriptions(command.getDescriptions().value())
	.isActive(command.getIsActive().value())
.build();
}

public static CreateSettingCommand toCommand(
SettingRequest request
) {
return CreateSettingCommand.builder()
	.name(SettingName.create(request.getName()))
	.reference(SettingReference.create(request.getReference()))
	.updatedAt(SettingUpdatedAt.create(request.getUpdatedAt()))
	.stringValue(SettingStringValue.create(request.getStringValue()))
	.descriptions(SettingDescriptions.create(request.getDescriptions()))
	.isActive(SettingIsActive.create(request.getIsActive()))
.build();
}

	public static UpdateSettingCommand toUpdateCommand(SettingId id, SettingRequest request) {
	return UpdateSettingCommand.builder()
	.id(id)
		.name(SettingName.create(request.getName()))
		.reference(SettingReference.create(request.getReference()))
		.updatedAt(SettingUpdatedAt.create(request.getUpdatedAt()))
		.stringValue(SettingStringValue.create(request.getStringValue()))
		.descriptions(SettingDescriptions.create(request.getDescriptions()))
		.isActive(SettingIsActive.create(request.getIsActive()))
	.build();
	}


public static DeleteSettingCommand toDeleteCommand(SettingId id) {
return DeleteSettingCommand.builder()
.id(id)
.build();
}
}
