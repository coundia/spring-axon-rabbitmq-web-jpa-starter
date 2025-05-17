package com.groupe2cs.bizyhub.settings.application.usecase;

import com.groupe2cs.bizyhub.settings.application.command.CreateSettingCommand;
import com.groupe2cs.bizyhub.settings.application.dto.SettingRequest;
import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.application.mapper.SettingMapper;
import com.groupe2cs.bizyhub.settings.domain.valueObject.SettingCreatedBy;
import com.groupe2cs.bizyhub.settings.domain.valueObject.SettingTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingCreateApplicationService {
	private final CommandGateway commandGateway;

	public SettingResponse createSetting(SettingRequest request,
										 MetaRequest metaRequest
	) {

		CreateSettingCommand command = SettingMapper.toCommand(
				request
		);

		command.setCreatedBy(SettingCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(SettingTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return SettingMapper.toResponse(command);
	}


}
