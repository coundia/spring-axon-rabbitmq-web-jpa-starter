package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateRoleCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleName;
import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class RoleFixtures {

	public static Role randomOne(RoleRepository repository) {
		Role entity = new Role();
		entity.setId(UUID.randomUUID().toString());
		entity.setName(UUID.randomUUID().toString());
		return repository.save(entity);
	}

	public static Role existingOrRandom(RoleRepository repository) {
		return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
	}

	public static Role byId(RoleRepository repository, String id) {

		return repository.findById(id).orElse(null);
	}

	public static Role byIdWaitExist(RoleRepository repository, String id) {

		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);

		return repository.findById(id).orElse(null);
	}

	public static Role byIdWaitNotExist(RoleRepository repository, String id) {

		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);

		return repository.findById(id).orElse(null);
	}

	public static List<Role> randomMany(RoleRepository repository, int count) {
		List<Role> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOne(repository));
		}
		return items;
	}

	public static List<CreateRoleCommand> randomManyViaCommand(CommandGateway commandGateway, int count) {
		List<CreateRoleCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway));
		}
		return items;
	}

	public static void deleteAll(RoleRepository repository) {
		repository.deleteAll();
	}

	public static CreateRoleCommand randomOneViaCommand(CommandGateway commandGateway) {
		CreateRoleCommand command = new CreateRoleCommand(
				RoleName.create(
						UUID.randomUUID().toString()));
		commandGateway.sendAndWait(command);

		return command;
	}

}
