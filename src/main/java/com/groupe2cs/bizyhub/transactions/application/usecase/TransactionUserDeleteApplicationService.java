package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionUserCommand;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionUserId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionUserDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteTransactionUser(TransactionUserId idVo, MetaRequest metaRequest) {

		DeleteTransactionUserCommand command = new DeleteTransactionUserCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
