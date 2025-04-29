package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.RolePagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class RoleFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private RoleRepository roleRepository;

	@Test
	void it_should_return_only_user_roles_for_normal_user() throws Exception {

		List<CreateRoleCommand> userCommands =
				RoleFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
		userCommands.forEach(cmd ->
				RoleFixtures.byIdWaitExist(roleRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<RolePagedResponse> response = this.getForEntity(
				"/v1/admin/queries/roles?page=0&limit=1000000",
				RolePagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

	}

	@Test
	void it_should_return_all_roles_for_admin() throws Exception {

		List<CreateRoleCommand> userCommands =
				RoleFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
		userCommands.forEach(cmd ->
				RoleFixtures.byIdWaitExist(roleRepository, cmd.getId().value())
		);


		List<CreateRoleCommand> adminCommands =
				RoleFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				RoleFixtures.byIdWaitExist(roleRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<RolePagedResponse> response = this.getForEntity(
				"/v1/admin/queries/roles?page=0&limit=1000000",
				RolePagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<RoleResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(RoleResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
