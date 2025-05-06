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

public class ApiKeyFixtures {

public static ApiKey randomOne(ApiKeyRepository repository) {
ApiKey entity = ApiKey.builder()
.id(UUID.randomUUID().toString())
			.appKey(UUID.randomUUID().toString())
			.username(UUID.randomUUID().toString())
			.active(false)
			.createdAt(java.time.Instant.now().plusSeconds(3600))
			.expiration(java.time.Instant.now().plusSeconds(3600))
.build();
return repository.save(entity);
}

public static ApiKey existingOrRandom(ApiKeyRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static ApiKey byId(ApiKeyRepository repository, String id) {
return repository.findById(id).orElse(null);
}

public static ApiKey byIdWaitExist(ApiKeyRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
return repository.findById(id).orElse(null);
}

public static ApiKey byIdWaitNotExist(ApiKeyRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
return repository.findById(id).orElse(null);
}

public static List<ApiKey> randomMany(ApiKeyRepository repository, int count) {
List<ApiKey> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static List<CreateApiKeyCommand> randomManyViaCommand(CommandGateway commandGateway, int count,User user) {
	List<CreateApiKeyCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,user));
		}
		return items;
		}

		public static void deleteAll(ApiKeyRepository repository) {
		repository.deleteAll();
		}

		public static CreateApiKeyCommand randomOneViaCommand(CommandGateway commandGateway, User user) {



			CreateApiKeyCommand command = CreateApiKeyCommand.builder()
				.appKey(ApiKeyAppKey.create(UUID.randomUUID().toString()))
				.username(ApiKeyUsername.create(UUID.randomUUID().toString()))
				.active(ApiKeyActive.create(false))
				.createdAt(ApiKeyCreatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.expiration(ApiKeyExpiration.create(java.time.Instant.now().plusSeconds(3600)))
			.build();

			command.setCreatedBy(ApiKeyCreatedBy.create(user.getId()));
			command.setTenant(ApiKeyTenant.create(user.getTenant().getId()));

			commandGateway.sendAndWait(command);
		return command;
	}
}
