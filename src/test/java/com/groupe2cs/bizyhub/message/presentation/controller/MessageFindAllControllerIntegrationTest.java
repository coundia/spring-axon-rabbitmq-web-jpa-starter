package com.groupe2cs.bizyhub.message.presentation.controller;

import com.groupe2cs.bizyhub.message.application.command.CreateMessageCommand;
import com.groupe2cs.bizyhub.message.application.dto.MessagePagedResponse;
import com.groupe2cs.bizyhub.message.application.dto.MessageResponse;
import com.groupe2cs.bizyhub.message.infrastructure.entity.MessageFixtures;
import com.groupe2cs.bizyhub.message.infrastructure.repository.MessageRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class MessageFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_messages_for_normal_user() throws Exception {

		List<CreateMessageCommand> userCommands =
				MessageFixtures.randomManyViaCommand(
						commandGateway, messageRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				MessageFixtures.byIdWaitExist(messageRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<MessagePagedResponse> response = this.getForEntity(
				"/v1/queries/messages?page=0&limit=1000000",
				MessagePagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<MessageResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(MessageResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_messages_for_admin() throws Exception {

		List<CreateMessageCommand> userCommands =
				MessageFixtures.randomManyViaCommand(
						commandGateway,
						messageRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				MessageFixtures.byIdWaitExist(messageRepository, cmd.getId().value())
		);


		List<CreateMessageCommand> adminCommands =
				MessageFixtures.randomManyViaCommand(
						commandGateway, messageRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				MessageFixtures.byIdWaitExist(messageRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<MessagePagedResponse> response = this.getForEntity(
				"/v1/queries/messages?page=0&limit=1000000",
				MessagePagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<MessageResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(MessageResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
