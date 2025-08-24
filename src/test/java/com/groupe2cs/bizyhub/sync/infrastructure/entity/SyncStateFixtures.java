package com.groupe2cs.bizyhub.sync.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.sync.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class SyncStateFixtures {

	public static SyncState byId(SyncStateRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static SyncState byIdWaitExist(SyncStateRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static SyncState byIdWaitNotExist(SyncStateRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateSyncStateCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		SyncStateRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateSyncStateCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateSyncStateCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(SyncStateRepository repository) {
		repository.deleteAll();
	}

		public static CreateSyncStateCommand randomOneViaCommand(
		CommandGateway commandGateway,
		SyncStateRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateSyncStateCommand command = CreateSyncStateCommand.builder()
				.entityTable(SyncStateEntityTable.create(UUID.randomUUID().toString()))
				.remoteId(SyncStateRemoteId.create(UUID.randomUUID().toString()))
				.localId(SyncStateLocalId.create(UUID.randomUUID().toString()))
				.syncAt(SyncStateSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.lastSyncAt(SyncStateLastSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.lastCursor(SyncStateLastCursor.create(UUID.randomUUID().toString()))
			.build();

		command.setCreatedBy(SyncStateCreatedBy.create(user.getId()));
		command.setTenant(SyncStateTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateSyncStateCommand randomOneViaCommand(
        CommandGateway commandGateway,
        SyncStateRepository  repository,
        User user
        ) {

        CreateSyncStateCommand command = CreateSyncStateCommand.builder()
        .entityTable(SyncStateEntityTable.create(UUID.randomUUID().toString()))
        .remoteId(SyncStateRemoteId.create(UUID.randomUUID().toString()))
        .localId(SyncStateLocalId.create(UUID.randomUUID().toString()))
        .syncAt(SyncStateSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .lastSyncAt(SyncStateLastSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .lastCursor(SyncStateLastCursor.create(UUID.randomUUID().toString()))
        .build();

		command.setCreatedBy(SyncStateCreatedBy.create(user.getId()));
		command.setTenant(SyncStateTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
