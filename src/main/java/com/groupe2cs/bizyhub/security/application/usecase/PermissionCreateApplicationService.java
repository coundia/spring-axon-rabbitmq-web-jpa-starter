package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionCreateApplicationService {
private final CommandGateway commandGateway;

public PermissionResponse createPermission(PermissionRequest request,
MetaRequest metaRequest
){

CreatePermissionCommand command = PermissionMapper.toCommand(
request
);

command.setCreatedBy(PermissionCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(PermissionTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return PermissionMapper.toResponse(command);
}


}
