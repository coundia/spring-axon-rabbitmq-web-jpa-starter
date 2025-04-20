package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
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
	User entity = new User();
	entity.setId(UUID.randomUUID().toString());
			entity.setUsername(UUID.randomUUID().toString());
			entity.setPassword(UUID.randomUUID().toString());
			entity.setEmail(UUID.randomUUID().toString());
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

public static void deleteAll(UserRepository repository) {
	repository.deleteAll();
}

public static CreateUserCommand randomOneViaCommand(CommandGateway commandGateway) {
		CreateUserCommand command = new CreateUserCommand(
UserUsername.create(
				UUID.randomUUID().toString()),UserPassword.create(
				UUID.randomUUID().toString()),UserEmail.create(
				UUID.randomUUID().toString())		);
	 commandGateway.sendAndWait(command);

	return command;
}

}
