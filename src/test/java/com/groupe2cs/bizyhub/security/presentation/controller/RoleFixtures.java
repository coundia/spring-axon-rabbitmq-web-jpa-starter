package com.groupe2cs.bizyhub.security.presentation.controller;

	import com.groupe2cs.bizyhub.shared.*;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
	import com.groupe2cs.bizyhub.tenant.presentation.controller.TenantFixtures;
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

public class RoleFixtures {

public static Role randomOne(RoleRepository repository) {
Role entity = Role.builder()
.id(UUID.randomUUID().toString())
			.name(UUID.randomUUID().toString())
.build();
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

public static List<CreateRoleCommand> randomManyViaCommand(CommandGateway commandGateway, int count,String userId) {
	List<CreateRoleCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,userId));
		}
		return items;
		}

		public static void deleteAll(RoleRepository repository) {
		repository.deleteAll();
		}

		public static CreateRoleCommand randomOneViaCommand(CommandGateway commandGateway,String userId) {

		CreateRoleCommand command = CreateRoleCommand.builder()
			.name(RoleName.create(UUID.randomUUID().toString()))
		.build();

		command.setCreatedBy(RoleCreatedBy.create(userId));

		commandGateway.sendAndWait(command);
		return command;
		}
		}
