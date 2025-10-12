package com.groupe2cs.bizyhub.products.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
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
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Product> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Products");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<ProductResponse> responses = pages.stream()
				.map(ProductMapper::toResponse)
				.toList();

		return ProductPagedResponse.from(
				pages,
				responses
		);
	}
}
