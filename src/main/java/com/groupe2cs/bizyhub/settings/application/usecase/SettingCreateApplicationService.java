package com.groupe2cs.bizyhub.settings.application.usecase;

import com.groupe2cs.bizyhub.settings.application.mapper.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.settings.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SettingCreateApplicationService {
private final CommandGateway commandGateway;

public SettingResponse createSetting(SettingRequest request,
MetaRequest metaRequest
){

CreateSettingCommand command = SettingMapper.toCommand(
request
);

command.setCreatedBy(SettingCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(SettingTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return SettingMapper.toResponse(command);
}


}
