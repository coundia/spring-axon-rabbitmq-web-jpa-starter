package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyCreatedAt;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyExpiration;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyKey;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyUsername;
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
		ApiKey entity = new ApiKey();
		entity.setId(UUID.randomUUID().toString());
		entity.setKey(UUID.randomUUID().toString());
		entity.setUsername(UUID.randomUUID().toString());
		entity.setCreatedAt(java.time.Instant.now().plusSeconds(3600));
		entity.setExpiration(java.time.Instant.now().plusSeconds(3600));
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

	public static List<CreateApiKeyCommand> randomManyViaCommand(CommandGateway commandGateway, int count) {
		List<CreateApiKeyCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway));
		}
		return items;
	}

	public static void deleteAll(ApiKeyRepository repository) {
		repository.deleteAll();
	}

	public static CreateApiKeyCommand randomOneViaCommand(CommandGateway commandGateway) {
		CreateApiKeyCommand command = new CreateApiKeyCommand(
				ApiKeyKey.create(
						UUID.randomUUID().toString()), ApiKeyUsername.create(
				UUID.randomUUID().toString()), ApiKeyCreatedAt.create(
				java.time.Instant.now().plusSeconds(3600)), ApiKeyExpiration.create(
				java.time.Instant.now().plusSeconds(3600)));
		commandGateway.sendAndWait(command);

		return command;
	}

}
