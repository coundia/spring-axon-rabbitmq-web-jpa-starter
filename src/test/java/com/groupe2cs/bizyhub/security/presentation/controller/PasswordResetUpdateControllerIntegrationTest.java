package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordResetUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private PasswordResetRepository passwordresetRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_passwordreset() {

		String existingId = PasswordResetFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();

		CreatePasswordResetCommand
				updated =
				PasswordResetFixtures.randomOneViaCommand(commandGatewayUpdate, getUserId());

		PasswordResetRequest requestDTO = new PasswordResetRequest();
		requestDTO.setToken(UUID.randomUUID().toString());
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setExpiration(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/commands/passwordReset/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
