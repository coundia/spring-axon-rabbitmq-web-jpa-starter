package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreatePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.PermissionPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class PermissionFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private PermissionRepository permissionRepository;

	@Test
	void it_should_return_only_user_permissions_for_normal_user() throws Exception {

		List<CreatePermissionCommand> userCommands =
				PermissionFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
		userCommands.forEach(cmd ->
				PermissionFixtures.byIdWaitExist(permissionRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<PermissionPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/permissions?page=0&limit=1000000",
				PermissionPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

	}

	@Test
	void it_should_return_all_permissions_for_admin() throws Exception {

		List<CreatePermissionCommand> userCommands =
				PermissionFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
		userCommands.forEach(cmd ->
				PermissionFixtures.byIdWaitExist(permissionRepository, cmd.getId().value())
		);


		List<CreatePermissionCommand> adminCommands =
				PermissionFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				PermissionFixtures.byIdWaitExist(permissionRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<PermissionPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/permissions?page=0&limit=1000000",
				PermissionPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<PermissionResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(PermissionResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
