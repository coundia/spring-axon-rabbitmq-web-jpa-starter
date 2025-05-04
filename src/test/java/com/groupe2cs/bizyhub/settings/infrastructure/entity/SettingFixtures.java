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

public class SettingFixtures {

public static Setting randomOne(SettingRepository repository) {
Setting entity = Setting.builder()
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

public static Setting existingOrRandom(SettingRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static Setting byId(SettingRepository repository, String id) {
return repository.findById(id).orElse(null);
}

public static Setting byIdWaitExist(SettingRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
return repository.findById(id).orElse(null);
}

public static Setting byIdWaitNotExist(SettingRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
return repository.findById(id).orElse(null);
}

public static List<Setting> randomMany(SettingRepository repository, int count) {
List<Setting> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static List<CreateSettingCommand> randomManyViaCommand(CommandGateway commandGateway, int count,CustomUser user) {
	List<CreateSettingCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,user));
		}
		return items;
		}

		public static void deleteAll(SettingRepository repository) {
		repository.deleteAll();
		}

		public static CreateSettingCommand randomOneViaCommand(CommandGateway commandGateway, CustomUser user) {



			CreateSettingCommand command = CreateSettingCommand.builder()
				.name(SettingName.create(UUID.randomUUID().toString()))
				.reference(SettingReference.create(UUID.randomUUID().toString()))
				.updatedAt(SettingUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.stringValue(SettingStringValue.create(UUID.randomUUID().toString()))
				.descriptions(SettingDescriptions.create(UUID.randomUUID().toString()))
				.isActive(SettingIsActive.create(true))
			.build();

			command.setCreatedBy(SettingCreatedBy.create(user.getId()));
			command.setTenant(SettingTenant.create(user.getTenant().getId()));

			commandGateway.sendAndWait(command);
		return command;
	}
}
