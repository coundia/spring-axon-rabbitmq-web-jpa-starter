package com.groupe2cs.bizyhub.categories.infrastructure.entity;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class CategoryFixtures {

	public static Category randomOne(CategoryRepository repository) {
		Category entity = Category.builder()
				.id(UUID.randomUUID().toString())
				.name(UUID.randomUUID().toString())
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

	public static List<CreateCategoryCommand> randomManyViaCommand(CommandGateway commandGateway, int count, CustomUser user) {
		List<CreateCategoryCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway, user));
		}
		return items;
	}

	public static void deleteAll(CategoryRepository repository) {
		repository.deleteAll();
	}

	public static CreateCategoryCommand randomOneViaCommand(CommandGateway commandGateway, CustomUser user) {


		CreateCategoryCommand command = CreateCategoryCommand.builder()
				.name(CategoryName.create(UUID.randomUUID().toString()))
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
