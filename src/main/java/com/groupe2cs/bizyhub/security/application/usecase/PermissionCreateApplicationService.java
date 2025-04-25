package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionCreateApplicationService {
private final CommandGateway commandGateway;

public PermissionResponse createPermission(PermissionRequest request,
String createdBy ){

CreatePermissionCommand command = PermissionMapper.toCommand(
request
);

if(createdBy != null) {
	command.setCreatedBy( PermissionCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);
return PermissionMapper.toResponse(command);
}


}
