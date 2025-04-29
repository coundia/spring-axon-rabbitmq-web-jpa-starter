package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyRequest;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiKeyUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private ApiKeyRepository apikeyRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_apikey() {

		String existingId = ApiKeyFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();
		CreateApiKeyCommand updated = ApiKeyFixtures.randomOneViaCommand(commandGatewayUpdate, getCurrentUser());

		ApiKeyFixtures.byIdWaitExist(apikeyRepository, existingId);
		ApiKeyFixtures.byIdWaitExist(apikeyRepository, updated.getId().value());

		ApiKeyRequest requestDTO = new ApiKeyRequest();
		requestDTO.setAppKey(UUID.randomUUID().toString());
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setActive(false);
		requestDTO.setCreatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setExpiration(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/admin/commands/apiKey/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
