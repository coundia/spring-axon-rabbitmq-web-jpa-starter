package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetPagedResponse;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PasswordResetRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordResetFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private PasswordResetRepository passwordresetRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_get_all_passwordresets() {
		List<?> list = PasswordResetFixtures.randomManyViaCommand(commandGateway, 5, getUserId());

		String uri = "/v1/queries/passwordResets";
		ResponseEntity<PasswordResetPagedResponse> response = this.getForEntity(uri, PasswordResetPagedResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getContent()).isNotEmpty();
	}
}
