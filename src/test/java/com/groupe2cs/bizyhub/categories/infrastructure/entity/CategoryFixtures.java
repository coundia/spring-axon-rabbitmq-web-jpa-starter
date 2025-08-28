package com.groupe2cs.bizyhub.categories.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.categories.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class CategoryFixtures {

	public static Category byId(CategoryRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Category byIdWaitExist(CategoryRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Category byIdWaitNotExist(CategoryRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateCategoryCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		CategoryRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateCategoryCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateCategoryCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(CategoryRepository repository) {
		repository.deleteAll();
	}

		public static CreateCategoryCommand randomOneViaCommand(
		CommandGateway commandGateway,
		CategoryRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateCategoryCommand command = CreateCategoryCommand.builder()
				.code(CategoryCode.create(UUID.randomUUID().toString()))
				.name(CategoryName.create(UUID.randomUUID().toString()))
				.remoteId(CategoryRemoteId.create(UUID.randomUUID().toString()))
				.localId(CategoryLocalId.create(UUID.randomUUID().toString()))
				.account(CategoryAccount.create(UUID.randomUUID().toString()))
				.description(CategoryDescription.create(UUID.randomUUID().toString()))
				.typeEntry(CategoryTypeEntry.create(UUID.randomUUID().toString()))
				.version(CategoryVersion.create(39))
				.syncAt(CategorySyncAt.create(java.time.Instant.now().plusSeconds(3600)))
			.build();

		command.setCreatedBy(CategoryCreatedBy.create(user.getId()));
		command.setTenant(CategoryTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateCategoryCommand randomOneViaCommand(
        CommandGateway commandGateway,
        CategoryRepository  repository,
        User user
        ) {

        CreateCategoryCommand command = CreateCategoryCommand.builder()
        .code(CategoryCode.create(UUID.randomUUID().toString()))
        .name(CategoryName.create(UUID.randomUUID().toString()))
        .remoteId(CategoryRemoteId.create(UUID.randomUUID().toString()))
        .localId(CategoryLocalId.create(UUID.randomUUID().toString()))
        .account(CategoryAccount.create(UUID.randomUUID().toString()))
        .description(CategoryDescription.create(UUID.randomUUID().toString()))
        .typeEntry(CategoryTypeEntry.create(UUID.randomUUID().toString()))
        .version(CategoryVersion.create(39))
        .syncAt(CategorySyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .build();

		command.setCreatedBy(CategoryCreatedBy.create(user.getId()));
		command.setTenant(CategoryTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
