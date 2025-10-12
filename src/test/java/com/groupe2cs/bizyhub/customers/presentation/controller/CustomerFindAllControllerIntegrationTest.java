package com.groupe2cs.bizyhub.customers.presentation.controller;

import com.groupe2cs.bizyhub.customers.application.command.CreateCustomerCommand;
import com.groupe2cs.bizyhub.customers.application.dto.CustomerPagedResponse;
import com.groupe2cs.bizyhub.customers.application.dto.CustomerResponse;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class CustomerFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_customers_for_normal_user() throws Exception {

		List<CreateCustomerCommand> userCommands =
				CustomerFixtures.randomManyViaCommand(
						commandGateway, customerRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				CustomerFixtures.byIdWaitExist(customerRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<CustomerPagedResponse> response = this.getForEntity(
				"/v1/queries/customers?page=0&limit=1000000",
				CustomerPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<CustomerResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(CustomerResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_customers_for_admin() throws Exception {

		List<CreateCustomerCommand> userCommands =
				CustomerFixtures.randomManyViaCommand(
						commandGateway,
						customerRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				CustomerFixtures.byIdWaitExist(customerRepository, cmd.getId().value())
		);


		List<CreateCustomerCommand> adminCommands =
				CustomerFixtures.randomManyViaCommand(
						commandGateway, customerRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				CustomerFixtures.byIdWaitExist(customerRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<CustomerPagedResponse> response = this.getForEntity(
				"/v1/queries/customers?page=0&limit=1000000",
				CustomerPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<CustomerResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(CustomerResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
