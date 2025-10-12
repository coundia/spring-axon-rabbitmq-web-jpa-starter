package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.stock.application.command.CreateStockMovementCommand;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementPagedResponse;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementResponse;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovementFixtures;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockMovementRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class StockMovementFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private StockMovementRepository stockMovementRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_stockMovements_for_normal_user() throws Exception {

		List<CreateStockMovementCommand> userCommands =
				StockMovementFixtures.randomManyViaCommand(
						commandGateway, stockMovementRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				StockMovementFixtures.byIdWaitExist(stockMovementRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<StockMovementPagedResponse> response = this.getForEntity(
				"/v1/queries/stockMovements?page=0&limit=1000000",
				StockMovementPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<StockMovementResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(StockMovementResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_stockMovements_for_admin() throws Exception {

		List<CreateStockMovementCommand> userCommands =
				StockMovementFixtures.randomManyViaCommand(
						commandGateway,
						stockMovementRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				StockMovementFixtures.byIdWaitExist(stockMovementRepository, cmd.getId().value())
		);


		List<CreateStockMovementCommand> adminCommands =
				StockMovementFixtures.randomManyViaCommand(
						commandGateway, stockMovementRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				StockMovementFixtures.byIdWaitExist(stockMovementRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<StockMovementPagedResponse> response = this.getForEntity(
				"/v1/queries/stockMovements?page=0&limit=1000000",
				StockMovementPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<StockMovementResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(StockMovementResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
