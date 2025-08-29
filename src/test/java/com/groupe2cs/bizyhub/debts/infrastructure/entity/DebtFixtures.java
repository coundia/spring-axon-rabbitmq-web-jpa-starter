package com.groupe2cs.bizyhub.debts.infrastructure.entity;

import com.groupe2cs.bizyhub.debts.application.command.CreateDebtCommand;
import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
			DebtRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateDebtCommand command = CreateDebtCommand.builder()
				.remoteId(DebtRemoteId.create(UUID.randomUUID().toString()))
				.localId(DebtLocalId.create(UUID.randomUUID().toString()))
				.code(DebtCode.create(UUID.randomUUID().toString()))
				.notes(DebtNotes.create(UUID.randomUUID().toString()))
				.balance(DebtBalance.create(6669.84))
				.balanceDebt(DebtBalanceDebt.create(8058.26))
				.dueDate(DebtDueDate.create(java.time.Instant.now().plusSeconds(3600)))
				.statuses(DebtStatuses.create(UUID.randomUUID().toString()))
				.account(DebtAccount.create(UUID.randomUUID().toString()))
				.syncAt(DebtSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.customer(DebtCustomer.create(UUID.randomUUID().toString()))
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
			DebtRepository repository,
			User user
	) {

		CreateDebtCommand command = CreateDebtCommand.builder()
				.remoteId(DebtRemoteId.create(UUID.randomUUID().toString()))
				.localId(DebtLocalId.create(UUID.randomUUID().toString()))
				.code(DebtCode.create(UUID.randomUUID().toString()))
				.notes(DebtNotes.create(UUID.randomUUID().toString()))
				.balance(DebtBalance.create(6669.84))
				.balanceDebt(DebtBalanceDebt.create(8058.26))
				.dueDate(DebtDueDate.create(java.time.Instant.now().plusSeconds(3600)))
				.statuses(DebtStatuses.create(UUID.randomUUID().toString()))
				.account(DebtAccount.create(UUID.randomUUID().toString()))
				.syncAt(DebtSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.customer(DebtCustomer.create(UUID.randomUUID().toString()))
				.isActive(DebtIsActive.create(false))
				.build();

		command.setCreatedBy(DebtCreatedBy.create(user.getId()));
		command.setTenant(DebtTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
