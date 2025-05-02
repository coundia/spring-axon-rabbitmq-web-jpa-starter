package com.groupe2cs.bizyhub.transactions.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
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
Transaction entity = Transaction.builder()
.id(UUID.randomUUID().toString())
			.amount(1482.73)
			.dateOperation(java.time.Instant.now().plusSeconds(3600))
			.description(UUID.randomUUID().toString())
			.reference(UUID.randomUUID().toString())
			.isRecurring(true)
			.isExcluToRapport(true)
			.status(UUID.randomUUID().toString())
			.updatedAt(java.time.Instant.now().plusSeconds(3600))
			.createdAt(java.time.Instant.now().plusSeconds(3600))
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

public static List<CreateTransactionCommand> randomManyViaCommand(CommandGateway commandGateway, int count,CustomUser user) {
	List<CreateTransactionCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
		items.add(randomOneViaCommand(commandGateway,user));
		}
		return items;
		}

		public static void deleteAll(TransactionRepository repository) {
		repository.deleteAll();
		}

		public static CreateTransactionCommand randomOneViaCommand(CommandGateway commandGateway, CustomUser user) {



			CreateTransactionCommand command = CreateTransactionCommand.builder()
				.amount(TransactionAmount.create(1482.73))
				.dateOperation(TransactionDateOperation.create(java.time.Instant.now().plusSeconds(3600)))
				.description(TransactionDescription.create(UUID.randomUUID().toString()))
				.reference(TransactionReference.create(UUID.randomUUID().toString()))
				.isRecurring(TransactionIsRecurring.create(true))
				.isExcluToRapport(TransactionIsExcluToRapport.create(true))
				.status(TransactionStatus.create(UUID.randomUUID().toString()))
				.balance(TransactionBalance.create(com.groupe2cs.bizyhub.balances.infrastructure.entity.BalanceFixtures.randomOneViaCommand(commandGateway, user).getId().value()))
				.category(TransactionCategory.create(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(commandGateway, user).getId().value()))
				.updatedAt(TransactionUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.createdAt(TransactionCreatedAt.create(java.time.Instant.now().plusSeconds(3600)))
			.build();

			command.setCreatedBy(TransactionCreatedBy.create(user.getId()));
			command.setTenant(TransactionTenant.create(user.getTenant().getId()));

			commandGateway.sendAndWait(command);
		return command;
	}
}
