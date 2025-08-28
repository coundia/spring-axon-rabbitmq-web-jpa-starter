package com.groupe2cs.bizyhub.accounts.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class AccountFixtures {

	public static Account byId(AccountRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Account byIdWaitExist(AccountRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Account byIdWaitNotExist(AccountRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateAccountCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		AccountRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateAccountCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateAccountCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(AccountRepository repository) {
		repository.deleteAll();
	}

		public static CreateAccountCommand randomOneViaCommand(
		CommandGateway commandGateway,
		AccountRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateAccountCommand command = CreateAccountCommand.builder()
				.code(AccountCode.create(UUID.randomUUID().toString()))
				.name(AccountName.create(UUID.randomUUID().toString()))
				.status(AccountStatus.create(UUID.randomUUID().toString()))
				.currency(AccountCurrency.create(UUID.randomUUID().toString()))
				.typeAccount(AccountTypeAccount.create(UUID.randomUUID().toString()))
				.balance(AccountBalance.create(3986.25))
				.balancePrev(AccountBalancePrev.create(5617.76))
				.balanceBlocked(AccountBalanceBlocked.create(9792.33))
				.balanceInit(AccountBalanceInit.create(6377.8))
				.balanceGoal(AccountBalanceGoal.create(6810.38))
				.balanceLimit(AccountBalanceLimit.create(8938.9))
				.description(AccountDescription.create(UUID.randomUUID().toString()))
				.isActive(AccountIsActive.create(true))
				.isDefault(AccountIsDefault.create(false))
				.remoteId(AccountRemoteId.create(UUID.randomUUID().toString()))
				.localId(AccountLocalId.create(UUID.randomUUID().toString()))
				.syncAt(AccountSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
			.build();

		command.setCreatedBy(AccountCreatedBy.create(user.getId()));
		command.setTenant(AccountTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateAccountCommand randomOneViaCommand(
        CommandGateway commandGateway,
        AccountRepository  repository,
        User user
        ) {

        CreateAccountCommand command = CreateAccountCommand.builder()
        .code(AccountCode.create(UUID.randomUUID().toString()))
        .name(AccountName.create(UUID.randomUUID().toString()))
        .status(AccountStatus.create(UUID.randomUUID().toString()))
        .currency(AccountCurrency.create(UUID.randomUUID().toString()))
        .typeAccount(AccountTypeAccount.create(UUID.randomUUID().toString()))
        .balance(AccountBalance.create(3986.25))
        .balancePrev(AccountBalancePrev.create(5617.76))
        .balanceBlocked(AccountBalanceBlocked.create(9792.33))
        .balanceInit(AccountBalanceInit.create(6377.8))
        .balanceGoal(AccountBalanceGoal.create(6810.38))
        .balanceLimit(AccountBalanceLimit.create(8938.9))
        .description(AccountDescription.create(UUID.randomUUID().toString()))
        .isActive(AccountIsActive.create(true))
        .isDefault(AccountIsDefault.create(false))
        .remoteId(AccountRemoteId.create(UUID.randomUUID().toString()))
        .localId(AccountLocalId.create(UUID.randomUUID().toString()))
        .syncAt(AccountSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .build();

		command.setCreatedBy(AccountCreatedBy.create(user.getId()));
		command.setTenant(AccountTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
