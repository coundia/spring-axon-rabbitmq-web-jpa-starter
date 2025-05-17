package com.groupe2cs.bizyhub.chats.presentation.controller;

import com.groupe2cs.bizyhub.chats.application.command.CreateChatCommand;
import com.groupe2cs.bizyhub.chats.application.dto.ChatRequest;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.ChatFixtures;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.ChatRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_chat() {

		String existingId = ChatFixtures.randomOneViaCommand(
				commandGateway, chatRepository,
				accountDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		CreateChatCommand updated = ChatFixtures.randomOneViaCommand(commandGatewayUpdate,
				chatRepository,
				accountDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser());

		ChatFixtures.byIdWaitExist(chatRepository, existingId);
		ChatFixtures.byIdWaitExist(chatRepository, updated.getId().value());

		ChatRequest requestDTO = new ChatRequest();
		requestDTO.setMessages(UUID.randomUUID().toString());
		requestDTO.setResponsesJson(UUID.randomUUID().toString());
		requestDTO.setResponses(UUID.randomUUID().toString());
		requestDTO.setState(UUID.randomUUID().toString());
		requestDTO.setAccount(updated.getAccount().value());
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

		String uri = "/v1/commands/chat/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
