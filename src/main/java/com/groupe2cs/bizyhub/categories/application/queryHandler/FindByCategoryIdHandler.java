package com.groupe2cs.bizyhub.categories.application.queryHandler;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.application.mapper.CategoryMapper;
import com.groupe2cs.bizyhub.categories.application.query.FindByCategoryIdQuery;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByCategoryIdHandler {

	private final CategoryRepository repository;

	@QueryHandler

	public CategoryResponse handle(FindByCategoryIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		String value = query.getId().value();
		Category entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return CategoryMapper.toResponse(entity);
	}

}
