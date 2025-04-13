package com.groupe2cs.bizyhub.products.application.queryHandler;

import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.products.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByProductIdHandler {

private final ProductRepository repository;
@QueryHandler
 public ProductResponse handle(FindByProductIdQuery query) {
	String value = query.getId().value();
	Product entity = repository.findById(value)
		.orElseThrow(() -> new ProductNotFoundException(query.getId()));
		return ProductMapper.toResponse(entity);
	}

}
