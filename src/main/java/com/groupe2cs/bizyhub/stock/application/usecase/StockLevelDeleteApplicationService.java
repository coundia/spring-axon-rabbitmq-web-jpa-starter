package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.command.DeleteStockLevelCommand;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockLevelDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteStockLevel(StockLevelId idVo, MetaRequest metaRequest) {

		DeleteStockLevelCommand command = new DeleteStockLevelCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
