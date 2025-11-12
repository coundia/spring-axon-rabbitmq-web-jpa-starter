package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.application.command.CreateRoleCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleName;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleTenant;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class RoleFixtures {

	public static Role byId(RoleRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Role byIdWaitExist(RoleRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Role byIdWaitNotExist(RoleRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateRoleCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			RoleRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateRoleCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateRoleCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(RoleRepository repository) {
		repository.deleteAll();
	}

	public static CreateRoleCommand randomOneViaCommand(
			CommandGateway commandGateway,
			RoleRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateRoleCommand command = CreateRoleCommand.builder()
				.name(RoleName.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(RoleCreatedBy.create(user.getId()));
		command.setTenant(RoleTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateRoleCommand randomOneViaCommand(
			CommandGateway commandGateway,
			RoleRepository repository,
			User user
	) {

		CreateRoleCommand command = CreateRoleCommand.builder()
				.name(RoleName.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(RoleCreatedBy.create(user.getId()));
		command.setTenant(RoleTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
