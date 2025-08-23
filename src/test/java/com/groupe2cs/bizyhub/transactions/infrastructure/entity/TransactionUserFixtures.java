package com.groupe2cs.bizyhub.transactions.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class TransactionUserFixtures {

	public static TransactionUser byId(TransactionUserRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static TransactionUser byIdWaitExist(TransactionUserRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static TransactionUser byIdWaitNotExist(TransactionUserRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateTransactionUserCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		TransactionUserRepository repository,
        com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository transactionDataRepository,
        com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateTransactionUserCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateTransactionUserCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            transactionDataRepository,
            userDataRepository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(TransactionUserRepository repository) {
		repository.deleteAll();
	}

		public static CreateTransactionUserCommand randomOneViaCommand(
		CommandGateway commandGateway,
		TransactionUserRepository  repository,
        com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository transactionDataRepository,
        com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateTransactionUserCommand command = CreateTransactionUserCommand.builder()
				.name(TransactionUserName.create(UUID.randomUUID().toString()))
				.transaction(TransactionUserTransaction.create(com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures.randomOneViaCommand(commandGateway,transactionDataRepository, user).getId().value()))
				.user(TransactionUserUser.create(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(commandGateway,userDataRepository, user).getId().value()))
				.syncAt(TransactionUserSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.username(TransactionUserUsername.create(UUID.randomUUID().toString()))
				.details(TransactionUserDetails.create(UUID.randomUUID().toString()))
				.isActive(TransactionUserIsActive.create(true))
			.build();

		command.setCreatedBy(TransactionUserCreatedBy.create(user.getId()));
		command.setTenant(TransactionUserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateTransactionUserCommand randomOneViaCommand(
        CommandGateway commandGateway,
        TransactionUserRepository  repository,
        User user
        ) {

        CreateTransactionUserCommand command = CreateTransactionUserCommand.builder()
        .name(TransactionUserName.create(UUID.randomUUID().toString()))
        .syncAt(TransactionUserSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .username(TransactionUserUsername.create(UUID.randomUUID().toString()))
        .details(TransactionUserDetails.create(UUID.randomUUID().toString()))
        .isActive(TransactionUserIsActive.create(true))
        .build();

		command.setCreatedBy(TransactionUserCreatedBy.create(user.getId()));
		command.setTenant(TransactionUserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
