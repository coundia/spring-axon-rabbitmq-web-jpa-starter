package com.groupe2cs.bizyhub.stock.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockMovementMapper;
import com.groupe2cs.bizyhub.stock.application.query.FindByStockMovementCompanyQuery;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovement;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockMovementRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByStockMovementCompanyHandler {

	private final StockMovementRepository repository;

	@QueryHandler
	public List<StockMovementResponse> handle(FindByStockMovementCompanyQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<StockMovement> entities = null;
		String value = query.getCompany().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByCompanyAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByCompanyAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(StockMovementMapper::toResponse)
				.toList();
	}


}
