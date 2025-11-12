package com.groupe2cs.bizyhub.order.presentation.controller;

import com.groupe2cs.bizyhub.order.application.command.CreateOrderCommand;
import com.groupe2cs.bizyhub.order.application.dto.OrderPagedResponse;
import com.groupe2cs.bizyhub.order.application.dto.OrderResponse;
import com.groupe2cs.bizyhub.order.infrastructure.entity.OrderFixtures;
import com.groupe2cs.bizyhub.order.infrastructure.repository.OrderRepository;
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


class OrderFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_orders_for_normal_user() throws Exception {

		List<CreateOrderCommand> userCommands =
				OrderFixtures.randomManyViaCommand(
						commandGateway, orderRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				OrderFixtures.byIdWaitExist(orderRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<OrderPagedResponse> response = this.getForEntity(
				"/v1/queries/orders?page=0&limit=1000000",
				OrderPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<OrderResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(OrderResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_orders_for_admin() throws Exception {

		List<CreateOrderCommand> userCommands =
				OrderFixtures.randomManyViaCommand(
						commandGateway,
						orderRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				OrderFixtures.byIdWaitExist(orderRepository, cmd.getId().value())
		);


		List<CreateOrderCommand> adminCommands =
				OrderFixtures.randomManyViaCommand(
						commandGateway, orderRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				OrderFixtures.byIdWaitExist(orderRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<OrderPagedResponse> response = this.getForEntity(
				"/v1/queries/orders?page=0&limit=1000000",
				OrderPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<OrderResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(OrderResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
