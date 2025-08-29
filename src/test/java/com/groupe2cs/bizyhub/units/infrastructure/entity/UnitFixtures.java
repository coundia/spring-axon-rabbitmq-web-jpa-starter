package com.groupe2cs.bizyhub.units.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.units.application.command.*;
import com.groupe2cs.bizyhub.units.application.dto.*;
import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import com.groupe2cs.bizyhub.units.infrastructure.repository.*;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class UnitFixtures {

	public static Unit byId(UnitRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Unit byIdWaitExist(UnitRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Unit byIdWaitNotExist(UnitRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateUnitCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			UnitRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateUnitCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateUnitCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(UnitRepository repository) {
		repository.deleteAll();
	}

	public static CreateUnitCommand randomOneViaCommand(
			CommandGateway commandGateway,
			UnitRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateUnitCommand command = CreateUnitCommand.builder()
				.remoteId(UnitRemoteId.create(UUID.randomUUID().toString()))
				.localId(UnitLocalId.create(UUID.randomUUID().toString()))
				.code(UnitCode.create(UUID.randomUUID().toString()))
				.name(UnitName.create(UUID.randomUUID().toString()))
				.syncAt(UnitSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.description(UnitDescription.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(UnitCreatedBy.create(user.getId()));
		command.setTenant(UnitTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateUnitCommand randomOneViaCommand(
			CommandGateway commandGateway,
			UnitRepository repository,
			User user
	) {

		CreateUnitCommand command = CreateUnitCommand.builder()
				.remoteId(UnitRemoteId.create(UUID.randomUUID().toString()))
				.localId(UnitLocalId.create(UUID.randomUUID().toString()))
				.code(UnitCode.create(UUID.randomUUID().toString()))
				.name(UnitName.create(UUID.randomUUID().toString()))
				.syncAt(UnitSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.description(UnitDescription.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(UnitCreatedBy.create(user.getId()));
		command.setTenant(UnitTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
