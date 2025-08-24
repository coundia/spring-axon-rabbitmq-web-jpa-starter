package com.groupe2cs.bizyhub.debts.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.debts.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class DebtFixtures {

	public static Debt byId(DebtRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Debt byIdWaitExist(DebtRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Debt byIdWaitNotExist(DebtRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateDebtCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		DebtRepository repository,
        com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateDebtCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateDebtCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            customerDataRepository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(DebtRepository repository) {
		repository.deleteAll();
	}

		public static CreateDebtCommand randomOneViaCommand(
		CommandGateway commandGateway,
		DebtRepository  repository,
        com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateDebtCommand command = CreateDebtCommand.builder()
				.remoteId(DebtRemoteId.create(UUID.randomUUID().toString()))
				.localId(DebtLocalId.create(UUID.randomUUID().toString()))
				.code(DebtCode.create(UUID.randomUUID().toString()))
				.notes(DebtNotes.create(UUID.randomUUID().toString()))
				.balance(DebtBalance.create(6609.19))
				.balanceDebt(DebtBalanceDebt.create(697.78))
				.dueDate(DebtDueDate.create(java.time.Instant.now().plusSeconds(3600)))
				.statuses(DebtStatuses.create(UUID.randomUUID().toString()))
				.syncAt(DebtSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.customer(DebtCustomer.create(com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures.randomOneViaCommand(commandGateway,customerDataRepository, user).getId().value()))
				.isActive(DebtIsActive.create(false))
			.build();

		command.setCreatedBy(DebtCreatedBy.create(user.getId()));
		command.setTenant(DebtTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateDebtCommand randomOneViaCommand(
        CommandGateway commandGateway,
        DebtRepository  repository,
        User user
        ) {

        CreateDebtCommand command = CreateDebtCommand.builder()
        .remoteId(DebtRemoteId.create(UUID.randomUUID().toString()))
        .localId(DebtLocalId.create(UUID.randomUUID().toString()))
        .code(DebtCode.create(UUID.randomUUID().toString()))
        .notes(DebtNotes.create(UUID.randomUUID().toString()))
        .balance(DebtBalance.create(6609.19))
        .balanceDebt(DebtBalanceDebt.create(697.78))
        .dueDate(DebtDueDate.create(java.time.Instant.now().plusSeconds(3600)))
        .statuses(DebtStatuses.create(UUID.randomUUID().toString()))
        .syncAt(DebtSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .isActive(DebtIsActive.create(false))
        .build();

		command.setCreatedBy(DebtCreatedBy.create(user.getId()));
		command.setTenant(DebtTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
