package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionCreatedBy;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class TransactionFixtures {

	public static Transaction randomOne(TransactionRepository repository) {
		Transaction entity = Transaction.builder()
				.id(UUID.randomUUID().toString())
				.reference(UUID.randomUUID().toString())
				.amount(7292.21)
				.build();
		return repository.save(entity);
	}

	public static Transaction existingOrRandom(TransactionRepository repository) {
		return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
	}

	public static Transaction byId(TransactionRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Transaction byIdWaitExist(TransactionRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
		return repository.findById(id).orElse(null);
	}

	public static Transaction byIdWaitNotExist(TransactionRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
		return repository.findById(id).orElse(null);
	}

	public static List<Transaction> randomMany(TransactionRepository repository, int count) {
		List<Transaction> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOne(repository));
		}
		return items;
	}

	public static List<CreateTransactionCommand> randomManyViaCommand(CommandGateway commandGateway, int count, String userId) {
		List<CreateTransactionCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway, userId));
		}
		return items;
	}

	public static void deleteAll(TransactionRepository repository) {
		repository.deleteAll();
	}

	public static CreateTransactionCommand randomOneViaCommand(CommandGateway commandGateway, String userId) {

		CreateTransactionCommand command = CreateTransactionCommand.builder()
				.reference(TransactionReference.create(UUID.randomUUID().toString()))
				.amount(TransactionAmount.create(7292.21))
				.build();

		command.setCreatedBy(TransactionCreatedBy.create(userId));

		commandGateway.sendAndWait(command);
		return command;
	}
}
