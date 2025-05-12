package com.groupe2cs.bizyhub.settings.application.usecase;

import com.groupe2cs.bizyhub.settings.application.command.*;
import com.groupe2cs.bizyhub.settings.application.query.*;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.settings.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SettingUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public SettingResponse updateSetting(SettingId id,SettingRequest request,
MetaRequest metaRequest
){

UpdateSettingCommand command = SettingMapper.toUpdateCommand(
id,
request
);

if(metaRequest.getTenantId() != null) {
	//command.setTenant(SettingTenant.create(metaRequest.getTenantId()));
}

commandGateway.sendAndWait(command);

return SettingMapper.toResponse(command);
}

}
