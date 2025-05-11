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
public class FindBySaleDetailsHandler {

private final SaleRepository repository;
@QueryHandler
public List<SaleResponse> handle(FindBySaleDetailsQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Sale> entities = null;
	 String value = query.getDetails().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByDetailsAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByDetailsAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(SaleMapper::toResponse)
	.toList();
	}


}
