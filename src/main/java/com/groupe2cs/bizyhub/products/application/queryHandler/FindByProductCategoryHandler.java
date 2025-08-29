package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.application.query.FindByProductCategoryQuery;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByProductCategoryHandler {

	private final ProductRepository repository;

	@QueryHandler
	public List<ProductResponse> handle(FindByProductCategoryQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Product> entities = null;
		String value = query.getCategory().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByCategoryAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByCategoryAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(ProductMapper::toResponse)
				.toList();
	}


}
