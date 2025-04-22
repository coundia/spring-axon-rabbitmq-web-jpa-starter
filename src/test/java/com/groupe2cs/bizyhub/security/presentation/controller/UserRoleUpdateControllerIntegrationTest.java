package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateUserRoleCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleRequest;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRoleUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private UserRoleRepository userroleRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_userrole() {

		String existingId = UserRoleFixtures.randomOneViaCommand(commandGateway).getId().value();

		CreateUserRoleCommand updated = UserRoleFixtures.randomOneViaCommand(commandGatewayUpdate);

		UserRoleRequest requestDTO = new UserRoleRequest();
		requestDTO.setUser(updated.getUser().value());
		requestDTO.setRole(updated.getRole().value());

		String uri = "/v1/commands/userRole/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
