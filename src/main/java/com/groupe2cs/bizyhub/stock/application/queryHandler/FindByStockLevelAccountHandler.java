package com.groupe2cs.bizyhub.stock.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockLevelMapper;
import com.groupe2cs.bizyhub.stock.application.query.FindByStockLevelAccountQuery;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevel;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockLevelRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByStockLevelAccountHandler {

	private final StockLevelRepository repository;

	@QueryHandler
	public List<StockLevelResponse> handle(FindByStockLevelAccountQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<StockLevel> entities = null;
		String value = query.getAccount().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByAccountAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByAccountAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(StockLevelMapper::toResponse)
				.toList();
	}


}
