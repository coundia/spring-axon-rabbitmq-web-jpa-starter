package com.groupe2cs.bizyhub.categories.application.queryHandler;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.application.mapper.CategoryMapper;
import com.groupe2cs.bizyhub.categories.application.query.FindByCategoryReferenceQuery;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByCategoryReferenceHandler {

	private final CategoryRepository repository;

	@QueryHandler
	public List<CategoryResponse> handle(FindByCategoryReferenceQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Category> entities = null;
		String value = query.getReference().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByReferenceAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByReferenceAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CategoryMapper::toResponse)
				.toList();
	}


}
