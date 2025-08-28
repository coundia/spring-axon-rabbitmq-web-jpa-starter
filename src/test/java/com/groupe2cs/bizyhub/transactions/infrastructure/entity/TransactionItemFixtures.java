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
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateTransactionItemCommand command = CreateTransactionItemCommand.builder()
				.transaction(TransactionItemTransaction.create(UUID.randomUUID().toString()))
				.product(TransactionItemProduct.create(UUID.randomUUID().toString()))
				.label(TransactionItemLabel.create(UUID.randomUUID().toString()))
				.quantity(TransactionItemQuantity.create(81))
				.unit(TransactionItemUnit.create(UUID.randomUUID().toString()))
				.account(TransactionItemAccount.create(UUID.randomUUID().toString()))
				.remoteId(TransactionItemRemoteId.create(UUID.randomUUID().toString()))
				.localId(TransactionItemLocalId.create(UUID.randomUUID().toString()))
				.syncAt(TransactionItemSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.unitPrice(TransactionItemUnitPrice.create(8470.87))
				.total(TransactionItemTotal.create(6735.8))
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
        .transaction(TransactionItemTransaction.create(UUID.randomUUID().toString()))
        .product(TransactionItemProduct.create(UUID.randomUUID().toString()))
        .label(TransactionItemLabel.create(UUID.randomUUID().toString()))
        .quantity(TransactionItemQuantity.create(81))
        .unit(TransactionItemUnit.create(UUID.randomUUID().toString()))
        .account(TransactionItemAccount.create(UUID.randomUUID().toString()))
        .remoteId(TransactionItemRemoteId.create(UUID.randomUUID().toString()))
        .localId(TransactionItemLocalId.create(UUID.randomUUID().toString()))
        .syncAt(TransactionItemSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .unitPrice(TransactionItemUnitPrice.create(8470.87))
        .total(TransactionItemTotal.create(6735.8))
        .notes(TransactionItemNotes.create(UUID.randomUUID().toString()))
        .build();

		command.setCreatedBy(TransactionItemCreatedBy.create(user.getId()));
		command.setTenant(TransactionItemTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
