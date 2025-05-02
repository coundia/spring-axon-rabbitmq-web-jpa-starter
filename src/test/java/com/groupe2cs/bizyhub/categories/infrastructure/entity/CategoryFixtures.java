package com.groupe2cs.bizyhub.categories.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.categories.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import java.util.concurrent.TimeUnit;
import static org.awaitility.Awaitility.await;

public class CategoryFixtures {

public static Category randomOne(CategoryRepository repository) {
Category entity = Category.builder()
.id(UUID.randomUUID().toString())
			.reference(UUID.randomUUID().toString())
			.name(UUID.randomUUID().toString())
			.updatedAt(java.time.Instant.now().plusSeconds(3600))
			.typeCategory(UUID.randomUUID().toString())
			.parentId(UUID.randomUUID().toString())
			.isDefault(false)
			.icon(UUID.randomUUID().toString())
			.colorHex(UUID.randomUUID().toString())
.build();
return repository.save(entity);
}

public static Category existingOrRandom(CategoryRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static Category byId(CategoryRepository repository, String id) {
return repository.findById(id).orElse(null);
}

public static Category byIdWaitExist(CategoryRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
return repository.findById(id).orElse(null);
}

public static Category byIdWaitNotExist(CategoryRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
return repository.findById(id).orElse(null);
}

public static List<Category> randomMany(CategoryRepository repository, int count) {
List<Category> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static List<CreateCategoryCommand> randomManyViaCommand(CommandGateway commandGateway, int count,CustomUser user) {
	List<CreateCategoryCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,user));
		}
		return items;
		}

		public static void deleteAll(CategoryRepository repository) {
		repository.deleteAll();
		}

		public static CreateCategoryCommand randomOneViaCommand(CommandGateway commandGateway, CustomUser user) {



			CreateCategoryCommand command = CreateCategoryCommand.builder()
				.reference(CategoryReference.create(UUID.randomUUID().toString()))
				.name(CategoryName.create(UUID.randomUUID().toString()))
				.updatedAt(CategoryUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.typeCategory(CategoryTypeCategory.create(UUID.randomUUID().toString()))
				.parentId(CategoryParentId.create(UUID.randomUUID().toString()))
				.isDefault(CategoryIsDefault.create(false))
				.icon(CategoryIcon.create(UUID.randomUUID().toString()))
				.colorHex(CategoryColorHex.create(UUID.randomUUID().toString()))
			.build();

			command.setCreatedBy(CategoryCreatedBy.create(user.getId()));
			command.setTenant(CategoryTenant.create(user.getTenant().getId()));

			commandGateway.sendAndWait(command);
		return command;
	}
}
