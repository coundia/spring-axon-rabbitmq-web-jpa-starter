package com.groupe2cs.bizyhub.stock.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockLevelMapper;
import com.groupe2cs.bizyhub.stock.application.query.FindByStockLevelStockAllocatedQuery;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevel;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockLevelRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByStockLevelStockAllocatedHandler {

	private final StockLevelRepository repository;

	@QueryHandler
	public List<StockLevelResponse> handle(FindByStockLevelStockAllocatedQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<StockLevel> entities = null;
		Integer value = query.getStockAllocated().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByStockAllocatedAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByStockAllocatedAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(StockLevelMapper::toResponse)
				.toList();
	}


}
