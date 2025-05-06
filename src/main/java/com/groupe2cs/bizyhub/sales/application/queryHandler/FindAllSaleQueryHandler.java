package com.groupe2cs.bizyhub.sales.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllSaleQueryHandler {

private final SaleRepository repository;

public FindAllSaleQueryHandler(SaleRepository repository) {
	this.repository = repository;
}

@QueryHandler
public SalePagedResponse handle(FindAllSaleQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<Sale> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all Sales");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
 log.info("User, fetching own  ");
  	pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<SaleResponse> responses = pages.stream()
	.map(SaleMapper::toResponse)
	.toList();

	return SalePagedResponse.from(
	pages,
	responses
	);
	}
}
