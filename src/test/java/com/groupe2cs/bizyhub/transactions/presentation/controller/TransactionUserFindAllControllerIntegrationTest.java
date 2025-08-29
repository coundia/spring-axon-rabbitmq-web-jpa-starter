package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionUserCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserPagedResponse;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserResponse;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionUserFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionUserRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class TransactionUserFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private TransactionUserRepository transactionUserRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_transactionUsers_for_normal_user() throws Exception {

		List<CreateTransactionUserCommand> userCommands =
				TransactionUserFixtures.randomManyViaCommand(
						commandGateway, transactionUserRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				TransactionUserFixtures.byIdWaitExist(transactionUserRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<TransactionUserPagedResponse> response = this.getForEntity(
				"/v1/queries/transactionUsers?page=0&limit=1000000",
				TransactionUserPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<TransactionUserResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(TransactionUserResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_transactionUsers_for_admin() throws Exception {

		List<CreateTransactionUserCommand> userCommands =
				TransactionUserFixtures.randomManyViaCommand(
						commandGateway,
						transactionUserRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				TransactionUserFixtures.byIdWaitExist(transactionUserRepository, cmd.getId().value())
		);


		List<CreateTransactionUserCommand> adminCommands =
				TransactionUserFixtures.randomManyViaCommand(
						commandGateway, transactionUserRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				TransactionUserFixtures.byIdWaitExist(transactionUserRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<TransactionUserPagedResponse> response = this.getForEntity(
				"/v1/queries/transactionUsers?page=0&limit=1000000",
				TransactionUserPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<TransactionUserResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(TransactionUserResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
