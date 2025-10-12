package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import com.groupe2cs.bizyhub.stock.application.command.UpdateStockMovementCommand;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockMovementMapper;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementCreatedBy;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementId;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockMovementUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public StockMovementResponse updateStockMovement(StockMovementId id, StockMovementRequest request,
													 MetaRequest metaRequest
	) {

		UpdateStockMovementCommand command = StockMovementMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(StockMovementCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(StockMovementTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return StockMovementMapper.toResponse(command);
	}

}
