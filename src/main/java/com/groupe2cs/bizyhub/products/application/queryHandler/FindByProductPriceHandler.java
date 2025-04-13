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
public class FindByProductPriceHandler {

private final ProductRepository repository;
@QueryHandler
public List<ProductResponse> handle(FindByProductPriceQuery query) {
Double value = query.getPrice().value();
	List<Product> entities = repository.findByPrice(value);
	return entities.stream()
	.map(ProductMapper::toResponse)
	.toList();
	}

}
