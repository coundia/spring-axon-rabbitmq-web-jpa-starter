package com.groupe2cs.bizyhub.sales.infrastructure.entity;

import com.groupe2cs.bizyhub.sales.application.command.CreateSaleCommand;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class SaleFixtures {

	public static Sale byId(SaleRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Sale byIdWaitExist(SaleRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Sale byIdWaitNotExist(SaleRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateSaleCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			SaleRepository repository,
			com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productDataRepository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateSaleCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateSaleCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					productDataRepository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(SaleRepository repository) {
		repository.deleteAll();
	}

	public static CreateSaleCommand randomOneViaCommand(
			CommandGateway commandGateway,
			SaleRepository repository,
			com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productDataRepository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateSaleCommand command = CreateSaleCommand.builder()
				.name(SaleName.create(UUID.randomUUID().toString()))
				.amount(SaleAmount.create(1839.94))
				.details(SaleDetails.create(UUID.randomUUID().toString()))
				.isActive(SaleIsActive.create(false))
				.product(SaleProduct.create(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(
						commandGateway,
						productDataRepository,
						user).getId().value()))
				.updatedAt(SaleUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(SaleReference.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(SaleCreatedBy.create(user.getId()));
		command.setTenant(SaleTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateSaleCommand randomOneViaCommand(
			CommandGateway commandGateway,
			SaleRepository repository,
			User user
	) {

		CreateSaleCommand command = CreateSaleCommand.builder()
				.name(SaleName.create(UUID.randomUUID().toString()))
				.amount(SaleAmount.create(1839.94))
				.details(SaleDetails.create(UUID.randomUUID().toString()))
				.isActive(SaleIsActive.create(false))
				.updatedAt(SaleUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(SaleReference.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(SaleCreatedBy.create(user.getId()));
		command.setTenant(SaleTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
