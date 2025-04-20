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
public class RolePermissionCreateApplicationService {
private final CommandGateway commandGateway;

public RolePermissionResponse createRolePermission(RolePermissionRequest request){

CreateRolePermissionCommand command = RolePermissionMapper.toCommand(
request
);
commandGateway.sendAndWait(command);
return RolePermissionMapper.toResponse(command);
}


}
