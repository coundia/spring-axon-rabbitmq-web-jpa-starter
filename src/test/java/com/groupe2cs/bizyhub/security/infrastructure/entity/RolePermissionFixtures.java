package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.security.application.command.CreateRolePermissionCommand;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionPermission;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionRole;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionTenant;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class RolePermissionFixtures {

	public static RolePermission byId(RolePermissionRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static RolePermission byIdWaitExist(RolePermissionRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static RolePermission byIdWaitNotExist(RolePermissionRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateRolePermissionCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			RolePermissionRepository repository,
			RoleRepository roleDataRepository,
			PermissionRepository permissionDataRepository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateRolePermissionCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateRolePermissionCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					roleDataRepository,
					permissionDataRepository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(RolePermissionRepository repository) {
		repository.deleteAll();
	}

	public static CreateRolePermissionCommand randomOneViaCommand(
			CommandGateway commandGateway,
			RolePermissionRepository repository,
			RoleRepository roleDataRepository,
			PermissionRepository permissionDataRepository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateRolePermissionCommand command = CreateRolePermissionCommand.builder()
				.role(RolePermissionRole.create(RoleFixtures.randomOneViaCommand(commandGateway,
						roleDataRepository,
						user).getId().value()))
				.permission(RolePermissionPermission.create(PermissionFixtures.randomOneViaCommand(commandGateway,
						permissionDataRepository,
						user).getId().value()))
				.build();

		command.setCreatedBy(RolePermissionCreatedBy.create(user.getId()));
		command.setTenant(RolePermissionTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateRolePermissionCommand randomOneViaCommand(
			CommandGateway commandGateway,
			RolePermissionRepository repository,
			User user
	) {

		CreateRolePermissionCommand command = CreateRolePermissionCommand.builder()
				.build();

		command.setCreatedBy(RolePermissionCreatedBy.create(user.getId()));
		command.setTenant(RolePermissionTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
