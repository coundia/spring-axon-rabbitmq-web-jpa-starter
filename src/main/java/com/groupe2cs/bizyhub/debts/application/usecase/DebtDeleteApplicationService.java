package com.groupe2cs.bizyhub.debts.application.usecase;

import com.groupe2cs.bizyhub.debts.application.command.DeleteDebtCommand;
import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebtDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteDebt(DebtId idVo, MetaRequest metaRequest) {

		DeleteDebtCommand command = new DeleteDebtCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
