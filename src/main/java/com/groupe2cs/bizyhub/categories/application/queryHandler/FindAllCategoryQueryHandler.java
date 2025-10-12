package com.groupe2cs.bizyhub.categories.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.*;
import com.groupe2cs.bizyhub.categories.application.query.*;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
import com.groupe2cs.bizyhub.categories.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllCategoryQueryHandler {

	private final CategoryRepository repository;

	public FindAllCategoryQueryHandler(CategoryRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public CategoryPagedResponse handle(FindAllCategoryQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Category> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Categorys");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<CategoryResponse> responses = pages.stream()
				.map(CategoryMapper::toResponse)
				.toList();

		return CategoryPagedResponse.from(
				pages,
				responses
		);
	}
}
