package com.groupe2cs.bizyhub.chats.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.*;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.chats.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class ChatFixtures {

	public static Chat byId(ChatRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Chat byIdWaitExist(ChatRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Chat byIdWaitNotExist(ChatRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateChatCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		ChatRepository repository,
        com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateChatCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateChatCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            accountDataRepository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(ChatRepository repository) {
		repository.deleteAll();
	}

		public static CreateChatCommand randomOneViaCommand(
		CommandGateway commandGateway,
		ChatRepository  repository,
        com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateChatCommand command = CreateChatCommand.builder()
				.messages(ChatMessages.create(UUID.randomUUID().toString()))
				.responses(ChatResponses.create(UUID.randomUUID().toString()))
				.state(ChatState.create(UUID.randomUUID().toString()))
				.account(ChatAccount.create(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(commandGateway,accountDataRepository, user).getId().value()))
				.updatedAt(ChatUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(ChatReference.create(UUID.randomUUID().toString()))
			.build();

		command.setCreatedBy(ChatCreatedBy.create(user.getId()));
		command.setTenant(ChatTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateChatCommand randomOneViaCommand(
        CommandGateway commandGateway,
        ChatRepository  repository,
        User user
        ) {

        CreateChatCommand command = CreateChatCommand.builder()
        .messages(ChatMessages.create(UUID.randomUUID().toString()))
        .responses(ChatResponses.create(UUID.randomUUID().toString()))
        .state(ChatState.create(UUID.randomUUID().toString()))
        .updatedAt(ChatUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
        .reference(ChatReference.create(UUID.randomUUID().toString()))
        .build();

		command.setCreatedBy(ChatCreatedBy.create(user.getId()));
		command.setTenant(ChatTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
