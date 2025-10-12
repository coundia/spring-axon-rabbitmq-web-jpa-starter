package com.groupe2cs.bizyhub.customers.application.queryHandler;

import com.groupe2cs.bizyhub.customers.application.dto.CustomerPagedResponse;
import com.groupe2cs.bizyhub.customers.application.dto.CustomerResponse;
import com.groupe2cs.bizyhub.customers.application.mapper.CustomerMapper;
import com.groupe2cs.bizyhub.customers.application.query.FindAllCustomerQuery;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


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

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Customers");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


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
