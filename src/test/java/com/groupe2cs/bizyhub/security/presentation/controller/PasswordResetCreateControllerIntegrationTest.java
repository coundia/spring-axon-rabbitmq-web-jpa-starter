package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordResetCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_add_passwordreset() {

		PasswordResetRequest requestDTO = new PasswordResetRequest();

		requestDTO.setToken(UUID.randomUUID().toString());
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setExpiration(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/commands/passwordReset";
		ResponseEntity<PasswordResetResponse>
				response =
				this.postForEntity(uri, requestDTO, PasswordResetResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getToken()).isEqualTo(requestDTO.getToken());
		assertThat(response.getBody().getUsername()).isEqualTo(requestDTO.getUsername());
		assertThat(response.getBody().getExpiration()).isEqualTo(requestDTO.getExpiration());
	}
}
