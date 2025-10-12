package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.application.command.UpdateAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserRequest;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountUserMapper;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountUserCreatedBy;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountUserId;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountUserTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountUserUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public AccountUserResponse updateAccountUser(AccountUserId id, AccountUserRequest request,
												 MetaRequest metaRequest
	) {

		UpdateAccountUserCommand command = AccountUserMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(AccountUserCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(AccountUserTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return AccountUserMapper.toResponse(command);
	}

}
