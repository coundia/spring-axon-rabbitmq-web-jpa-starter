package com.groupe2cs.bizyhub.balances.application.usecase;

import com.groupe2cs.bizyhub.balances.application.command.DeleteBalanceCommand;
import com.groupe2cs.bizyhub.balances.domain.valueObject.BalanceId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteBalance(BalanceId idVo, MetaRequest metaRequest) {

		DeleteBalanceCommand command = new DeleteBalanceCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
