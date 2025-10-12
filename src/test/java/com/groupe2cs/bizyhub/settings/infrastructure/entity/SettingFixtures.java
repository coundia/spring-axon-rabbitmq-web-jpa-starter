package com.groupe2cs.bizyhub.settings.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.settings.application.command.CreateSettingCommand;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.SettingRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class SettingFixtures {

	public static Setting byId(SettingRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Setting byIdWaitExist(SettingRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Setting byIdWaitNotExist(SettingRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateSettingCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			SettingRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateSettingCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateSettingCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(SettingRepository repository) {
		repository.deleteAll();
	}

	public static CreateSettingCommand randomOneViaCommand(
			CommandGateway commandGateway,
			SettingRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateSettingCommand command = CreateSettingCommand.builder()
				.name(SettingName.create(UUID.randomUUID().toString()))
				.value(SettingValue.create(UUID.randomUUID().toString()))
				.locale(SettingLocale.create(UUID.randomUUID().toString()))
				.remoteId(SettingRemoteId.create(UUID.randomUUID().toString()))
				.localId(SettingLocalId.create(UUID.randomUUID().toString()))
				.account(SettingAccount.create(UUID.randomUUID().toString()))
				.details(SettingDetails.create(UUID.randomUUID().toString()))
				.syncAt(SettingSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.isActive(SettingIsActive.create(true))
				.build();

		command.setCreatedBy(SettingCreatedBy.create(user.getId()));
		command.setTenant(SettingTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateSettingCommand randomOneViaCommand(
			CommandGateway commandGateway,
			SettingRepository repository,
			User user
	) {

		CreateSettingCommand command = CreateSettingCommand.builder()
				.name(SettingName.create(UUID.randomUUID().toString()))
				.value(SettingValue.create(UUID.randomUUID().toString()))
				.locale(SettingLocale.create(UUID.randomUUID().toString()))
				.remoteId(SettingRemoteId.create(UUID.randomUUID().toString()))
				.localId(SettingLocalId.create(UUID.randomUUID().toString()))
				.account(SettingAccount.create(UUID.randomUUID().toString()))
				.details(SettingDetails.create(UUID.randomUUID().toString()))
				.syncAt(SettingSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.isActive(SettingIsActive.create(true))
				.build();

		command.setCreatedBy(SettingCreatedBy.create(user.getId()));
		command.setTenant(SettingTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
