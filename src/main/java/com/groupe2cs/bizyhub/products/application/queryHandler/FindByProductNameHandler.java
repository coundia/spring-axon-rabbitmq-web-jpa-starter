package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.products.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByProductNameHandler {

private final ProductRepository repository;
@QueryHandler

 public ProductResponse handle(FindByProductNameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

	String value = query.getName().value();
	Product entity = repository.findByNameAndCreatedById(value, metaRequest.getUserId())
		.orElse(null);

		if (entity == null) {
			return null;
		}

		return ProductMapper.toResponse(entity);
	}

}
