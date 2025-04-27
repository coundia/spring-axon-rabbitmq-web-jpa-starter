package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.RoleRequest;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_role() {

		String existingId = RoleFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();
		CreateRoleCommand updated = RoleFixtures.randomOneViaCommand(commandGatewayUpdate, getUserId());

		RoleFixtures.byIdWaitExist(roleRepository, existingId);
		RoleFixtures.byIdWaitExist(roleRepository, updated.getId().value());

		RoleRequest requestDTO = new RoleRequest();
		requestDTO.setName(UUID.randomUUID().toString());

		String uri = "/v1/admin/commands/role/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
