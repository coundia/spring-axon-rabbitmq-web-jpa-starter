package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKeyFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiKeyUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private ApiKeyRepository apikeyRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_apikey() {

		String existingId = ApiKeyFixtures.randomOneViaCommand(
				commandGateway, apikeyRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		).getId().value();

		CreateApiKeyCommand updated = ApiKeyFixtures.randomOneViaCommand(
				commandGatewayUpdate, apikeyRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		);

		ApiKeyFixtures.byIdWaitExist(apikeyRepository, existingId);
		ApiKeyFixtures.byIdWaitExist(apikeyRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("appKey", UUID.randomUUID().toString());
		body.add("username", UUID.randomUUID().toString());
		body.add("active", false);
		body.add("expiration", java.time.Instant.now().plusSeconds(3600));

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/admin/commands/apiKey/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
