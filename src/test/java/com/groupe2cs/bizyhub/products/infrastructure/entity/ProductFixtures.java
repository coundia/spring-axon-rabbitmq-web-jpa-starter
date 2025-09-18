package com.groupe2cs.bizyhub.products.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.products.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class ProductFixtures {

	public static Product byId(ProductRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Product byIdWaitExist(ProductRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Product byIdWaitNotExist(ProductRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateProductCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		ProductRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateProductCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateProductCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
        createdByDataRepository,
        tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(ProductRepository repository) {
		repository.deleteAll();
	}

		public static CreateProductCommand randomOneViaCommand(
		CommandGateway commandGateway,
		ProductRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateProductCommand command = CreateProductCommand.builder()
				.remoteId(ProductRemoteId.create(UUID.randomUUID().toString()))
				.localId(ProductLocalId.create(UUID.randomUUID().toString()))
				.code(ProductCode.create(UUID.randomUUID().toString()))
				.name(ProductName.create(UUID.randomUUID().toString()))
				.description(ProductDescription.create(UUID.randomUUID().toString()))
				.status(ProductStatus.create(UUID.randomUUID().toString()))
				.isPublic(ProductIsPublic.create(true))
				.hasSold(ProductHasSold.create(true))
				.hasPrice(ProductHasPrice.create(true))
				.level(ProductLevel.create(UUID.randomUUID().toString()))
				.quantity(ProductQuantity.create(22))
				.barcode(ProductBarcode.create(UUID.randomUUID().toString()))
				.company(ProductCompany.create(UUID.randomUUID().toString()))
				.unit(ProductUnit.create(UUID.randomUUID().toString()))
				.syncAt(ProductSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.category(ProductCategory.create(UUID.randomUUID().toString()))
				.account(ProductAccount.create(UUID.randomUUID().toString()))
				.defaultPrice(ProductDefaultPrice.create(1131.62))
				.statuses(ProductStatuses.create(UUID.randomUUID().toString()))
				.purchasePrice(ProductPurchasePrice.create(6239.63))
			.build();

		command.setCreatedBy(ProductCreatedBy.create(user.getId()));
		command.setTenant(ProductTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateProductCommand randomOneViaCommand(
        CommandGateway commandGateway,
        ProductRepository  repository,
        User user
        ) {

        CreateProductCommand command = CreateProductCommand.builder()
        .remoteId(ProductRemoteId.create(UUID.randomUUID().toString()))
        .localId(ProductLocalId.create(UUID.randomUUID().toString()))
        .code(ProductCode.create(UUID.randomUUID().toString()))
        .name(ProductName.create(UUID.randomUUID().toString()))
        .description(ProductDescription.create(UUID.randomUUID().toString()))
        .status(ProductStatus.create(UUID.randomUUID().toString()))
        .isPublic(ProductIsPublic.create(true))
        .hasSold(ProductHasSold.create(true))
        .hasPrice(ProductHasPrice.create(true))
        .level(ProductLevel.create(UUID.randomUUID().toString()))
        .quantity(ProductQuantity.create(22))
        .barcode(ProductBarcode.create(UUID.randomUUID().toString()))
        .company(ProductCompany.create(UUID.randomUUID().toString()))
        .unit(ProductUnit.create(UUID.randomUUID().toString()))
        .syncAt(ProductSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .category(ProductCategory.create(UUID.randomUUID().toString()))
        .account(ProductAccount.create(UUID.randomUUID().toString()))
        .defaultPrice(ProductDefaultPrice.create(1131.62))
        .statuses(ProductStatuses.create(UUID.randomUUID().toString()))
        .purchasePrice(ProductPurchasePrice.create(6239.63))
        .build();

		command.setCreatedBy(ProductCreatedBy.create(user.getId()));
		command.setTenant(ProductTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
