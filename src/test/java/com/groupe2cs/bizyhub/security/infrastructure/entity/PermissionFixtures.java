package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.application.command.CreatePermissionCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionName;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionTenant;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class PermissionFixtures {

	public static Permission byId(PermissionRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Permission byIdWaitExist(PermissionRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Permission byIdWaitNotExist(PermissionRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreatePermissionCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			PermissionRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreatePermissionCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreatePermissionCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(PermissionRepository repository) {
		repository.deleteAll();
	}

	public static CreatePermissionCommand randomOneViaCommand(
			CommandGateway commandGateway,
			PermissionRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreatePermissionCommand command = CreatePermissionCommand.builder()
				.name(PermissionName.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(PermissionCreatedBy.create(user.getId()));
		command.setTenant(PermissionTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreatePermissionCommand randomOneViaCommand(
			CommandGateway commandGateway,
			PermissionRepository repository,
			User user
	) {

		CreatePermissionCommand command = CreatePermissionCommand.builder()
				.name(PermissionName.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(PermissionCreatedBy.create(user.getId()));
		command.setTenant(PermissionTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
