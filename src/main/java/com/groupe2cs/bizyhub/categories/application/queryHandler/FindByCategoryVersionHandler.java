package com.groupe2cs.bizyhub.categories.application.queryHandler;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.application.mapper.CategoryMapper;
import com.groupe2cs.bizyhub.categories.application.query.FindByCategoryVersionQuery;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByCategoryVersionHandler {

	private final CategoryRepository repository;

	@QueryHandler
	public List<CategoryResponse> handle(FindByCategoryVersionQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Category> entities = null;
		Integer value = query.getVersion().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByVersionAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByVersionAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CategoryMapper::toResponse)
				.toList();
	}


}
