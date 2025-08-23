package com.groupe2cs.bizyhub.customers.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.*;
import com.groupe2cs.bizyhub.customers.application.query.*;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.*;
import com.groupe2cs.bizyhub.customers.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllCustomerQueryHandler {

private final CustomerRepository repository;

public FindAllCustomerQueryHandler(CustomerRepository repository) {
	this.repository = repository;
}

@QueryHandler
public CustomerPagedResponse handle(FindAllCustomerQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<Customer> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all Customers");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<CustomerResponse> responses = pages.stream()
	.map(CustomerMapper::toResponse)
	.toList();

	return CustomerPagedResponse.from(
	pages,
	responses
	);
	}
}
