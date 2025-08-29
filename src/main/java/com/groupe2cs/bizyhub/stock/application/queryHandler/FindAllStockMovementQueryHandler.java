package com.groupe2cs.bizyhub.stock.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementPagedResponse;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementResponse;
import com.groupe2cs.bizyhub.stock.application.mapper.StockMovementMapper;
import com.groupe2cs.bizyhub.stock.application.query.FindAllStockMovementQuery;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovement;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockMovementRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllStockMovementQueryHandler {

	private final StockMovementRepository repository;

	public FindAllStockMovementQueryHandler(StockMovementRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public StockMovementPagedResponse handle(FindAllStockMovementQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<StockMovement> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all StockMovements");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<StockMovementResponse> responses = pages.stream()
				.map(StockMovementMapper::toResponse)
				.toList();

		return StockMovementPagedResponse.from(
				pages,
				responses
		);
	}
}
