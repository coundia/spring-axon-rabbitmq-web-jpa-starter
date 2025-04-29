package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.application.command.CreateTenantCommand;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class TenantFixtures {

	public static Tenant randomOne(TenantRepository repository) {
		Tenant entity = Tenant.builder()
				.id(UUID.randomUUID().toString())
				.name(UUID.randomUUID().toString())
				.description(UUID.randomUUID().toString())
				.domain(UUID.randomUUID().toString())
				.language(UUID.randomUUID().toString())
				.active(false)
				.build();
		return repository.save(entity);
	}

	public static Tenant existingOrRandom(TenantRepository repository) {
		return repository.findAll().stream().findFirst().orElseGet(() -> randomOne(repository));
	}

	public static Tenant byId(TenantRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Tenant byIdWaitExist(TenantRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) != null);
		return repository.findById(id).orElse(null);
	}

	public static Tenant byIdWaitNotExist(TenantRepository repository, String id) {
		await().atMost(5, TimeUnit.SECONDS).until(() -> byId(repository, id) == null);
		return repository.findById(id).orElse(null);
	}

	public static List<Tenant> randomMany(TenantRepository repository, int count) {
		List<Tenant> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOne(repository));
		}
		return items;
	}

	public static List<CreateTenantCommand> randomManyViaCommand(CommandGateway commandGateway, int count, CustomUser user) {
		List<CreateTenantCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			items.add(randomOneViaCommand(commandGateway, user));
		}
		return items;
	}

	public static void deleteAll(TenantRepository repository) {
		repository.deleteAll();
	}

	public static CreateTenantCommand randomOneViaCommand(CommandGateway commandGateway, CustomUser user) {


		CreateTenantCommand command = CreateTenantCommand.builder()
				.name(TenantName.create(UUID.randomUUID().toString()))
				.description(TenantDescription.create(UUID.randomUUID().toString()))
				.domain(TenantDomain.create(UUID.randomUUID().toString()))
				.language(TenantLanguage.create(UUID.randomUUID().toString()))
				.active(TenantActive.create(false))
				.build();

		command.setCreatedBy(TenantCreatedBy.create(user.getId()));
		command.setTenant(TenantTenant.create(user.getTenant().getId()));

		commandGateway.sendAndWait(command);
		return command;
	}
}
