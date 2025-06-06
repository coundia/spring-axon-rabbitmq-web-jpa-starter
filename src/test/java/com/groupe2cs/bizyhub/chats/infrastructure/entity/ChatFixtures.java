package com.groupe2cs.bizyhub.chats.infrastructure.entity;

import com.groupe2cs.bizyhub.chats.application.command.CreateChatCommand;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.ChatRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class ChatFixtures {

	public static Chat byId(ChatRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Chat byIdWaitExist(ChatRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Chat byIdWaitNotExist(ChatRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateChatCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			ChatRepository repository,
			com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository,
			FileManagerRepository filesDataRepository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateChatCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateChatCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					accountDataRepository,
					filesDataRepository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(ChatRepository repository) {
		repository.deleteAll();
	}

	public static CreateChatCommand randomOneViaCommand(
			CommandGateway commandGateway,
			ChatRepository repository,
			com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository,
			FileManagerRepository filesDataRepository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {
		MockMultipartFile files = new MockMultipartFile("fake", "fake.txt", "text/plain", "Hello".getBytes());
		String fileName = files.getName();

		CreateChatCommand command = CreateChatCommand.builder()
				.messages(ChatMessages.create(UUID.randomUUID().toString()))
				.responsesJson(ChatResponsesJson.create(UUID.randomUUID().toString()))
				.responses(ChatResponses.create(UUID.randomUUID().toString()))
				.state(ChatState.create(UUID.randomUUID().toString()))
				.account(ChatAccount.create(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(
						commandGateway,
						accountDataRepository,
						user).getId().value()))
				.files(ChatFiles.create(fileName))
				.build();

		command.setCreatedBy(ChatCreatedBy.create(user.getId()));
		command.setTenant(ChatTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateChatCommand randomOneViaCommand(
			CommandGateway commandGateway,
			ChatRepository repository,
			User user
	) {
		MockMultipartFile files = new MockMultipartFile("fake", "fake.txt", "text/plain", "Hello".getBytes());
		String fileName = files.getName();

		CreateChatCommand command = CreateChatCommand.builder()
				.messages(ChatMessages.create(UUID.randomUUID().toString()))
				.responsesJson(ChatResponsesJson.create(UUID.randomUUID().toString()))
				.responses(ChatResponses.create(UUID.randomUUID().toString()))
				.state(ChatState.create(UUID.randomUUID().toString()))
				.files(ChatFiles.create(fileName))
				.build();

		command.setCreatedBy(ChatCreatedBy.create(user.getId()));
		command.setTenant(ChatTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
