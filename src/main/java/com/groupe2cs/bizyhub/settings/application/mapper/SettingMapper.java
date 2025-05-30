package com.groupe2cs.bizyhub.settings.application.mapper;

import com.groupe2cs.bizyhub.settings.application.command.CreateSettingCommand;
import com.groupe2cs.bizyhub.settings.application.command.DeleteSettingCommand;
import com.groupe2cs.bizyhub.settings.application.command.UpdateSettingCommand;
import com.groupe2cs.bizyhub.settings.application.dto.SettingRequest;
import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.Setting;

public class SettingMapper {

	public static SettingResponse toResponse(Setting entity) {
		return SettingResponse.builder()
				.id(entity.getId())
				.name(entity.getName())
				.value(entity.getValue())
				.locale(entity.getLocale())
				.details(entity.getDetails())
				.isActive(entity.getIsActive())
				.createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername() : null)
				.tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
				.build();
	}

	public static SettingResponse toResponse(CreateSettingCommand command) {
		return SettingResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.value(command.getValue().value())
				.locale(command.getLocale().value())
				.details(command.getDetails().value())
				.isActive(command.getIsActive().value())
				.build();
	}

	public static SettingResponse toResponse(UpdateSettingCommand command) {
		return SettingResponse.builder()
				.id(command.getId().value())
				.name(command.getName().value())
				.value(command.getValue().value())
				.locale(command.getLocale().value())
				.details(command.getDetails().value())
				.isActive(command.getIsActive().value())
				.build();
	}

	public static CreateSettingCommand toCommand(
			SettingRequest request
	) {
		return CreateSettingCommand.builder()
				.name(SettingName.create(request.getName()))
				.value(SettingValue.create(request.getValue()))
				.locale(SettingLocale.create(request.getLocale()))
				.details(SettingDetails.create(request.getDetails()))
				.isActive(SettingIsActive.create(request.getIsActive()))
				.build();
	}

	public static UpdateSettingCommand toUpdateCommand(SettingId id, SettingRequest request) {
		return UpdateSettingCommand.builder()
				.id(id)
				.name(SettingName.create(request.getName()))
				.value(SettingValue.create(request.getValue()))
				.locale(SettingLocale.create(request.getLocale()))
				.details(SettingDetails.create(request.getDetails()))
				.isActive(SettingIsActive.create(request.getIsActive()))
				.build();
	}


	public static DeleteSettingCommand toDeleteCommand(SettingId id) {
		return DeleteSettingCommand.builder()
				.id(id)
				.build();
	}
}
