package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRolePagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRoleFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
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


class UserRoleFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private UserRepository userDataRepository;
	@Autowired
	private RoleRepository roleDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_userRoles_for_normal_user() throws Exception {

		List<CreateUserRoleCommand> userCommands =
				UserRoleFixtures.randomManyViaCommand(
						commandGateway, userRoleRepository,
						userDataRepository,
						roleDataRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				UserRoleFixtures.byIdWaitExist(userRoleRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<UserRolePagedResponse> response = this.getForEntity(
				"/v1/admin/queries/userRoles?page=0&limit=1000000",
				UserRolePagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

	}

	@Test
	void it_should_return_all_userRoles_for_admin() throws Exception {

		List<CreateUserRoleCommand> userCommands =
				UserRoleFixtures.randomManyViaCommand(
						commandGateway,
						userRoleRepository,
						userDataRepository,
						roleDataRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				UserRoleFixtures.byIdWaitExist(userRoleRepository, cmd.getId().value())
		);


		List<CreateUserRoleCommand> adminCommands =
				UserRoleFixtures.randomManyViaCommand(
						commandGateway, userRoleRepository,
						userDataRepository,
						roleDataRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				UserRoleFixtures.byIdWaitExist(userRoleRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<UserRolePagedResponse> response = this.getForEntity(
				"/v1/admin/queries/userRoles?page=0&limit=1000000",
				UserRolePagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<UserRoleResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(UserRoleResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
