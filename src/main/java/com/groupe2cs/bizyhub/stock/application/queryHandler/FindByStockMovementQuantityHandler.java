package com.groupe2cs.bizyhub.stock.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockMovementMapper;
import com.groupe2cs.bizyhub.stock.application.query.FindByStockMovementQuantityQuery;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovement;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockMovementRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByStockMovementQuantityHandler {

	private final StockMovementRepository repository;

	@QueryHandler
	public List<StockMovementResponse> handle(FindByStockMovementQuantityQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<StockMovement> entities = null;
		Integer value = query.getQuantity().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByQuantityAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByQuantityAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(StockMovementMapper::toResponse)
				.toList();
	}


}
