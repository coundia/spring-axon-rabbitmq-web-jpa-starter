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

public class TransactionEntryFixtures {

	public static TransactionEntry byId(TransactionEntryRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static TransactionEntry byIdWaitExist(TransactionEntryRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static TransactionEntry byIdWaitNotExist(TransactionEntryRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateTransactionEntryCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		TransactionEntryRepository repository,
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
		List<CreateTransactionEntryCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateTransactionEntryCommand command = randomOneViaCommand(
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

	public static void deleteAll(TransactionEntryRepository repository) {
		repository.deleteAll();
	}

		public static CreateTransactionEntryCommand randomOneViaCommand(
		CommandGateway commandGateway,
		TransactionEntryRepository  repository,
        com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository,
        com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository,
        com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository,
        com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository,
        com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository debtDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateTransactionEntryCommand command = CreateTransactionEntryCommand.builder()
				.remoteId(TransactionEntryRemoteId.create(UUID.randomUUID().toString()))
				.localId(TransactionEntryLocalId.create(UUID.randomUUID().toString()))
				.code(TransactionEntryCode.create(UUID.randomUUID().toString()))
				.description(TransactionEntryDescription.create(UUID.randomUUID().toString()))
				.amount(TransactionEntryAmount.create(132.16))
				.typeEntry(TransactionEntryTypeEntry.create(UUID.randomUUID().toString()))
				.dateTransaction(TransactionEntryDateTransaction.create(java.time.Instant.now().plusSeconds(3600)))
				.status(TransactionEntryStatus.create(UUID.randomUUID().toString()))
				.entityName(TransactionEntryEntityName.create(UUID.randomUUID().toString()))
				.entityId(TransactionEntryEntityId.create(UUID.randomUUID().toString()))
				.account(TransactionEntryAccount.create(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(commandGateway,accountDataRepository, user).getId().value()))
				.syncAt(TransactionEntrySyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.category(TransactionEntryCategory.create(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(commandGateway,categoryDataRepository, user).getId().value()))
				.company(TransactionEntryCompany.create(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value()))
				.customer(TransactionEntryCustomer.create(com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures.randomOneViaCommand(commandGateway,customerDataRepository, user).getId().value()))
				.debt(TransactionEntryDebt.create(com.groupe2cs.bizyhub.debts.infrastructure.entity.DebtFixtures.randomOneViaCommand(commandGateway,debtDataRepository, user).getId().value()))
			.build();

		command.setCreatedBy(TransactionEntryCreatedBy.create(user.getId()));
		command.setTenant(TransactionEntryTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateTransactionEntryCommand randomOneViaCommand(
        CommandGateway commandGateway,
        TransactionEntryRepository  repository,
        User user
        ) {

        CreateTransactionEntryCommand command = CreateTransactionEntryCommand.builder()
        .remoteId(TransactionEntryRemoteId.create(UUID.randomUUID().toString()))
        .localId(TransactionEntryLocalId.create(UUID.randomUUID().toString()))
        .code(TransactionEntryCode.create(UUID.randomUUID().toString()))
        .description(TransactionEntryDescription.create(UUID.randomUUID().toString()))
        .amount(TransactionEntryAmount.create(132.16))
        .typeEntry(TransactionEntryTypeEntry.create(UUID.randomUUID().toString()))
        .dateTransaction(TransactionEntryDateTransaction.create(java.time.Instant.now().plusSeconds(3600)))
        .status(TransactionEntryStatus.create(UUID.randomUUID().toString()))
        .entityName(TransactionEntryEntityName.create(UUID.randomUUID().toString()))
        .entityId(TransactionEntryEntityId.create(UUID.randomUUID().toString()))
        .syncAt(TransactionEntrySyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .build();

		command.setCreatedBy(TransactionEntryCreatedBy.create(user.getId()));
		command.setTenant(TransactionEntryTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
