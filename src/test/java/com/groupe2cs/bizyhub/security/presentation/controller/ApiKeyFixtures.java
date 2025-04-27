package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKey;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class ApiKeyFixtures {

	public static ApiKey randomOne(ApiKeyRepository repository) {
		ApiKey entity = ApiKey.builder()
				.id(UUID.randomUUID().toString())
				.appKey(UUID.randomUUID().toString())
				.username(UUID.randomUUID().toString())
				.active(true)
				.createdAt(java.time.Instant.now().plusSeconds(3600))
				.expiration(java.time.Instant.now().plusSeconds(3600))
				.build();
		return repository.save(entity);
	}

	public static ApiKey existingOrRandom(ApiKeyRepository repository) {
		return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
	}

	public static ApiKey byId(ApiKeyRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static ApiKey byIdWaitExist(ApiKeyRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
		return repository.findById(id).orElse(null);
	}

	public static ApiKey byIdWaitNotExist(ApiKeyRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
		return repository.findById(id).orElse(null);
	}

	public static List<ApiKey> randomMany(ApiKeyRepository repository, int count) {
		List<ApiKey> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOne(repository));
		}
		return items;
	}

	public static List<CreateApiKeyCommand> randomManyViaCommand(CommandGateway commandGateway, int count, String userId) {
		List<CreateApiKeyCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway, userId));
		}
		return items;
	}

	public static void deleteAll(ApiKeyRepository repository) {
		repository.deleteAll();
	}

	public static CreateApiKeyCommand randomOneViaCommand(CommandGateway commandGateway, String userId) {

		CreateApiKeyCommand command = CreateApiKeyCommand.builder()
				.appKey(ApiKeyAppKey.create(UUID.randomUUID().toString()))
				.username(ApiKeyUsername.create(UUID.randomUUID().toString()))
				.active(ApiKeyActive.create(true))
				.createdAt(ApiKeyCreatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.expiration(ApiKeyExpiration.create(java.time.Instant.now().plusSeconds(3600)))
				.build();

		command.setCreatedBy(ApiKeyCreatedBy.create(userId));

		commandGateway.sendAndWait(command);
		return command;
	}
}
