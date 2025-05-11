package com.groupe2cs.bizyhub.balances.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.balances.application.dto.*;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.*;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.balances.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class BalanceFixtures {

	public static Balance byId(BalanceRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Balance byIdWaitExist(BalanceRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Balance byIdWaitNotExist(BalanceRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateBalanceCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		BalanceRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateBalanceCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateBalanceCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(BalanceRepository repository) {
		repository.deleteAll();
	}

		public static CreateBalanceCommand randomOneViaCommand(
		CommandGateway commandGateway,
		BalanceRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateBalanceCommand command = CreateBalanceCommand.builder()
				.name(BalanceName.create(UUID.randomUUID().toString()))
				.currency(BalanceCurrency.create(UUID.randomUUID().toString()))
				.currentBalance(BalanceCurrentBalance.create(9114.71))
				.previousBalance(BalancePreviousBalance.create(2152.67))
				.lastUpdated(BalanceLastUpdated.create(java.time.Instant.now().plusSeconds(3600)))
				.isDefault(BalanceIsDefault.create(true))
				.ordre(BalanceOrdre.create(18))
				.isArchived(BalanceIsArchived.create(false))
				.isAllowDebit(BalanceIsAllowDebit.create(true))
				.isAllowCredit(BalanceIsAllowCredit.create(true))
				.isExcluTotal(BalanceIsExcluTotal.create(false))
				.activateNotification(BalanceActivateNotification.create(false))
				.syncedAt(BalanceSyncedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.updatedAt(BalanceUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(BalanceReference.create(UUID.randomUUID().toString()))
			.build();

		command.setCreatedBy(BalanceCreatedBy.create(user.getId()));
		command.setTenant(BalanceTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateBalanceCommand randomOneViaCommand(
        CommandGateway commandGateway,
        BalanceRepository  repository,
        User user
        ) {

        CreateBalanceCommand command = CreateBalanceCommand.builder()
        .name(BalanceName.create(UUID.randomUUID().toString()))
        .currency(BalanceCurrency.create(UUID.randomUUID().toString()))
        .currentBalance(BalanceCurrentBalance.create(9114.71))
        .previousBalance(BalancePreviousBalance.create(2152.67))
        .lastUpdated(BalanceLastUpdated.create(java.time.Instant.now().plusSeconds(3600)))
        .isDefault(BalanceIsDefault.create(true))
        .ordre(BalanceOrdre.create(18))
        .isArchived(BalanceIsArchived.create(false))
        .isAllowDebit(BalanceIsAllowDebit.create(true))
        .isAllowCredit(BalanceIsAllowCredit.create(true))
        .isExcluTotal(BalanceIsExcluTotal.create(false))
        .activateNotification(BalanceActivateNotification.create(false))
        .syncedAt(BalanceSyncedAt.create(java.time.Instant.now().plusSeconds(3600)))
        .updatedAt(BalanceUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
        .reference(BalanceReference.create(UUID.randomUUID().toString()))
        .build();

		command.setCreatedBy(BalanceCreatedBy.create(user.getId()));
		command.setTenant(BalanceTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
