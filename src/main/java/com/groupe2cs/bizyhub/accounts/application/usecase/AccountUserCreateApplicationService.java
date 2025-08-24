package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountUserCreateApplicationService {
private final CommandGateway commandGateway;

public AccountUserResponse createAccountUser(AccountUserRequest request,
MetaRequest metaRequest
){

CreateAccountUserCommand command = AccountUserMapper.toCommand(
request
);

command.setCreatedBy(AccountUserCreatedBy.create(metaRequest.getUserId()));
command.setTenant(AccountUserTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return AccountUserMapper.toResponse(command);
}


}
