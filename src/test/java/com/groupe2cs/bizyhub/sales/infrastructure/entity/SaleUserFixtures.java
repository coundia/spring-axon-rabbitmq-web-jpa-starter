package com.groupe2cs.bizyhub.sales.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.sales.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class SaleUserFixtures {

	public static SaleUser byId(SaleUserRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static SaleUser byIdWaitExist(SaleUserRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static SaleUser byIdWaitNotExist(SaleUserRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateSaleUserCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		SaleUserRepository repository,
        com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository salesDataRepository,
        com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository usersDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateSaleUserCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateSaleUserCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            salesDataRepository,
            usersDataRepository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(SaleUserRepository repository) {
		repository.deleteAll();
	}

		public static CreateSaleUserCommand randomOneViaCommand(
		CommandGateway commandGateway,
		SaleUserRepository  repository,
        com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository salesDataRepository,
        com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository usersDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateSaleUserCommand command = CreateSaleUserCommand.builder()
				.sales(SaleUserSales.create(com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleFixtures.randomOneViaCommand(commandGateway,salesDataRepository, user).getId().value()))
				.users(SaleUserUsers.create(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(commandGateway,usersDataRepository, user).getId().value()))
				.username(SaleUserUsername.create(UUID.randomUUID().toString()))
				.email(SaleUserEmail.create(UUID.randomUUID().toString()))
				.details(SaleUserDetails.create(UUID.randomUUID().toString()))
				.isActive(SaleUserIsActive.create(false))
				.updatedAt(SaleUserUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(SaleUserReference.create(UUID.randomUUID().toString()))
			.build();

		command.setCreatedBy(SaleUserCreatedBy.create(user.getId()));
		command.setTenant(SaleUserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateSaleUserCommand randomOneViaCommand(
        CommandGateway commandGateway,
        SaleUserRepository  repository,
        User user
        ) {

        CreateSaleUserCommand command = CreateSaleUserCommand.builder()
        .username(SaleUserUsername.create(UUID.randomUUID().toString()))
        .email(SaleUserEmail.create(UUID.randomUUID().toString()))
        .details(SaleUserDetails.create(UUID.randomUUID().toString()))
        .isActive(SaleUserIsActive.create(false))
        .updatedAt(SaleUserUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
        .reference(SaleUserReference.create(UUID.randomUUID().toString()))
        .build();

		command.setCreatedBy(SaleUserCreatedBy.create(user.getId()));
		command.setTenant(SaleUserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
