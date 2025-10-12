package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.application.command.DeleteAccountCommand;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteAccount(AccountId idVo, MetaRequest metaRequest) {

		DeleteAccountCommand command = new DeleteAccountCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
