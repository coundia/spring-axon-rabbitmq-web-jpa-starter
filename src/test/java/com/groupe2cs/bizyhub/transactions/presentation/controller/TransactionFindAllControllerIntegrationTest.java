package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionPagedResponse;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class TransactionFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_transactions_for_normal_user() throws Exception {

		List<CreateTransactionCommand> userCommands =
				TransactionFixtures.randomManyViaCommand(
						commandGateway, transactionRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				TransactionFixtures.byIdWaitExist(transactionRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<TransactionPagedResponse> response = this.getForEntity(
				"/v1/queries/transactions?page=0&limit=1000000",
				TransactionPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<TransactionResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(TransactionResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_transactions_for_admin() throws Exception {

		List<CreateTransactionCommand> userCommands =
				TransactionFixtures.randomManyViaCommand(
						commandGateway,
						transactionRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				TransactionFixtures.byIdWaitExist(transactionRepository, cmd.getId().value())
		);


		List<CreateTransactionCommand> adminCommands =
				TransactionFixtures.randomManyViaCommand(
						commandGateway, transactionRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				TransactionFixtures.byIdWaitExist(transactionRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<TransactionPagedResponse> response = this.getForEntity(
				"/v1/queries/transactions?page=0&limit=1000000",
				TransactionPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<TransactionResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(TransactionResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
