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

public class PasswordResetFixtures {

public static PasswordReset randomOne(PasswordResetRepository repository) {
PasswordReset entity = PasswordReset.builder()
.id(UUID.randomUUID().toString())
			.token(UUID.randomUUID().toString())
			.username(UUID.randomUUID().toString())
			.expiration(java.time.Instant.now().plusSeconds(3600))
.build();
return repository.save(entity);
}

public static PasswordReset existingOrRandom(PasswordResetRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static PasswordReset byId(PasswordResetRepository repository, String id) {
return repository.findById(id).orElse(null);
}

public static PasswordReset byIdWaitExist(PasswordResetRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
return repository.findById(id).orElse(null);
}

public static PasswordReset byIdWaitNotExist(PasswordResetRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
return repository.findById(id).orElse(null);
}

public static List<PasswordReset> randomMany(PasswordResetRepository repository, int count) {
List<PasswordReset> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static List<CreatePasswordResetCommand> randomManyViaCommand(CommandGateway commandGateway, int count,String userId) {
	List<CreatePasswordResetCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,userId));
		}
		return items;
		}

		public static void deleteAll(PasswordResetRepository repository) {
		repository.deleteAll();
		}

		public static CreatePasswordResetCommand randomOneViaCommand(CommandGateway commandGateway,String userId) {

		CreatePasswordResetCommand command = CreatePasswordResetCommand.builder()
			.token(PasswordResetToken.create(UUID.randomUUID().toString()))
			.username(PasswordResetUsername.create(UUID.randomUUID().toString()))
			.expiration(PasswordResetExpiration.create(java.time.Instant.now().plusSeconds(3600)))
		.build();

		command.setCreatedBy(PasswordResetCreatedBy.create(userId));

		commandGateway.sendAndWait(command);
		return command;
		}
		}
