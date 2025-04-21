package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreatePermissionCommand;
import com.groupe2cs.bizyhub.security.application.dto.PermissionRequest;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class PermissionUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_permission() {

		String existingId = PermissionFixtures.randomOneViaCommand(commandGateway).getId().value();

		CreatePermissionCommand updated = PermissionFixtures.randomOneViaCommand(commandGatewayUpdate);

		PermissionRequest requestDTO = new PermissionRequest();
		requestDTO.setName(UUID.randomUUID().toString());

		String uri = "/v1/commands/permission/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
