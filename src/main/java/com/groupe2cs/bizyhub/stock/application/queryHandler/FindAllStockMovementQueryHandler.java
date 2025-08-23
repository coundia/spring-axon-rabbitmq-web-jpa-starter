package com.groupe2cs.bizyhub.stock.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.*;
import com.groupe2cs.bizyhub.stock.application.query.*;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
import com.groupe2cs.bizyhub.stock.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


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

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all StockMovements");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
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
