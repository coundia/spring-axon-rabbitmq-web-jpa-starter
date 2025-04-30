package com.groupe2cs.bizyhub.balances.infrastructure.entity;

import com.groupe2cs.bizyhub.balances.application.command.CreateBalanceCommand;
import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class BalanceFixtures {

	public static Balance randomOne(BalanceRepository repository) {
		Balance entity = Balance.builder()
				.id(UUID.randomUUID().toString())
				.name(UUID.randomUUID().toString())
				.currency(UUID.randomUUID().toString())
				.currentBalance(8704.17)
				.previousBalance(2807.31)
				.lastUpdated(java.time.Instant.now().plusSeconds(3600))
				.isDefault(true)
				.ordre(19)
				.isArchived(false)
				.isAllowDebit(true)
				.isAllowCredit(true)
				.isExcluTotal(false)
				.activateNotification(false)
				.syncedAt(java.time.Instant.now().plusSeconds(3600))
				.build();
		return repository.save(entity);
	}

	public static Balance existingOrRandom(BalanceRepository repository) {
		return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
	}

	public static Balance byId(BalanceRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Balance byIdWaitExist(BalanceRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
		return repository.findById(id).orElse(null);
	}

	public static Balance byIdWaitNotExist(BalanceRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
		return repository.findById(id).orElse(null);
	}

	public static List<Balance> randomMany(BalanceRepository repository, int count) {
		List<Balance> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOne(repository));
		}
		return items;
	}

	public static List<CreateBalanceCommand> randomManyViaCommand(CommandGateway commandGateway, int count, CustomUser user) {
		List<CreateBalanceCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway, user));
		}
		return items;
	}

	public static void deleteAll(BalanceRepository repository) {
		repository.deleteAll();
	}

	public static CreateBalanceCommand randomOneViaCommand(CommandGateway commandGateway, CustomUser user) {


		CreateBalanceCommand command = CreateBalanceCommand.builder()
				.name(BalanceName.create(UUID.randomUUID().toString()))
				.currency(BalanceCurrency.create(UUID.randomUUID().toString()))
				.currentBalance(BalanceCurrentBalance.create(8704.17))
				.previousBalance(BalancePreviousBalance.create(2807.31))
				.lastUpdated(BalanceLastUpdated.create(java.time.Instant.now().plusSeconds(3600)))
				.isDefault(BalanceIsDefault.create(true))
				.ordre(BalanceOrdre.create(19))
				.isArchived(BalanceIsArchived.create(false))
				.isAllowDebit(BalanceIsAllowDebit.create(true))
				.isAllowCredit(BalanceIsAllowCredit.create(true))
				.isExcluTotal(BalanceIsExcluTotal.create(false))
				.activateNotification(BalanceActivateNotification.create(false))
				.syncedAt(BalanceSyncedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.build();

		command.setCreatedBy(BalanceCreatedBy.create(user.getId()));
		command.setTenant(BalanceTenant.create(user.getTenant().getId()));

		commandGateway.sendAndWait(command);
		return command;
	}
}
