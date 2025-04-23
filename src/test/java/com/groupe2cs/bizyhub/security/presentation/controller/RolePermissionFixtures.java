package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionPermission;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionRole;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class RolePermissionFixtures {

	public static RolePermission randomOne(RolePermissionRepository repository) {
		RolePermission entity = new RolePermission();
		entity.setId(UUID.randomUUID().toString());
		return repository.save(entity);
	}

	public static RolePermission existingOrRandom(RolePermissionRepository repository) {
		return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
	}

	public static RolePermission byId(RolePermissionRepository repository, String id) {

		return repository.findById(id).orElse(null);
	}

	public static RolePermission byIdWaitExist(RolePermissionRepository repository, String id) {

		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);

		return repository.findById(id).orElse(null);
	}

	public static RolePermission byIdWaitNotExist(RolePermissionRepository repository, String id) {

		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);

		return repository.findById(id).orElse(null);
	}

	public static List<RolePermission> randomMany(RolePermissionRepository repository, int count) {
		List<RolePermission> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOne(repository));
		}
		return items;
	}

	public static List<CreateRolePermissionCommand> randomManyViaCommand(CommandGateway commandGateway, int count) {
		List<CreateRolePermissionCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway));
		}
		return items;
	}

	public static void deleteAll(RolePermissionRepository repository) {
		repository.deleteAll();
	}

	public static CreateRolePermissionCommand randomOneViaCommand(CommandGateway commandGateway) {
		CreateRolePermissionCommand command = new CreateRolePermissionCommand(
				RolePermissionRole.create(
						RoleFixtures.randomOneViaCommand(commandGateway).getId().value()),
				RolePermissionPermission.create(
						PermissionFixtures.randomOneViaCommand(commandGateway).getId().value()));
		commandGateway.sendAndWait(command);

		return command;
	}

}
