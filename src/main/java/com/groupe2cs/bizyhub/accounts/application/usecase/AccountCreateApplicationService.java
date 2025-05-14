package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountCommand;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountRequest;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountMapper;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountCreatedBy;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCreateApplicationService {
	private final CommandGateway commandGateway;

	public AccountResponse createAccount(AccountRequest request,
										 MetaRequest metaRequest
	) {

		CreateAccountCommand command = AccountMapper.toCommand(
				request
		);

		command.setCreatedBy(AccountCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(AccountTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return AccountMapper.toResponse(command);
	}


}
