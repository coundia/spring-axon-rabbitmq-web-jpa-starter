package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.stock.application.command.CreateStockLevelCommand;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelPagedResponse;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelResponse;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockLevelFixtures;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockLevelRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class StockLevelFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private StockLevelRepository stockLevelRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_stockLevels_for_normal_user() throws Exception {

		List<CreateStockLevelCommand> userCommands =
				StockLevelFixtures.randomManyViaCommand(
						commandGateway, stockLevelRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				StockLevelFixtures.byIdWaitExist(stockLevelRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<StockLevelPagedResponse> response = this.getForEntity(
				"/v1/queries/stockLevels?page=0&limit=1000000",
				StockLevelPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<StockLevelResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(StockLevelResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_stockLevels_for_admin() throws Exception {

		List<CreateStockLevelCommand> userCommands =
				StockLevelFixtures.randomManyViaCommand(
						commandGateway,
						stockLevelRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				StockLevelFixtures.byIdWaitExist(stockLevelRepository, cmd.getId().value())
		);


		List<CreateStockLevelCommand> adminCommands =
				StockLevelFixtures.randomManyViaCommand(
						commandGateway, stockLevelRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				StockLevelFixtures.byIdWaitExist(stockLevelRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<StockLevelPagedResponse> response = this.getForEntity(
				"/v1/queries/stockLevels?page=0&limit=1000000",
				StockLevelPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<StockLevelResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(StockLevelResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
