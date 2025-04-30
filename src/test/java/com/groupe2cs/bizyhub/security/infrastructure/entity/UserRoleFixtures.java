package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.application.command.CreateUserRoleCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleRole;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleTenant;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleUser;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class UserRoleFixtures {

	public static UserRole randomOne(UserRoleRepository repository) {
		UserRole entity = UserRole.builder()
				.id(UUID.randomUUID().toString())
				.build();
		return repository.save(entity);
	}

	public static UserRole existingOrRandom(UserRoleRepository repository) {
		return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
	}

	public static UserRole byId(UserRoleRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static UserRole byIdWaitExist(UserRoleRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
		return repository.findById(id).orElse(null);
	}

	public static UserRole byIdWaitNotExist(UserRoleRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
		return repository.findById(id).orElse(null);
	}

	public static List<UserRole> randomMany(UserRoleRepository repository, int count) {
		List<UserRole> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOne(repository));
		}
		return items;
	}

	public static List<CreateUserRoleCommand> randomManyViaCommand(CommandGateway commandGateway, int count, CustomUser user) {
		List<CreateUserRoleCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway, user));
		}
		return items;
	}

	public static void deleteAll(UserRoleRepository repository) {
		repository.deleteAll();
	}

	public static CreateUserRoleCommand randomOneViaCommand(CommandGateway commandGateway, CustomUser user) {


		CreateUserRoleCommand command = CreateUserRoleCommand.builder()
				.user(UserRoleUser.create(UserFixtures.randomOneViaCommand(commandGateway, user).getId().value()))
				.role(UserRoleRole.create(RoleFixtures.randomOneViaCommand(commandGateway, user).getId().value()))
				.build();

		command.setCreatedBy(UserRoleCreatedBy.create(user.getId()));
		command.setTenant(UserRoleTenant.create(user.getTenant().getId()));

		commandGateway.sendAndWait(command);
		return command;
	}
}
