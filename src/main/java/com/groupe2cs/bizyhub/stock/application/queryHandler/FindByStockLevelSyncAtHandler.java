package com.groupe2cs.bizyhub.stock.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockLevelMapper;
import com.groupe2cs.bizyhub.stock.application.query.FindByStockLevelSyncAtQuery;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevel;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockLevelRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByStockLevelSyncAtHandler {

	private final StockLevelRepository repository;

	@QueryHandler
	public List<StockLevelResponse> handle(FindByStockLevelSyncAtQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<StockLevel> entities = null;
		java.time.Instant value = query.getSyncAt().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findBySyncAtAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findBySyncAtAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(StockLevelMapper::toResponse)
				.toList();
	}


}
