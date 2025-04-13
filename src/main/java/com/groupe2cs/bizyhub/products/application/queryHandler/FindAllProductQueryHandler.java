package com.groupe2cs.bizyhub.products.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.application.mapper.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Component
public class FindAllProductQueryHandler {

private final ProductRepository repository;

public FindAllProductQueryHandler(ProductRepository repository) {
	this.repository = repository;
}

@QueryHandler
public ProductPagedResponse handle(FindAllProductQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;

long totalElements = repository.count();

PageRequest pageable = PageRequest.of(offset / limit, limit);

Page<Product> pages = repository.findAll(pageable);

List<ProductResponse> responses = pages.stream()
	.map(ProductMapper::toResponse)
	.toList();

	return ProductPagedResponse.from(
	pages,
	responses
	);
	}
}
