package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserRequest;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class UserUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_user() {

		String existingId = UserFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();

		CreateUserCommand updated = UserFixtures.randomOneViaCommand(commandGatewayUpdate, getUserId());

		UserRequest requestDTO = new UserRequest();
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setPassword(UUID.randomUUID().toString());

		String uri = "/v1/commands/user/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
