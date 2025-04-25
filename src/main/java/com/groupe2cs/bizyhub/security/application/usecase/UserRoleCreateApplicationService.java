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
public class UserRoleCreateApplicationService {
private final CommandGateway commandGateway;

public UserRoleResponse createUserRole(UserRoleRequest request,
String createdBy ){

CreateUserRoleCommand command = UserRoleMapper.toCommand(
request
);

if(createdBy != null) {
	command.setCreatedBy( UserRoleCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);
return UserRoleMapper.toResponse(command);
}


}
