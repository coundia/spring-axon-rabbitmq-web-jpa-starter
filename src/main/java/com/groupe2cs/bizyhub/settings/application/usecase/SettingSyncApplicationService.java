package com.groupe2cs.bizyhub.settings.application.usecase;

import com.groupe2cs.bizyhub.settings.application.command.CreateSettingCommand;
import com.groupe2cs.bizyhub.settings.application.command.DeleteSettingCommand;
import com.groupe2cs.bizyhub.settings.application.command.UpdateSettingCommand;
import com.groupe2cs.bizyhub.settings.application.dto.SettingSyncRequest;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingSyncApplicationService {

	private final SettingGate gateService;
	private final CommandGateway commandGateway;

	public void syncSetting(SettingSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateSettingCommand command = CreateSettingCommand.builder()
							.name(SettingName.create(d.getName()))
							.value(SettingValue.create(d.getValue()))
							.locale(SettingLocale.create(d.getLocale()))
							.details(SettingDetails.create(d.getDetails()))
							.isActive(SettingIsActive.create(d.getIsActive()))
							.updatedAt(SettingUpdatedAt.create(d.getUpdatedAt()))
							.reference(SettingReference.create(d.getReference()))
							.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(SettingTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(SettingCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Setting with id " + d.getId());
					}

					UpdateSettingCommand update = UpdateSettingCommand.builder()
							.id(SettingId.create(d.getId()))
							.name(SettingName.create(d.getName()))
							.value(SettingValue.create(d.getValue()))
							.locale(SettingLocale.create(d.getLocale()))
							.details(SettingDetails.create(d.getDetails()))
							.isActive(SettingIsActive.create(d.getIsActive()))
							.updatedAt(SettingUpdatedAt.create(d.getUpdatedAt()))
							.reference(SettingReference.create(d.getReference()))
							.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Setting with id " + d.getId());
					}

					DeleteSettingCommand delete = DeleteSettingCommand.builder()
							.id(SettingId.create(d.getId()))
							.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
