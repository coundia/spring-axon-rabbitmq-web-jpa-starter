package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionRequest;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class RolePermissionCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_add_rolepermission() {

		RolePermissionRequest requestDTO = new RolePermissionRequest();

		requestDTO.setRole(RoleFixtures.randomOneViaCommand(commandGateway, userId).getId().value());
		requestDTO.setPermission(PermissionFixtures.randomOneViaCommand(commandGateway, userId).getId().value());

		String uri = "/v1/admin/commands/rolePermission";
		ResponseEntity<RolePermissionResponse>
				response =
				this.postForEntity(uri, requestDTO, RolePermissionResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getRole()).isEqualTo(requestDTO.getRole());
		assertThat(response.getBody().getPermission()).isEqualTo(requestDTO.getPermission());
	}
}
