package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import com.groupe2cs.bizyhub.tenant.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public TenantResponse updateTenant(TenantId id,TenantRequest request,
String createdBy 
){

UpdateTenantCommand command = TenantMapper.toUpdateCommand(
id,
request
);

if(createdBy != null) {
command.setCreatedBy( TenantCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);

return TenantMapper.toResponse(command);
}

}
