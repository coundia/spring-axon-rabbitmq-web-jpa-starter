package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.application.command.DeleteAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountUserId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountUserDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteAccountUser(AccountUserId idVo, MetaRequest metaRequest) {

		DeleteAccountUserCommand command = new DeleteAccountUserCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
