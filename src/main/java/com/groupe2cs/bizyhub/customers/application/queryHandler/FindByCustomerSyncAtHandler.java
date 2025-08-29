package com.groupe2cs.bizyhub.customers.application.queryHandler;

import com.groupe2cs.bizyhub.customers.application.dto.CustomerResponse;
import com.groupe2cs.bizyhub.customers.application.mapper.CustomerMapper;
import com.groupe2cs.bizyhub.customers.application.query.FindByCustomerSyncAtQuery;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByCustomerSyncAtHandler {

	private final CustomerRepository repository;

	@QueryHandler
	public List<CustomerResponse> handle(FindByCustomerSyncAtQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Customer> entities = null;
		java.time.Instant value = query.getSyncAt().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findBySyncAtAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findBySyncAtAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CustomerMapper::toResponse)
				.toList();
	}


}
