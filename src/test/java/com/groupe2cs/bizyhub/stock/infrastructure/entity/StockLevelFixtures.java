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

public class StockLevelFixtures {

	public static StockLevel byId(StockLevelRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static StockLevel byIdWaitExist(StockLevelRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static StockLevel byIdWaitNotExist(StockLevelRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateStockLevelCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		StockLevelRepository repository,
        com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productVariantDataRepository,
        com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateStockLevelCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateStockLevelCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            productVariantDataRepository,
            companyDataRepository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(StockLevelRepository repository) {
		repository.deleteAll();
	}

		public static CreateStockLevelCommand randomOneViaCommand(
		CommandGateway commandGateway,
		StockLevelRepository  repository,
        com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productVariantDataRepository,
        com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateStockLevelCommand command = CreateStockLevelCommand.builder()
				.remoteId(StockLevelRemoteId.create(UUID.randomUUID().toString()))
				.localId(StockLevelLocalId.create(UUID.randomUUID().toString()))
				.stockOnHand(StockLevelStockOnHand.create(1))
				.stockAllocated(StockLevelStockAllocated.create(60))
				.productVariant(StockLevelProductVariant.create(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(commandGateway,productVariantDataRepository, user).getId().value()))
				.syncAt(StockLevelSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.company(StockLevelCompany.create(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value()))
			.build();

		command.setCreatedBy(StockLevelCreatedBy.create(user.getId()));
		command.setTenant(StockLevelTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateStockLevelCommand randomOneViaCommand(
        CommandGateway commandGateway,
        StockLevelRepository  repository,
        User user
        ) {

        CreateStockLevelCommand command = CreateStockLevelCommand.builder()
        .remoteId(StockLevelRemoteId.create(UUID.randomUUID().toString()))
        .localId(StockLevelLocalId.create(UUID.randomUUID().toString()))
        .stockOnHand(StockLevelStockOnHand.create(1))
        .stockAllocated(StockLevelStockAllocated.create(60))
        .syncAt(StockLevelSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .build();

		command.setCreatedBy(StockLevelCreatedBy.create(user.getId()));
		command.setTenant(StockLevelTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
