package com.groupe2cs.bizyhub.settings.application.usecase;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.settings.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class SettingSyncApplicationService {

	private final CommandGateway commandGateway;

	public void syncSetting(SettingSyncRequest request,
MetaRequest metaRequest

) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {

CreateSettingCommand command = CreateSettingCommand.builder()
		.name(SettingName.create(d.getName()))
		.reference(SettingReference.create(d.getReference()))
		.updatedAt(SettingUpdatedAt.create(d.getUpdatedAt()))
		.stringValue(SettingStringValue.create(d.getStringValue()))
		.descriptions(SettingDescriptions.create(d.getDescriptions()))
		.isActive(SettingIsActive.create(d.getIsActive()))
.build();
		if(metaRequest.getTenantId() != null) {
			command.setTenant(SettingTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			command.setCreatedBy( SettingCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
							command
				);

		}
				case "UPDATE" -> {
		UpdateSettingCommand update = UpdateSettingCommand.builder()
			.id(SettingId.create(d.getId()))
			.name(SettingName.create(d.getName()))
			.reference(SettingReference.create(d.getReference()))
			.updatedAt(SettingUpdatedAt.create(d.getUpdatedAt()))
			.stringValue(SettingStringValue.create(d.getStringValue()))
			.descriptions(SettingDescriptions.create(d.getDescriptions()))
			.isActive(SettingIsActive.create(d.getIsActive()))
		.build();

		if(metaRequest.getTenantId() != null) {
			//command.setTenant(SettingTenant.create(metaRequest.getTenantId()));
		}
		if(metaRequest.getUserId() != null) {
			//command.setCreatedBy( SettingCreatedBy.create(metaRequest.getUserId()));
		}

		commandGateway.sendAndWait(
		update
				);

		}
		case "DELETE" -> {
				DeleteSettingCommand delete = DeleteSettingCommand.builder()
					.id(SettingId.create(d.getId()) )
					.build();

				if(metaRequest.getTenantId() != null) {
					//delete.setTenant(SettingTenant.create(metaRequest.getTenantId()));
				}

				if(metaRequest.getUserId() != null) {
					//delete.setCreatedBy( SettingCreatedBy.create(metaRequest.getUserId()));
				}
				commandGateway.sendAndWait(
				delete
				 );
				}
			}
		}
	}
}
