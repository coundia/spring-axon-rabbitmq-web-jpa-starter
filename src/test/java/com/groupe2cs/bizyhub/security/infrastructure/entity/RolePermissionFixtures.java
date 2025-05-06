package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import java.util.concurrent.TimeUnit;
import static org.awaitility.Awaitility.await;

public class RolePermissionFixtures {

public static RolePermission randomOne(RolePermissionRepository repository) {
RolePermission entity = RolePermission.builder()
.id(UUID.randomUUID().toString())
.build();
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

public static List<CreateRolePermissionCommand> randomManyViaCommand(CommandGateway commandGateway, int count,User user) {
	List<CreateRolePermissionCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,user));
		}
		return items;
		}

		public static void deleteAll(RolePermissionRepository repository) {
		repository.deleteAll();
		}

		public static CreateRolePermissionCommand randomOneViaCommand(CommandGateway commandGateway, User user) {



			CreateRolePermissionCommand command = CreateRolePermissionCommand.builder()
				.role(RolePermissionRole.create(RoleFixtures.randomOneViaCommand(commandGateway, user).getId().value()))
				.permission(RolePermissionPermission.create(PermissionFixtures.randomOneViaCommand(commandGateway, user).getId().value()))
			.build();

			command.setCreatedBy(RolePermissionCreatedBy.create(user.getId()));
			command.setTenant(RolePermissionTenant.create(user.getTenant().getId()));

			commandGateway.sendAndWait(command);
		return command;
	}
}
