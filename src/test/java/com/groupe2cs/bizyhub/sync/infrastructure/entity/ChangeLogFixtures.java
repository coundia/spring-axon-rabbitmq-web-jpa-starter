package com.groupe2cs.bizyhub.sync.infrastructure.entity;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.sync.application.command.CreateChangeLogCommand;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.ChangeLogRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class ChangeLogFixtures {

	public static ChangeLog byId(ChangeLogRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static ChangeLog byIdWaitExist(ChangeLogRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static ChangeLog byIdWaitNotExist(ChangeLogRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateChangeLogCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			ChangeLogRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateChangeLogCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateChangeLogCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(ChangeLogRepository repository) {
		repository.deleteAll();
	}

	public static CreateChangeLogCommand randomOneViaCommand(
			CommandGateway commandGateway,
			ChangeLogRepository repository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateChangeLogCommand command = CreateChangeLogCommand.builder()
				.entityTable(ChangeLogEntityTable.create(UUID.randomUUID().toString()))
				.account(ChangeLogAccount.create(UUID.randomUUID().toString()))
				.remoteId(ChangeLogRemoteId.create(UUID.randomUUID().toString()))
				.localId(ChangeLogLocalId.create(UUID.randomUUID().toString()))
				.operation(ChangeLogOperation.create(UUID.randomUUID().toString()))
				.payload(ChangeLogPayload.create(UUID.randomUUID().toString()))
				.status(ChangeLogStatus.create(UUID.randomUUID().toString()))
				.syncAt(ChangeLogSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.attempts(ChangeLogAttempts.create(58))
				.error(ChangeLogError.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(ChangeLogCreatedBy.create(user.getId()));
		command.setTenant(ChangeLogTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateChangeLogCommand randomOneViaCommand(
			CommandGateway commandGateway,
			ChangeLogRepository repository,
			User user
	) {

		CreateChangeLogCommand command = CreateChangeLogCommand.builder()
				.entityTable(ChangeLogEntityTable.create(UUID.randomUUID().toString()))
				.account(ChangeLogAccount.create(UUID.randomUUID().toString()))
				.remoteId(ChangeLogRemoteId.create(UUID.randomUUID().toString()))
				.localId(ChangeLogLocalId.create(UUID.randomUUID().toString()))
				.operation(ChangeLogOperation.create(UUID.randomUUID().toString()))
				.payload(ChangeLogPayload.create(UUID.randomUUID().toString()))
				.status(ChangeLogStatus.create(UUID.randomUUID().toString()))
				.syncAt(ChangeLogSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.attempts(ChangeLogAttempts.create(58))
				.error(ChangeLogError.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(ChangeLogCreatedBy.create(user.getId()));
		command.setTenant(ChangeLogTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
