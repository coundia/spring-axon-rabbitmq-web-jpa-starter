package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.command.CreateStockLevelCommand;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockLevelMapper;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelCreatedBy;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockLevelCreateApplicationService {
	private final CommandGateway commandGateway;

	public StockLevelResponse createStockLevel(StockLevelRequest request,
											   MetaRequest metaRequest
	) {

		CreateStockLevelCommand command = StockLevelMapper.toCommand(
				request
		);

		command.setCreatedBy(StockLevelCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(StockLevelTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return StockLevelMapper.toResponse(command);
	}


}
