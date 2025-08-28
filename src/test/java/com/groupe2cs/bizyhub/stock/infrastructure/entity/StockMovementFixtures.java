package com.groupe2cs.bizyhub.stock.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.stock.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class StockMovementFixtures {

	public static StockMovement byId(StockMovementRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static StockMovement byIdWaitExist(StockMovementRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static StockMovement byIdWaitNotExist(StockMovementRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateStockMovementCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		StockMovementRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateStockMovementCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateStockMovementCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(StockMovementRepository repository) {
		repository.deleteAll();
	}

		public static CreateStockMovementCommand randomOneViaCommand(
		CommandGateway commandGateway,
		StockMovementRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateStockMovementCommand command = CreateStockMovementCommand.builder()
				.typeStockMovement(StockMovementTypeStockMovement.create(UUID.randomUUID().toString()))
				.quantity(StockMovementQuantity.create(99))
				.remoteId(StockMovementRemoteId.create(UUID.randomUUID().toString()))
				.localId(StockMovementLocalId.create(UUID.randomUUID().toString()))
				.account(StockMovementAccount.create(UUID.randomUUID().toString()))
				.company(StockMovementCompany.create(UUID.randomUUID().toString()))
				.syncAt(StockMovementSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.productVariant(StockMovementProductVariant.create(UUID.randomUUID().toString()))
				.orderLineId(StockMovementOrderLineId.create(UUID.randomUUID().toString()))
				.discriminator(StockMovementDiscriminator.create(UUID.randomUUID().toString()))
			.build();

		command.setCreatedBy(StockMovementCreatedBy.create(user.getId()));
		command.setTenant(StockMovementTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateStockMovementCommand randomOneViaCommand(
        CommandGateway commandGateway,
        StockMovementRepository  repository,
        User user
        ) {

        CreateStockMovementCommand command = CreateStockMovementCommand.builder()
        .typeStockMovement(StockMovementTypeStockMovement.create(UUID.randomUUID().toString()))
        .quantity(StockMovementQuantity.create(99))
        .remoteId(StockMovementRemoteId.create(UUID.randomUUID().toString()))
        .localId(StockMovementLocalId.create(UUID.randomUUID().toString()))
        .account(StockMovementAccount.create(UUID.randomUUID().toString()))
        .company(StockMovementCompany.create(UUID.randomUUID().toString()))
        .syncAt(StockMovementSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .productVariant(StockMovementProductVariant.create(UUID.randomUUID().toString()))
        .orderLineId(StockMovementOrderLineId.create(UUID.randomUUID().toString()))
        .discriminator(StockMovementDiscriminator.create(UUID.randomUUID().toString()))
        .build();

		command.setCreatedBy(StockMovementCreatedBy.create(user.getId()));
		command.setTenant(StockMovementTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
