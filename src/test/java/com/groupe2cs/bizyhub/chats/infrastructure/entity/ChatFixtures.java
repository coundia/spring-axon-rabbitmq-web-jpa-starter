package com.groupe2cs.bizyhub.chats.infrastructure.entity;

import com.groupe2cs.bizyhub.chats.application.command.CreateChatCommand;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.ChatRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

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
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateChatCommand command = CreateChatCommand.builder()
				.messages(ChatMessages.create(UUID.randomUUID().toString()))
				.responsesJson(ChatResponsesJson.create(UUID.randomUUID().toString()))
				.responses(ChatResponses.create(UUID.randomUUID().toString()))
				.state(ChatState.create(UUID.randomUUID().toString()))
				.syncAt(ChatSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.remoteId(ChatRemoteId.create(UUID.randomUUID().toString()))
				.localId(ChatLocalId.create(UUID.randomUUID().toString()))
				.account(ChatAccount.create(UUID.randomUUID().toString()))
				.dateTransaction(ChatDateTransaction.create(java.time.Instant.now().plusSeconds(3600)))
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

		CreateChatCommand command = CreateChatCommand.builder()
				.messages(ChatMessages.create(UUID.randomUUID().toString()))
				.responsesJson(ChatResponsesJson.create(UUID.randomUUID().toString()))
				.responses(ChatResponses.create(UUID.randomUUID().toString()))
				.state(ChatState.create(UUID.randomUUID().toString()))
				.syncAt(ChatSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.remoteId(ChatRemoteId.create(UUID.randomUUID().toString()))
				.localId(ChatLocalId.create(UUID.randomUUID().toString()))
				.account(ChatAccount.create(UUID.randomUUID().toString()))
				.dateTransaction(ChatDateTransaction.create(java.time.Instant.now().plusSeconds(3600)))
				.build();

		command.setCreatedBy(ChatCreatedBy.create(user.getId()));
		command.setTenant(ChatTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
