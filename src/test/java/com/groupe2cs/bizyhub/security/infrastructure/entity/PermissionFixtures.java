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

public class PermissionFixtures {

public static Permission randomOne(PermissionRepository repository) {
Permission entity = Permission.builder()
.id(UUID.randomUUID().toString())
			.name(UUID.randomUUID().toString())
.build();
return repository.save(entity);
}

public static Permission existingOrRandom(PermissionRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static Permission byId(PermissionRepository repository, String id) {
return repository.findById(id).orElse(null);
}

public static Permission byIdWaitExist(PermissionRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
return repository.findById(id).orElse(null);
}

public static Permission byIdWaitNotExist(PermissionRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
return repository.findById(id).orElse(null);
}

public static List<Permission> randomMany(PermissionRepository repository, int count) {
List<Permission> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static List<CreatePermissionCommand> randomManyViaCommand(CommandGateway commandGateway, int count,User user) {
	List<CreatePermissionCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,user));
		}
		return items;
		}

		public static void deleteAll(PermissionRepository repository) {
		repository.deleteAll();
		}

		public static CreatePermissionCommand randomOneViaCommand(CommandGateway commandGateway, User user) {



			CreatePermissionCommand command = CreatePermissionCommand.builder()
				.name(PermissionName.create(UUID.randomUUID().toString()))
			.build();

			command.setCreatedBy(PermissionCreatedBy.create(user.getId()));
			command.setTenant(PermissionTenant.create(user.getTenant().getId()));

			commandGateway.sendAndWait(command);
		return command;
	}
}
