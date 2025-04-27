package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionRequest;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class RolePermissionUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private RolePermissionRepository rolepermissionRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_rolepermission() {

		String existingId = RolePermissionFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();
		CreateRolePermissionCommand
				updated =
				RolePermissionFixtures.randomOneViaCommand(commandGatewayUpdate, getUserId());

		RolePermissionFixtures.byIdWaitExist(rolepermissionRepository, existingId);
		RolePermissionFixtures.byIdWaitExist(rolepermissionRepository, updated.getId().value());

		RolePermissionRequest requestDTO = new RolePermissionRequest();
		requestDTO.setRole(updated.getRole().value());
		requestDTO.setPermission(updated.getPermission().value());

		String uri = "/v1/admin/commands/rolePermission/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
