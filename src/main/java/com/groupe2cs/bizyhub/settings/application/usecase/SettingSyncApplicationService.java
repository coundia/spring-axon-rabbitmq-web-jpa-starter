package com.groupe2cs.bizyhub.settings.application.usecase;
import com.groupe2cs.bizyhub.settings.application.command.*;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

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
								.remoteId(SettingRemoteId.create(d.getRemoteId()))
								.details(SettingDetails.create(d.getDetails()))
								.syncAt(SettingSyncAt.create(d.getSyncAt()))
								.isActive(SettingIsActive.create(d.getIsActive()))
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
							.remoteId(SettingRemoteId.create(d.getRemoteId()))
							.details(SettingDetails.create(d.getDetails()))
							.syncAt(SettingSyncAt.create(d.getSyncAt()))
							.isActive(SettingIsActive.create(d.getIsActive()))
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
