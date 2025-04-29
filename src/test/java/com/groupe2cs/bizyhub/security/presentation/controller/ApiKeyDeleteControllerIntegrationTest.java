package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiKeyDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private ApiKeyRepository apikeyRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_delete_apikey() {
		String existingId = ApiKeyFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		ApiKeyFixtures.byIdWaitExist(apikeyRepository, existingId);

		String uri = "/v1/admin/commands/apiKey/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		ApiKey found = ApiKeyFixtures.byIdWaitNotExist(apikeyRepository, existingId);
		assertThat(found).isNull();
	}
}
