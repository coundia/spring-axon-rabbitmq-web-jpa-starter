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
public class FindAllStockLevelQueryHandler {

private final StockLevelRepository repository;

public FindAllStockLevelQueryHandler(StockLevelRepository repository) {
	this.repository = repository;
}

@QueryHandler
public StockLevelPagedResponse handle(FindAllStockLevelQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<StockLevel> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all StockLevels");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{

log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);


}

List<StockLevelResponse> responses = pages.stream()
	.map(StockLevelMapper::toResponse)
	.toList();

	return StockLevelPagedResponse.from(
	pages,
	responses
	);
	}
}
