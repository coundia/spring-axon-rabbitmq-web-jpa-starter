package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleCreateApplicationService {
private final CommandGateway commandGateway;

public RoleResponse createRole(RoleRequest request,
MetaRequest metaRequest
){

CreateRoleCommand command = RoleMapper.toCommand(
request
);

command.setCreatedBy(RoleCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(RoleTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return RoleMapper.toResponse(command);
}


}
