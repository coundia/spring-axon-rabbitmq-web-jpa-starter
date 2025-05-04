package com.groupe2cs.bizyhub.settings.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.*;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.settings.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import java.util.concurrent.TimeUnit;
import static org.awaitility.Awaitility.await;

public class SettingsFixtures {

public static Settings randomOne(SettingsRepository repository) {
Settings entity = Settings.builder()
.id(UUID.randomUUID().toString())
			.name(UUID.randomUUID().toString())
			.reference(UUID.randomUUID().toString())
			.updatedAt(java.time.Instant.now().plusSeconds(3600))
			.stringValue(UUID.randomUUID().toString())
			.descriptions(UUID.randomUUID().toString())
			.isActive(true)
.build();
return repository.save(entity);
}

public static Settings existingOrRandom(SettingsRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static Settings byId(SettingsRepository repository, String id) {
return repository.findById(id).orElse(null);
}

public static Settings byIdWaitExist(SettingsRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
return repository.findById(id).orElse(null);
}

public static Settings byIdWaitNotExist(SettingsRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
return repository.findById(id).orElse(null);
}

public static List<Settings> randomMany(SettingsRepository repository, int count) {
List<Settings> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static List<CreateSettingsCommand> randomManyViaCommand(CommandGateway commandGateway, int count,CustomUser user) {
	List<CreateSettingsCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,user));
		}
		return items;
		}

		public static void deleteAll(SettingsRepository repository) {
		repository.deleteAll();
		}

		public static CreateSettingsCommand randomOneViaCommand(CommandGateway commandGateway, CustomUser user) {



			CreateSettingsCommand command = CreateSettingsCommand.builder()
				.name(SettingsName.create(UUID.randomUUID().toString()))
				.reference(SettingsReference.create(UUID.randomUUID().toString()))
				.updatedAt(SettingsUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.stringValue(SettingsStringValue.create(UUID.randomUUID().toString()))
				.descriptions(SettingsDescriptions.create(UUID.randomUUID().toString()))
				.isActive(SettingsIsActive.create(true))
			.build();

			command.setCreatedBy(SettingsCreatedBy.create(user.getId()));
			command.setTenant(SettingsTenant.create(user.getTenant().getId()));

			commandGateway.sendAndWait(command);
		return command;
	}
}
