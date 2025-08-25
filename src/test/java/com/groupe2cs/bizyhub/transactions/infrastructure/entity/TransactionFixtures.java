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

public class TransactionFixtures {

	public static Transaction byId(TransactionRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Transaction byIdWaitExist(TransactionRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Transaction byIdWaitNotExist(TransactionRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateTransactionCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		TransactionRepository repository,
        com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository,
        com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository,
        com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository,
        com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository,
        com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository debtDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateTransactionCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateTransactionCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            accountDataRepository,
            categoryDataRepository,
            companyDataRepository,
            customerDataRepository,
            debtDataRepository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(TransactionRepository repository) {
		repository.deleteAll();
	}

		public static CreateTransactionCommand randomOneViaCommand(
		CommandGateway commandGateway,
		TransactionRepository  repository,
        com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository,
        com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository,
        com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository,
        com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository,
        com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository debtDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateTransactionCommand command = CreateTransactionCommand.builder()
				.remoteId(TransactionRemoteId.create(UUID.randomUUID().toString()))
				.localId(TransactionLocalId.create(UUID.randomUUID().toString()))
				.code(TransactionCode.create(UUID.randomUUID().toString()))
				.description(TransactionDescription.create(UUID.randomUUID().toString()))
				.amount(TransactionAmount.create(9532.25))
				.typeEntry(TransactionTypeEntry.create(UUID.randomUUID().toString()))
				.dateTransaction(TransactionDateTransaction.create(java.time.Instant.now().plusSeconds(3600)))
				.status(TransactionStatus.create(UUID.randomUUID().toString()))
				.entityName(TransactionEntityName.create(UUID.randomUUID().toString()))
				.entityId(TransactionEntityId.create(UUID.randomUUID().toString()))
				.account(TransactionAccount.create(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(commandGateway,accountDataRepository, user).getId().value()))
				.syncAt(TransactionSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.category(TransactionCategory.create(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(commandGateway,categoryDataRepository, user).getId().value()))
				.company(TransactionCompany.create(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value()))
				.customer(TransactionCustomer.create(com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures.randomOneViaCommand(commandGateway,customerDataRepository, user).getId().value()))
				.debt(TransactionDebt.create(com.groupe2cs.bizyhub.debts.infrastructure.entity.DebtFixtures.randomOneViaCommand(commandGateway,debtDataRepository, user).getId().value()))
			.build();

		command.setCreatedBy(TransactionCreatedBy.create(user.getId()));
		command.setTenant(TransactionTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateTransactionCommand randomOneViaCommand(
        CommandGateway commandGateway,
        TransactionRepository  repository,
        User user
        ) {

        CreateTransactionCommand command = CreateTransactionCommand.builder()
        .remoteId(TransactionRemoteId.create(UUID.randomUUID().toString()))
        .localId(TransactionLocalId.create(UUID.randomUUID().toString()))
        .code(TransactionCode.create(UUID.randomUUID().toString()))
        .description(TransactionDescription.create(UUID.randomUUID().toString()))
        .amount(TransactionAmount.create(9532.25))
        .typeEntry(TransactionTypeEntry.create(UUID.randomUUID().toString()))
        .dateTransaction(TransactionDateTransaction.create(java.time.Instant.now().plusSeconds(3600)))
        .status(TransactionStatus.create(UUID.randomUUID().toString()))
        .entityName(TransactionEntityName.create(UUID.randomUUID().toString()))
        .entityId(TransactionEntityId.create(UUID.randomUUID().toString()))
        .syncAt(TransactionSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .build();

		command.setCreatedBy(TransactionCreatedBy.create(user.getId()));
		command.setTenant(TransactionTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
