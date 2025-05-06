package com.groupe2cs.bizyhub.products.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.products.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import java.util.concurrent.TimeUnit;
import static org.awaitility.Awaitility.await;

public class ProductFixtures {

public static Product randomOne(ProductRepository repository) {
Product entity = Product.builder()
.id(UUID.randomUUID().toString())
			.name(UUID.randomUUID().toString())
			.price(438.72)
			.details(UUID.randomUUID().toString())
			.isActive(true)
			.updatedAt(java.time.Instant.now().plusSeconds(3600))
			.reference(UUID.randomUUID().toString())
.build();
return repository.save(entity);
}

public static Product existingOrRandom(ProductRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static Product byId(ProductRepository repository, String id) {
return repository.findById(id).orElse(null);
}

public static Product byIdWaitExist(ProductRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
return repository.findById(id).orElse(null);
}

public static Product byIdWaitNotExist(ProductRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
return repository.findById(id).orElse(null);
}

public static List<Product> randomMany(ProductRepository repository, int count) {
List<Product> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static List<CreateProductCommand> randomManyViaCommand(CommandGateway commandGateway, int count,User user) {
	List<CreateProductCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,user));
		}
		return items;
		}

		public static void deleteAll(ProductRepository repository) {
		repository.deleteAll();
		}

		public static CreateProductCommand randomOneViaCommand(CommandGateway commandGateway, User user) {



			CreateProductCommand command = CreateProductCommand.builder()
				.name(ProductName.create(UUID.randomUUID().toString()))
				.price(ProductPrice.create(438.72))
				.details(ProductDetails.create(UUID.randomUUID().toString()))
				.isActive(ProductIsActive.create(true))
				.updatedAt(ProductUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(ProductReference.create(UUID.randomUUID().toString()))
			.build();

			command.setCreatedBy(ProductCreatedBy.create(user.getId()));
			command.setTenant(ProductTenant.create(user.getTenant().getId()));

			commandGateway.sendAndWait(command);
		return command;
	}
}
