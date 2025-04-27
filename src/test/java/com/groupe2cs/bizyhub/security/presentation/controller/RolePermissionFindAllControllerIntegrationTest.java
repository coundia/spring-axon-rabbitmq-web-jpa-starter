package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class RolePermissionFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private RolePermissionRepository rolePermissionRepository;

	@Test
	void it_should_return_only_user_rolePermissions_for_normal_user() throws Exception {
		String userId = login("user", "user");
		List<CreateRolePermissionCommand> userCommands =
				RolePermissionFixtures.randomManyViaCommand(commandGateway, 3, userId);
		userCommands.forEach(cmd ->
				RolePermissionFixtures.byIdWaitExist(rolePermissionRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<RolePermissionPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/rolePermissions?page=0&limit=1000000",
				RolePermissionPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

	}

	@Test
	void it_should_return_all_rolePermissions_for_admin() throws Exception {
		String userId = login("user", "user");
		List<CreateRolePermissionCommand> userCommands =
				RolePermissionFixtures.randomManyViaCommand(commandGateway, 5, userId);
		userCommands.forEach(cmd ->
				RolePermissionFixtures.byIdWaitExist(rolePermissionRepository, cmd.getId().value())
		);

		String adminId = login("admin", "admin");
		List<CreateRolePermissionCommand> adminCommands =
				RolePermissionFixtures.randomManyViaCommand(commandGateway, 5, adminId);
		adminCommands.forEach(cmd ->
				RolePermissionFixtures.byIdWaitExist(rolePermissionRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<RolePermissionPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/rolePermissions?page=0&limit=1000000",
				RolePermissionPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<RolePermissionResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(RolePermissionResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
