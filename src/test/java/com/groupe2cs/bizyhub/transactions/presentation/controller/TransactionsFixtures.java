package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import java.util.concurrent.TimeUnit;
import static org.awaitility.Awaitility.await;

public class TransactionsFixtures {

public static Transactions randomOne(TransactionsRepository repository) {
Transactions entity = new Transactions();
entity.setId(UUID.randomUUID().toString());
		entity.setReference(UUID.randomUUID().toString());
		entity.setAmount(5187.97);
return repository.save(entity);
}

public static Transactions existingOrRandom(TransactionsRepository repository) {
return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
}

public static Transactions byId(TransactionsRepository repository, String id) {

	return repository.findById(id).orElse(null);
}

public static Transactions byIdWaitExist(TransactionsRepository repository, String id) {

	await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);

	return repository.findById(id).orElse(null);
}

public static Transactions byIdWaitNotExist(TransactionsRepository repository, String id) {

	await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);

return repository.findById(id).orElse(null);
}

public static List<Transactions> randomMany(TransactionsRepository repository, int count) {
List<Transactions> items = new ArrayList<>();
for (int i = 0; i < count; i++) {
items.add(randomOne(repository));
}
return items;
}

public static void deleteAll(TransactionsRepository repository) {
repository.deleteAll();
}

public static String randomOneViaCommand(CommandGateway commandGateway) {
CreateTransactionsCommand command = new CreateTransactionsCommand(
TransactionsReference.create(
		UUID.randomUUID().toString()),TransactionsAmount.create(
		5187.97));
return commandGateway.sendAndWait(command).toString();
}

}
