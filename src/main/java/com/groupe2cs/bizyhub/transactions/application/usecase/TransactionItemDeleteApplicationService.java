package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionItemCommand;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionItemId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionItemDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteTransactionItem(TransactionItemId idVo, MetaRequest metaRequest) {

		DeleteTransactionItemCommand command = new DeleteTransactionItemCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
