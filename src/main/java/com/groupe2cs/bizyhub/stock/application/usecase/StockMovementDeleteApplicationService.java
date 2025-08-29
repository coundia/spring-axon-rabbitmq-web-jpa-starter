package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.command.DeleteStockMovementCommand;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockMovementDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteStockMovement(StockMovementId idVo, MetaRequest metaRequest) {

		DeleteStockMovementCommand command = new DeleteStockMovementCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
