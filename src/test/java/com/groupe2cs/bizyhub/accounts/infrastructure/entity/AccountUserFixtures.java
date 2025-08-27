package com.groupe2cs.bizyhub.accounts.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class AccountUserFixtures {

	public static AccountUser byId(AccountUserRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static AccountUser byIdWaitExist(AccountUserRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static AccountUser byIdWaitNotExist(AccountUserRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateAccountUserCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		AccountUserRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateAccountUserCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateAccountUserCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(AccountUserRepository repository) {
		repository.deleteAll();
	}

		public static CreateAccountUserCommand randomOneViaCommand(
		CommandGateway commandGateway,
		AccountUserRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateAccountUserCommand command = CreateAccountUserCommand.builder()
				.account(AccountUserAccount.create(UUID.randomUUID().toString()))
				.user(AccountUserUser.create(UUID.randomUUID().toString()))
				.identity(AccountUserIdentity.create(UUID.randomUUID().toString()))
				.phone(AccountUserPhone.create(UUID.randomUUID().toString()))
				.email(AccountUserEmail.create(UUID.randomUUID().toString()))
				.role(AccountUserRole.create(UUID.randomUUID().toString()))
				.status(AccountUserStatus.create(UUID.randomUUID().toString()))
				.invitedBy(AccountUserInvitedBy.create(UUID.randomUUID().toString()))
				.syncAt(AccountUserSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
				.acceptedAt(AccountUserAcceptedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.revokedAt(AccountUserRevokedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.message(AccountUserMessage.create(UUID.randomUUID().toString()))
				.remoteId(AccountUserRemoteId.create(UUID.randomUUID().toString()))
				.localId(AccountUserLocalId.create(UUID.randomUUID().toString()))
				.isActive(AccountUserIsActive.create(true))
			.build();

		command.setCreatedBy(AccountUserCreatedBy.create(user.getId()));
		command.setTenant(AccountUserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateAccountUserCommand randomOneViaCommand(
        CommandGateway commandGateway,
        AccountUserRepository  repository,
        User user
        ) {

        CreateAccountUserCommand command = CreateAccountUserCommand.builder()
        .account(AccountUserAccount.create(UUID.randomUUID().toString()))
        .user(AccountUserUser.create(UUID.randomUUID().toString()))
        .identity(AccountUserIdentity.create(UUID.randomUUID().toString()))
        .phone(AccountUserPhone.create(UUID.randomUUID().toString()))
        .email(AccountUserEmail.create(UUID.randomUUID().toString()))
        .role(AccountUserRole.create(UUID.randomUUID().toString()))
        .status(AccountUserStatus.create(UUID.randomUUID().toString()))
        .invitedBy(AccountUserInvitedBy.create(UUID.randomUUID().toString()))
        .syncAt(AccountUserSyncAt.create(java.time.Instant.now().plusSeconds(3600)))
        .acceptedAt(AccountUserAcceptedAt.create(java.time.Instant.now().plusSeconds(3600)))
        .revokedAt(AccountUserRevokedAt.create(java.time.Instant.now().plusSeconds(3600)))
        .message(AccountUserMessage.create(UUID.randomUUID().toString()))
        .remoteId(AccountUserRemoteId.create(UUID.randomUUID().toString()))
        .localId(AccountUserLocalId.create(UUID.randomUUID().toString()))
        .isActive(AccountUserIsActive.create(true))
        .build();

		command.setCreatedBy(AccountUserCreatedBy.create(user.getId()));
		command.setTenant(AccountUserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
