package com.groupe2cs.bizyhub.notifications.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.notifications.application.dto.*;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.*;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.notifications.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class NotificationFixtures {

	public static Notification byId(NotificationRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Notification byIdWaitExist(NotificationRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Notification byIdWaitNotExist(NotificationRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateNotificationCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		NotificationRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateNotificationCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateNotificationCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(NotificationRepository repository) {
		repository.deleteAll();
	}

		public static CreateNotificationCommand randomOneViaCommand(
		CommandGateway commandGateway,
		NotificationRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateNotificationCommand command = CreateNotificationCommand.builder()
				.deviceToken(NotificationDeviceToken.create(UUID.randomUUID().toString()))
				.title(NotificationTitle.create(UUID.randomUUID().toString()))
				.message(NotificationMessage.create(UUID.randomUUID().toString()))
				.status(NotificationStatus.create(UUID.randomUUID().toString()))
				.remoteId(NotificationRemoteId.create(UUID.randomUUID().toString()))
				.syncAt(NotificationSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reserved(NotificationReserved.create(UUID.randomUUID().toString()))
				.errorMessage(NotificationErrorMessage.create(UUID.randomUUID().toString()))
			.build();

		command.setCreatedBy(NotificationCreatedBy.create(user.getId()));
		command.setTenant(NotificationTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateNotificationCommand randomOneViaCommand(
        CommandGateway commandGateway,
        NotificationRepository  repository,
        User user
        ) {

        CreateNotificationCommand command = CreateNotificationCommand.builder()
        .deviceToken(NotificationDeviceToken.create(UUID.randomUUID().toString()))
        .title(NotificationTitle.create(UUID.randomUUID().toString()))
        .message(NotificationMessage.create(UUID.randomUUID().toString()))
        .status(NotificationStatus.create(UUID.randomUUID().toString()))
        .remoteId(NotificationRemoteId.create(UUID.randomUUID().toString()))
        .syncAt(NotificationSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .reserved(NotificationReserved.create(UUID.randomUUID().toString()))
        .errorMessage(NotificationErrorMessage.create(UUID.randomUUID().toString()))
        .build();

		command.setCreatedBy(NotificationCreatedBy.create(user.getId()));
		command.setTenant(NotificationTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
