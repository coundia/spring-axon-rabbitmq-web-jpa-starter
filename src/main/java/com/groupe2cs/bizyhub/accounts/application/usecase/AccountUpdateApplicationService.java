package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.application.command.UpdateAccountCommand;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountRequest;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountMapper;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountCreatedBy;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountId;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public AccountResponse updateAccount(AccountId id, AccountRequest request,
										 MetaRequest metaRequest
	) {

		UpdateAccountCommand command = AccountMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(AccountCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(AccountTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return AccountMapper.toResponse(command);
	}

}
