package com.groupe2cs.bizyhub.sales.infrastructure.entity;

import com.groupe2cs.bizyhub.sales.application.command.CreateSaleCommand;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class SaleFixtures {

	public static Sale randomOne(SaleRepository repository) {
		Sale entity = Sale.builder()
				.id(UUID.randomUUID().toString())
				.name(UUID.randomUUID().toString())
				.amount(1003.17)
				.details(UUID.randomUUID().toString())
				.isActive(false)
				.updatedAt(java.time.Instant.now().plusSeconds(3600))
				.reference(UUID.randomUUID().toString())
				.build();
		return repository.save(entity);
	}

	public static Sale existingOrRandom(SaleRepository repository) {
		return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
	}

	public static Sale byId(SaleRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Sale byIdWaitExist(SaleRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
		return repository.findById(id).orElse(null);
	}

	public static Sale byIdWaitNotExist(SaleRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
		return repository.findById(id).orElse(null);
	}

	public static List<Sale> randomMany(SaleRepository repository, int count) {
		List<Sale> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOne(repository));
		}
		return items;
	}

	public static List<CreateSaleCommand> randomManyViaCommand(CommandGateway commandGateway, int count, User user) {
		List<CreateSaleCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway, user));
		}
		return items;
	}

	public static void deleteAll(SaleRepository repository) {
		repository.deleteAll();
	}

	public static CreateSaleCommand randomOneViaCommand(CommandGateway commandGateway, User user) {


		CreateSaleCommand command = CreateSaleCommand.builder()
				.name(SaleName.create(UUID.randomUUID().toString()))
				.amount(SaleAmount.create(1003.17))
				.details(SaleDetails.create(UUID.randomUUID().toString()))
				.isActive(SaleIsActive.create(false))
				.product(SaleProduct.create(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(
						commandGateway,
						user).getId().value()))
				.updatedAt(SaleUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(SaleReference.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(SaleCreatedBy.create(user.getId()));
		command.setTenant(SaleTenant.create(user.getTenant().getId()));

		commandGateway.sendAndWait(command);
		return command;
	}
}
