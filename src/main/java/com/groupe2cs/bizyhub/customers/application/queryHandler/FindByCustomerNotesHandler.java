package com.groupe2cs.bizyhub.customers.application.queryHandler;

import com.groupe2cs.bizyhub.customers.application.mapper.*;
import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.*;
import com.groupe2cs.bizyhub.customers.application.query.*;
import com.groupe2cs.bizyhub.customers.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByCustomerNotesHandler {

private final CustomerRepository repository;

@QueryHandler
public List<CustomerResponse> handle(FindByCustomerNotesQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Customer> entities = null;
	 String value = query.getNotes().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByNotesAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByNotesAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(CustomerMapper::toResponse)
	.toList();
	}


}
