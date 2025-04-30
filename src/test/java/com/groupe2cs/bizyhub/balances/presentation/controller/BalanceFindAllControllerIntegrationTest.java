package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.balances.application.command.CreateBalanceCommand;
import com.groupe2cs.bizyhub.balances.application.dto.BalancePagedResponse;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.BalanceFixtures;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class BalanceFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private BalanceRepository balanceRepository;

	@Test
	void it_should_return_only_user_balances_for_normal_user() throws Exception {

		List<CreateBalanceCommand> userCommands =
				BalanceFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
		userCommands.forEach(cmd ->
				BalanceFixtures.byIdWaitExist(balanceRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<BalancePagedResponse> response = this.getForEntity(
				"/v1/queries/balances?page=0&limit=1000000",
				BalancePagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<BalanceResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(BalanceResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_balances_for_admin() throws Exception {

		List<CreateBalanceCommand> userCommands =
				BalanceFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
		userCommands.forEach(cmd ->
				BalanceFixtures.byIdWaitExist(balanceRepository, cmd.getId().value())
		);


		List<CreateBalanceCommand> adminCommands =
				BalanceFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				BalanceFixtures.byIdWaitExist(balanceRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<BalancePagedResponse> response = this.getForEntity(
				"/v1/queries/balances?page=0&limit=1000000",
				BalancePagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<BalanceResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(BalanceResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
