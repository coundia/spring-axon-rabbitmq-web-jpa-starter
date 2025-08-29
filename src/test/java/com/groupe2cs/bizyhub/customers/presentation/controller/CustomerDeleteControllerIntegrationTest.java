package com.groupe2cs.bizyhub.customers.presentation.controller;

import com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_customer() {
		String existingId = CustomerFixtures.randomOneViaCommand(commandGateway, customerRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		CustomerFixtures.byIdWaitExist(customerRepository, existingId);

		String uri = "/v1/commands/customer/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Customer found = CustomerFixtures.byIdWaitNotExist(customerRepository, existingId);
		assertThat(found).isNull();
	}
}
