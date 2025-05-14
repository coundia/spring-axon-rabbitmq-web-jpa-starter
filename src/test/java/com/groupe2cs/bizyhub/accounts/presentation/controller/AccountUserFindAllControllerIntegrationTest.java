package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserPagedResponse;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserResponse;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUserFixtures;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountUserRepository;
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


class AccountUserFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private AccountUserRepository accountUserRepository;

	@Autowired
	private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
	@Autowired
	private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_accountUsers_for_normal_user() throws Exception {

		List<CreateAccountUserCommand> userCommands =
				AccountUserFixtures.randomManyViaCommand(
						commandGateway, accountUserRepository,
						accountDataRepository,
						userDataRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				AccountUserFixtures.byIdWaitExist(accountUserRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<AccountUserPagedResponse> response = this.getForEntity(
				"/v1/queries/accountUsers?page=0&limit=1000000",
				AccountUserPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<AccountUserResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(AccountUserResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_accountUsers_for_admin() throws Exception {

		List<CreateAccountUserCommand> userCommands =
				AccountUserFixtures.randomManyViaCommand(
						commandGateway,
						accountUserRepository,
						accountDataRepository,
						userDataRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				AccountUserFixtures.byIdWaitExist(accountUserRepository, cmd.getId().value())
		);


		List<CreateAccountUserCommand> adminCommands =
				AccountUserFixtures.randomManyViaCommand(
						commandGateway, accountUserRepository,
						accountDataRepository,
						userDataRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				AccountUserFixtures.byIdWaitExist(accountUserRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<AccountUserPagedResponse> response = this.getForEntity(
				"/v1/queries/accountUsers?page=0&limit=1000000",
				AccountUserPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<AccountUserResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(AccountUserResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
