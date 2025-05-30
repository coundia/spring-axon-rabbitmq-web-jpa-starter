package com.groupe2cs.bizyhub.chats.presentation.controller;

import com.groupe2cs.bizyhub.chats.application.command.CreateChatCommand;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.ChatFixtures;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.ChatRepository;
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

public class ChatUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private ChatRepository chatRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
	@Autowired
	private FileManagerRepository filesDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_chat() {

		String existingId = ChatFixtures.randomOneViaCommand(
				commandGateway, chatRepository,
				accountDataRepository,
				filesDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		).getId().value();

		CreateChatCommand updated = ChatFixtures.randomOneViaCommand(
				commandGatewayUpdate, chatRepository,
				accountDataRepository,
				filesDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		);

		ChatFixtures.byIdWaitExist(chatRepository, existingId);
		ChatFixtures.byIdWaitExist(chatRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("messages", UUID.randomUUID().toString());
		body.add("responsesJson", UUID.randomUUID().toString());
		body.add("responses", UUID.randomUUID().toString());
		body.add("state", UUID.randomUUID().toString());
		body.add("account", updated.getAccount().value());

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/commands/chat/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
