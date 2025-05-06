package com.groupe2cs.bizyhub.sales.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.sales.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import java.util.concurrent.TimeUnit;
import static org.awaitility.Awaitility.await;

public class SaleUserFixtures {

public static SaleUser randomOne(SaleUserRepository repository) {
SaleUser entity = SaleUser.builder()
.id(UUID.randomUUID().toString())
			.details(UUID.randomUUID().toString())
			.isActive(false)
			.updatedAt(java.time.Instant.now().plusSeconds(3600))
			.reference(UUID.randomUUID().toString())
.build();
return repository.save(entity);
}

public static SaleUser existingOrRandom(SaleUserRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static SaleUser byId(SaleUserRepository repository, String id) {
return repository.findById(id).orElse(null);
}

public static SaleUser byIdWaitExist(SaleUserRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
return repository.findById(id).orElse(null);
}

public static SaleUser byIdWaitNotExist(SaleUserRepository repository, String id) {
await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
return repository.findById(id).orElse(null);
}

public static List<SaleUser> randomMany(SaleUserRepository repository, int count) {
List<SaleUser> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static List<CreateSaleUserCommand> randomManyViaCommand(CommandGateway commandGateway, int count,User user) {
	List<CreateSaleUserCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,user));
		}
		return items;
		}

		public static void deleteAll(SaleUserRepository repository) {
		repository.deleteAll();
		}

		public static CreateSaleUserCommand randomOneViaCommand(CommandGateway commandGateway, User user) {



			CreateSaleUserCommand command = CreateSaleUserCommand.builder()
				.sales(SaleUserSales.create(com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleFixtures.randomOneViaCommand(commandGateway, user).getId().value()))
				.users(SaleUserUsers.create(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(commandGateway, user).getId().value()))
				.details(SaleUserDetails.create(UUID.randomUUID().toString()))
				.isActive(SaleUserIsActive.create(false))
				.updatedAt(SaleUserUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(SaleUserReference.create(UUID.randomUUID().toString()))
			.build();

			command.setCreatedBy(SaleUserCreatedBy.create(user.getId()));
			command.setTenant(SaleUserTenant.create(user.getTenant().getId()));

			commandGateway.sendAndWait(command);
		return command;
	}
}
