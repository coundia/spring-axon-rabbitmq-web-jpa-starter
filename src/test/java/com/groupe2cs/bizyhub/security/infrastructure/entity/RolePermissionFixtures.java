package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
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
		RolePermissionRepository  repository,
        RoleRepository roleDataRepository,
        PermissionRepository permissionDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateRolePermissionCommand command = CreateRolePermissionCommand.builder()
				.role(RolePermissionRole.create(RoleFixtures.randomOneViaCommand(commandGateway,roleDataRepository, user).getId().value()))
				.permission(RolePermissionPermission.create(PermissionFixtures.randomOneViaCommand(commandGateway,permissionDataRepository, user).getId().value()))
			.build();

		command.setCreatedBy(RolePermissionCreatedBy.create(user.getId()));
		command.setTenant(RolePermissionTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateRolePermissionCommand randomOneViaCommand(
        CommandGateway commandGateway,
        RolePermissionRepository  repository,
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
