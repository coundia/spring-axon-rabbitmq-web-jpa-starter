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

public class UserFixtures {

public static User randomOne(UserRepository repository) {
User entity = User.builder()
.id(UUID.randomUUID().toString())
			.username(UUID.randomUUID().toString())
			.password(UUID.randomUUID().toString())
.build();
return repository.save(entity);
}

public static User existingOrRandom(UserRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static User byId(UserRepository repository, String id) {
return repository.findById(id).orElse(null);
}

public static User byIdWaitExist(UserRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
return repository.findById(id).orElse(null);
}

public static User byIdWaitNotExist(UserRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
return repository.findById(id).orElse(null);
}

public static List<User> randomMany(UserRepository repository, int count) {
List<User> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static List<CreateUserCommand> randomManyViaCommand(CommandGateway commandGateway, int count,String userId) {
	List<CreateUserCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,userId));
		}
		return items;
		}

		public static void deleteAll(UserRepository repository) {
		repository.deleteAll();
		}

		public static CreateUserCommand randomOneViaCommand(CommandGateway commandGateway,String userId) {

		CreateUserCommand command = CreateUserCommand.builder()
			.username(UserUsername.create(UUID.randomUUID().toString()))
			.password(UserPassword.create(UUID.randomUUID().toString()))
		.build();

		command.setCreatedBy(UserCreatedBy.create(userId));

		commandGateway.sendAndWait(command);
		return command;
		}
		}
