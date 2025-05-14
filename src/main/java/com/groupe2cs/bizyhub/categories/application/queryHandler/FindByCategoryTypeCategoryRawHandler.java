package com.groupe2cs.bizyhub.categories.application.queryHandler;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.application.mapper.CategoryMapper;
import com.groupe2cs.bizyhub.categories.application.query.FindByCategoryTypeCategoryRawQuery;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByCategoryTypeCategoryRawHandler {

	private final CategoryRepository repository;

	@QueryHandler
	public List<CategoryResponse> handle(FindByCategoryTypeCategoryRawQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Category> entities = null;
		String value = query.getTypeCategoryRaw().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByTypeCategoryRawAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByTypeCategoryRawAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CategoryMapper::toResponse)
				.toList();
	}


}
