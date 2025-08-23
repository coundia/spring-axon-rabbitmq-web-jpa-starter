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

public class TransactionItemFixtures {

	public static TransactionItem byId(TransactionItemRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static TransactionItem byIdWaitExist(TransactionItemRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static TransactionItem byIdWaitNotExist(TransactionItemRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateTransactionItemCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		TransactionItemRepository repository,
        com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository transactionDataRepository,
        com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productDataRepository,
        com.groupe2cs.bizyhub.units.infrastructure.repository.UnitRepository unitDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateTransactionItemCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateTransactionItemCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            transactionDataRepository,
            productDataRepository,
            unitDataRepository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(TransactionItemRepository repository) {
		repository.deleteAll();
	}

		public static CreateTransactionItemCommand randomOneViaCommand(
		CommandGateway commandGateway,
		TransactionItemRepository  repository,
        com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository transactionDataRepository,
        com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productDataRepository,
        com.groupe2cs.bizyhub.units.infrastructure.repository.UnitRepository unitDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateTransactionItemCommand command = CreateTransactionItemCommand.builder()
				.transaction(TransactionItemTransaction.create(com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures.randomOneViaCommand(commandGateway,transactionDataRepository, user).getId().value()))
				.product(TransactionItemProduct.create(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(commandGateway,productDataRepository, user).getId().value()))
				.label(TransactionItemLabel.create(UUID.randomUUID().toString()))
				.quantity(TransactionItemQuantity.create(97))
				.unit(TransactionItemUnit.create(com.groupe2cs.bizyhub.units.infrastructure.entity.UnitFixtures.randomOneViaCommand(commandGateway,unitDataRepository, user).getId().value()))
				.syncAt(TransactionItemSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.unitPrice(TransactionItemUnitPrice.create(6263.13))
				.total(TransactionItemTotal.create(1265.12))
				.notes(TransactionItemNotes.create(UUID.randomUUID().toString()))
			.build();

		command.setCreatedBy(TransactionItemCreatedBy.create(user.getId()));
		command.setTenant(TransactionItemTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateTransactionItemCommand randomOneViaCommand(
        CommandGateway commandGateway,
        TransactionItemRepository  repository,
        User user
        ) {

        CreateTransactionItemCommand command = CreateTransactionItemCommand.builder()
        .label(TransactionItemLabel.create(UUID.randomUUID().toString()))
        .quantity(TransactionItemQuantity.create(97))
        .syncAt(TransactionItemSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .unitPrice(TransactionItemUnitPrice.create(6263.13))
        .total(TransactionItemTotal.create(1265.12))
        .notes(TransactionItemNotes.create(UUID.randomUUID().toString()))
        .build();

		command.setCreatedBy(TransactionItemCreatedBy.create(user.getId()));
		command.setTenant(TransactionItemTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
