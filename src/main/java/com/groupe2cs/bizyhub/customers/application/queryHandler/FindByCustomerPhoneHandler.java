package com.groupe2cs.bizyhub.customers.application.queryHandler;

import com.groupe2cs.bizyhub.customers.application.dto.CustomerResponse;
import com.groupe2cs.bizyhub.customers.application.mapper.CustomerMapper;
import com.groupe2cs.bizyhub.customers.application.query.FindByCustomerPhoneQuery;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByCustomerPhoneHandler {

	private final CustomerRepository repository;

	@QueryHandler
	public List<CustomerResponse> handle(FindByCustomerPhoneQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Customer> entities = null;
		String value = query.getPhone().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByPhoneAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByPhoneAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CustomerMapper::toResponse)
				.toList();
	}


}
