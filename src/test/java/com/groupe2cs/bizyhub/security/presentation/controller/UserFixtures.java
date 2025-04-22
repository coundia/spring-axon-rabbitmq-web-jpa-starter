package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class UserFixtures {

	public static User randomOne(UserRepository repository) {
		User entity = new User();
		entity.setId(UUID.randomUUID().toString());
		entity.setUsername(UUID.randomUUID().toString());
		entity.setPassword(UUID.randomUUID().toString());
		return repository.save(entity);
	}

	public static User existingOrRandom(UserRepository repository) {
		return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
	}

	public static User byId(UserRepository repository, String id) {

		return repository.findById(id).orElse(null);
	}

	public static User byIdWaitExist(UserRepository repository, String id) {

		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);

		return repository.findById(id).orElse(null);
	}

	public static User byIdWaitNotExist(UserRepository repository, String id) {

		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);

		return repository.findById(id).orElse(null);
	}

	public static List<User> randomMany(UserRepository repository, int count) {
		List<User> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOne(repository));
		}
		return items;
	}

	public static List<CreateUserCommand> randomManyViaCommand(CommandGateway commandGateway, int count) {
		List<CreateUserCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway));
		}
		return items;
	}

	public static void deleteAll(UserRepository repository) {
		repository.deleteAll();
	}

	public static CreateUserCommand randomOneViaCommand(CommandGateway commandGateway) {
		CreateUserCommand command = new CreateUserCommand(
				UserUsername.create(
						UUID.randomUUID().toString()), UserPassword.create(
				UUID.randomUUID().toString()));
		commandGateway.sendAndWait(command);

		return command;
	}

}
