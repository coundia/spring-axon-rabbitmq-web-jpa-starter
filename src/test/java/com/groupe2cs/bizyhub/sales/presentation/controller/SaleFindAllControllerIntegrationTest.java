package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.command.CreateSaleCommand;
import com.groupe2cs.bizyhub.sales.application.dto.SalePagedResponse;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleFixtures;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class SaleFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private SaleRepository saleRepository;

	@Test
	void it_should_return_only_user_sales_for_normal_user() throws Exception {

		List<CreateSaleCommand> userCommands =
				SaleFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));

		userCommands.forEach(cmd ->
				SaleFixtures.byIdWaitExist(saleRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<SalePagedResponse> response = this.getForEntity(
				"/v1/queries/sales?page=0&limit=1000000",
				SalePagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<SaleResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(SaleResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_sales_for_admin() throws Exception {

		List<CreateSaleCommand> userCommands =
				SaleFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
		userCommands.forEach(cmd ->
				SaleFixtures.byIdWaitExist(saleRepository, cmd.getId().value())
		);


		List<CreateSaleCommand> adminCommands =
				SaleFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				SaleFixtures.byIdWaitExist(saleRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<SalePagedResponse> response = this.getForEntity(
				"/v1/queries/sales?page=0&limit=1000000",
				SalePagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<SaleResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(SaleResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
