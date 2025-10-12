package com.groupe2cs.bizyhub.customers.application.queryHandler;

import com.groupe2cs.bizyhub.customers.application.dto.CustomerResponse;
import com.groupe2cs.bizyhub.customers.application.mapper.CustomerMapper;
import com.groupe2cs.bizyhub.customers.application.query.FindByCustomerFullNameQuery;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByCustomerFullNameHandler {

	private final CustomerRepository repository;

	@QueryHandler
	public List<CustomerResponse> handle(FindByCustomerFullNameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Customer> entities = null;
		String value = query.getFullName().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByFullNameAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByFullNameAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CustomerMapper::toResponse)
				.toList();
	}


}
