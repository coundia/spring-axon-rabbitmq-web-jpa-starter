package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserCreateApplicationService {
private final CommandGateway commandGateway;

public UserResponse createUser(UserRequest request,
MetaRequest metaRequest
){

CreateUserCommand command = UserMapper.toCommand(
request
);

command.setCreatedBy(UserCreatedBy.create(metaRequest.getUserId()));
command.setTenant(UserTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return UserMapper.toResponse(command);
}


}
