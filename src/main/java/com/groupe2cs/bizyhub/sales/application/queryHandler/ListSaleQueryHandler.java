package com.groupe2cs.bizyhub.sales.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Component
public class ListSaleQueryHandler {

private final SaleRepository repository;

public ListSaleQueryHandler(SaleRepository repository) {
	this.repository = repository;
}

@QueryHandler
public SalePagedResponse handle(ListSaleQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;

long totalElements = repository.count();

PageRequest pageable = PageRequest.of(offset / limit, limit);

Page<Sale> pages = repository.findAll(pageable);

List<SaleResponse> responses = pages.stream()
	.map(SaleMapper::toResponse)
	.toList();

	return SalePagedResponse.from(
	pages,
	responses
	);
	}
}
