package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class ApiKeyFixtures {

	public static ApiKey byId(ApiKeyRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static ApiKey byIdWaitExist(ApiKeyRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static ApiKey byIdWaitNotExist(ApiKeyRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateApiKeyCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			ApiKeyRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateApiKeyCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateApiKeyCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(ApiKeyRepository repository) {
		repository.deleteAll();
	}

	public static CreateApiKeyCommand randomOneViaCommand(
			CommandGateway commandGateway,
			ApiKeyRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateApiKeyCommand command = CreateApiKeyCommand.builder()
				.appKey(ApiKeyAppKey.create(UUID.randomUUID().toString()))
				.username(ApiKeyUsername.create(UUID.randomUUID().toString()))
				.active(ApiKeyActive.create(false))
				.createdAt(ApiKeyCreatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.expiration(ApiKeyExpiration.create(java.time.Instant.now().plusSeconds(3600)))
				.build();

		command.setCreatedBy(ApiKeyCreatedBy.create(user.getId()));
		command.setTenant(ApiKeyTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateApiKeyCommand randomOneViaCommand(
			CommandGateway commandGateway,
			ApiKeyRepository repository,
			User user
	) {

		CreateApiKeyCommand command = CreateApiKeyCommand.builder()
				.appKey(ApiKeyAppKey.create(UUID.randomUUID().toString()))
				.username(ApiKeyUsername.create(UUID.randomUUID().toString()))
				.active(ApiKeyActive.create(false))
				.createdAt(ApiKeyCreatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.expiration(ApiKeyExpiration.create(java.time.Instant.now().plusSeconds(3600)))
				.build();

		command.setCreatedBy(ApiKeyCreatedBy.create(user.getId()));
		command.setTenant(ApiKeyTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
