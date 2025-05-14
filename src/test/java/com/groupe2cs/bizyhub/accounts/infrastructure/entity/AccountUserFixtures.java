package com.groupe2cs.bizyhub.accounts.infrastructure.entity;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountUserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
			com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository,
			com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository,
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
					accountDataRepository,
					userDataRepository,
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
			AccountUserRepository repository,
			com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository,
			com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateAccountUserCommand command = CreateAccountUserCommand.builder()
				.name(AccountUserName.create(UUID.randomUUID().toString()))
				.account(AccountUserAccount.create(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(
						commandGateway,
						accountDataRepository,
						user).getId().value()))
				.user(AccountUserUser.create(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(
						commandGateway,
						userDataRepository,
						user).getId().value()))
				.username(AccountUserUsername.create(UUID.randomUUID().toString()))
				.details(AccountUserDetails.create(UUID.randomUUID().toString()))
				.isActive(AccountUserIsActive.create(true))
				.updatedAt(AccountUserUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(AccountUserReference.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(AccountUserCreatedBy.create(user.getId()));
		command.setTenant(AccountUserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateAccountUserCommand randomOneViaCommand(
			CommandGateway commandGateway,
			AccountUserRepository repository,
			User user
	) {

		CreateAccountUserCommand command = CreateAccountUserCommand.builder()
				.name(AccountUserName.create(UUID.randomUUID().toString()))
				.username(AccountUserUsername.create(UUID.randomUUID().toString()))
				.details(AccountUserDetails.create(UUID.randomUUID().toString()))
				.isActive(AccountUserIsActive.create(true))
				.updatedAt(AccountUserUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)))
				.reference(AccountUserReference.create(UUID.randomUUID().toString()))
				.build();

		command.setCreatedBy(AccountUserCreatedBy.create(user.getId()));
		command.setTenant(AccountUserTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
