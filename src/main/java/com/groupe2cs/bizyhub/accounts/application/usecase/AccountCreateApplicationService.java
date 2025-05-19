package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountCreateApplicationService {
private final CommandGateway commandGateway;

public AccountResponse createAccount(AccountRequest request,
MetaRequest metaRequest
){

CreateAccountCommand command = AccountMapper.toCommand(
request
);

command.setCreatedBy(AccountCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(AccountTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return AccountMapper.toResponse(command);
}


}
