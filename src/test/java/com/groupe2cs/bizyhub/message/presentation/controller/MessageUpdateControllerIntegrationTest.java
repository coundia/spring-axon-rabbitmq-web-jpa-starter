package com.groupe2cs.bizyhub.message.presentation.controller;

import com.groupe2cs.bizyhub.message.application.command.CreateMessageCommand;
import com.groupe2cs.bizyhub.message.infrastructure.entity.MessageFixtures;
import com.groupe2cs.bizyhub.message.infrastructure.repository.MessageRepository;
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

public class MessageUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_message() {

		String existingId = MessageFixtures.randomOneViaCommand(
				commandGateway, messageRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		).getId().value();

		CreateMessageCommand updated = MessageFixtures.randomOneViaCommand(
				commandGatewayUpdate, messageRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		);

		MessageFixtures.byIdWaitExist(messageRepository, existingId);
		MessageFixtures.byIdWaitExist(messageRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("code", UUID.randomUUID().toString());
		body.add("email", UUID.randomUUID().toString());
		body.add("phone", UUID.randomUUID().toString());
		body.add("content", UUID.randomUUID().toString());
		body.add("plateforme", UUID.randomUUID().toString());
		body.add("source", UUID.randomUUID().toString());
		body.add("agent", UUID.randomUUID().toString());
		body.add("status", UUID.randomUUID().toString());
		body.add("description", UUID.randomUUID().toString());
		body.add("isActive", false);
		body.add("isDefault", true);
		body.add("remoteId", UUID.randomUUID().toString());
		body.add("localId", UUID.randomUUID().toString());
		body.add("depotAt", java.time.Instant.now().plusSeconds(3600));
		body.add("syncAt", java.time.Instant.now().plusSeconds(3600));

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/commands/message/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
