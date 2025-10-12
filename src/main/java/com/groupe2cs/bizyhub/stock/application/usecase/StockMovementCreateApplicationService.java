package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.command.CreateStockMovementCommand;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockMovementMapper;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementCreatedBy;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockMovementCreateApplicationService {
	private final CommandGateway commandGateway;

	public StockMovementResponse createStockMovement(StockMovementRequest request,
													 MetaRequest metaRequest
	) {

		CreateStockMovementCommand command = StockMovementMapper.toCommand(
				request
		);

		command.setCreatedBy(StockMovementCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(StockMovementTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return StockMovementMapper.toResponse(command);
	}


}
