package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class UserFixtures {

	public static User byId(UserRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static User byIdWaitExist(UserRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static User byIdWaitNotExist(UserRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateUserCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			UserRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateUserCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateUserCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(UserRepository repository) {
		repository.deleteAll();
	}

	public static CreateUserCommand randomOneViaCommand(
			CommandGateway commandGateway,
			UserRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateUserCommand command = CreateUserCommand.builder()
				.username(UserUsername.create(UUID.randomUUID().toString()))
				.password(UserPassword.create(UUID.randomUUID().toString()))
				.firstName(UserFirstName.create(UUID.randomUUID().toString()))
				.lastName(UserLastName.create(UUID.randomUUID().toString()))
				.email(UserEmail.create(UUID.randomUUID().toString()))
				.telephone(UserTelephone.create(UUID.randomUUID().toString()))
				.limitPerDay(UserLimitPerDay.create(45))
				.isPremium(UserIsPremium.create(true))
				.enabled(UserEnabled.create(true))
				.isBan(UserIsBan.create(false))
				.message(UserMessage.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(UserCreatedBy.create(user.getId()));
		command.setTenant(UserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateUserCommand randomOneViaCommand(
			CommandGateway commandGateway,
			UserRepository repository,
			User user
	) {

		CreateUserCommand command = CreateUserCommand.builder()
				.username(UserUsername.create(UUID.randomUUID().toString()))
				.password(UserPassword.create(UUID.randomUUID().toString()))
				.firstName(UserFirstName.create(UUID.randomUUID().toString()))
				.lastName(UserLastName.create(UUID.randomUUID().toString()))
				.email(UserEmail.create(UUID.randomUUID().toString()))
				.telephone(UserTelephone.create(UUID.randomUUID().toString()))
				.limitPerDay(UserLimitPerDay.create(45))
				.isPremium(UserIsPremium.create(true))
				.enabled(UserEnabled.create(true))
				.isBan(UserIsBan.create(false))
				.message(UserMessage.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(UserCreatedBy.create(user.getId()));
		command.setTenant(UserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
