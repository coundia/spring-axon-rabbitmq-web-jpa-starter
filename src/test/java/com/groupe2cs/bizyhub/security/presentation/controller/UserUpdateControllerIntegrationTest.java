package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
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

	String existingId = UserFixtures.randomOneViaCommand(commandGateway).getId().value();

	CreateUserCommand updated = UserFixtures.randomOneViaCommand(commandGatewayUpdate);

	UserRequest requestDTO = new UserRequest();
	 requestDTO.setUsername(UUID.randomUUID().toString());
	 requestDTO.setPassword(UUID.randomUUID().toString());
	 requestDTO.setEmail(UUID.randomUUID().toString());

	String uri = "/v1/commands/user/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	User found = UserFixtures.byIdWaitExist(userRepository, existingId);
	assertThat(found).isNotNull();
			assertThat(found.getUsername()).isEqualTo(requestDTO.getUsername());
			assertThat(found.getPassword()).isEqualTo(requestDTO.getPassword());
			assertThat(found.getEmail()).isEqualTo(requestDTO.getEmail());

	}
}
