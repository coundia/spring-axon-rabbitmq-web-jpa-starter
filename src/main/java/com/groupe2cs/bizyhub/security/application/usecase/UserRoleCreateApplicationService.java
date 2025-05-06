package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.security.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRoleCreateApplicationService {
private final CommandGateway commandGateway;

public UserRoleResponse createUserRole(UserRoleRequest request,
MetaRequest metaRequest
){

CreateUserRoleCommand command = UserRoleMapper.toCommand(
request
);

command.setCreatedBy(UserRoleCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(UserRoleTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return UserRoleMapper.toResponse(command);
}


}
