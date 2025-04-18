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

public class TransactionFixtures {

public static Transaction randomOne(TransactionRepository repository) {
Transaction entity = new Transaction();
entity.setId(UUID.randomUUID().toString());
		entity.setReference(UUID.randomUUID().toString());
		entity.setAmount(861.07);
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

public static void deleteAll(TransactionRepository repository) {
repository.deleteAll();
}

public static String randomOneViaCommand(CommandGateway commandGateway) {
CreateTransactionCommand command = new CreateTransactionCommand(
TransactionReference.create(
		UUID.randomUUID().toString()),TransactionAmount.create(
		861.07));
return commandGateway.sendAndWait(command).toString();
}

}
