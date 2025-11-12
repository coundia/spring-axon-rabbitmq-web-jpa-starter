package com.groupe2cs.bizyhub.message.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.message.infrastructure.entity.*;
import com.groupe2cs.bizyhub.message.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.message.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class MessageFixtures {

	public static Message byId(MessageRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Message byIdWaitExist(MessageRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Message byIdWaitNotExist(MessageRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateMessageCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		MessageRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateMessageCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateMessageCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
        createdByDataRepository,
        tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(MessageRepository repository) {
		repository.deleteAll();
	}

		public static CreateMessageCommand randomOneViaCommand(
		CommandGateway commandGateway,
		MessageRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateMessageCommand command = CreateMessageCommand.builder()
				.code(MessageCode.create(UUID.randomUUID().toString()))
				.email(MessageEmail.create(UUID.randomUUID().toString()))
				.phone(MessagePhone.create(UUID.randomUUID().toString()))
				.content(MessageContent.create(UUID.randomUUID().toString()))
				.plateforme(MessagePlateforme.create(UUID.randomUUID().toString()))
				.source(MessageSource.create(UUID.randomUUID().toString()))
				.agent(MessageAgent.create(UUID.randomUUID().toString()))
				.status(MessageStatus.create(UUID.randomUUID().toString()))
				.description(MessageDescription.create(UUID.randomUUID().toString()))
				.isActive(MessageIsActive.create(true))
				.isDefault(MessageIsDefault.create(true))
				.remoteId(MessageRemoteId.create(UUID.randomUUID().toString()))
				.localId(MessageLocalId.create(UUID.randomUUID().toString()))
				.depotAt(MessageDepotAt.create(java.time.Instant.now().plusSeconds(3600)))
				.syncAt(MessageSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
			.build();

		command.setCreatedBy(MessageCreatedBy.create(user.getId()));
		command.setTenant(MessageTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateMessageCommand randomOneViaCommand(
        CommandGateway commandGateway,
        MessageRepository  repository,
        User user
        ) {

        CreateMessageCommand command = CreateMessageCommand.builder()
        .code(MessageCode.create(UUID.randomUUID().toString()))
        .email(MessageEmail.create(UUID.randomUUID().toString()))
        .phone(MessagePhone.create(UUID.randomUUID().toString()))
        .content(MessageContent.create(UUID.randomUUID().toString()))
        .plateforme(MessagePlateforme.create(UUID.randomUUID().toString()))
        .source(MessageSource.create(UUID.randomUUID().toString()))
        .agent(MessageAgent.create(UUID.randomUUID().toString()))
        .status(MessageStatus.create(UUID.randomUUID().toString()))
        .description(MessageDescription.create(UUID.randomUUID().toString()))
        .isActive(MessageIsActive.create(true))
        .isDefault(MessageIsDefault.create(true))
        .remoteId(MessageRemoteId.create(UUID.randomUUID().toString()))
        .localId(MessageLocalId.create(UUID.randomUUID().toString()))
        .depotAt(MessageDepotAt.create(java.time.Instant.now().plusSeconds(3600)))
        .syncAt(MessageSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .build();

		command.setCreatedBy(MessageCreatedBy.create(user.getId()));
		command.setTenant(MessageTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
