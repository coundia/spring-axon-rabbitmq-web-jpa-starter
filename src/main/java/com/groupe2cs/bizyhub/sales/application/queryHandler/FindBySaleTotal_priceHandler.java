package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindBySaleTotal_priceHandler {

private final SaleRepository repository;
@QueryHandler
public List<SaleResponse> handle(FindBySaleTotal_priceQuery query) {
Double value = query.getTotal_price().value();
	List<Sale> entities = repository.findByTotal_price(value);
	return entities.stream()
	.map(SaleMapper::toResponse)
	.toList();
	}

}
