package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionItemCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemPagedResponse;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemResponse;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItemFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionItemRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class TransactionItemFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private TransactionItemRepository transactionItemRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_transactionItems_for_normal_user() throws Exception {

		List<CreateTransactionItemCommand> userCommands =
				TransactionItemFixtures.randomManyViaCommand(
						commandGateway, transactionItemRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				TransactionItemFixtures.byIdWaitExist(transactionItemRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<TransactionItemPagedResponse> response = this.getForEntity(
				"/v1/queries/transactionItems?page=0&limit=1000000",
				TransactionItemPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<TransactionItemResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(TransactionItemResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_transactionItems_for_admin() throws Exception {

		List<CreateTransactionItemCommand> userCommands =
				TransactionItemFixtures.randomManyViaCommand(
						commandGateway,
						transactionItemRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				TransactionItemFixtures.byIdWaitExist(transactionItemRepository, cmd.getId().value())
		);


		List<CreateTransactionItemCommand> adminCommands =
				TransactionItemFixtures.randomManyViaCommand(
						commandGateway, transactionItemRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				TransactionItemFixtures.byIdWaitExist(transactionItemRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<TransactionItemPagedResponse> response = this.getForEntity(
				"/v1/queries/transactionItems?page=0&limit=1000000",
				TransactionItemPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<TransactionItemResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(TransactionItemResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
