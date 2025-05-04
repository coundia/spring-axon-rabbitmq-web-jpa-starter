package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindBySaleReferenceHandler {

private final SaleRepository repository;
@QueryHandler
public List<SaleResponse> handle(FindBySaleReferenceQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();

String value = query.getReference().value();
	List<Sale> entities = repository.findByReferenceAndCreatedById(value, metaRequest.getUserId());
	return entities.stream()
	.map(SaleMapper::toResponse)
	.toList();
	}


}
