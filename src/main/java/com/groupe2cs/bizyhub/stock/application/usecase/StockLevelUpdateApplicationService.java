package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import com.groupe2cs.bizyhub.stock.application.command.UpdateStockLevelCommand;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockLevelMapper;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelCreatedBy;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelId;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockLevelUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public StockLevelResponse updateStockLevel(StockLevelId id, StockLevelRequest request,
											   MetaRequest metaRequest
	) {

		UpdateStockLevelCommand command = StockLevelMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(StockLevelCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(StockLevelTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return StockLevelMapper.toResponse(command);
	}

}
