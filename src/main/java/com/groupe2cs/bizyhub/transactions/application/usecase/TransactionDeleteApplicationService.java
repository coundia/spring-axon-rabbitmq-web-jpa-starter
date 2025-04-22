package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionCommand;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteTransaction(TransactionId idVo) {

		DeleteTransactionCommand command = new DeleteTransactionCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
