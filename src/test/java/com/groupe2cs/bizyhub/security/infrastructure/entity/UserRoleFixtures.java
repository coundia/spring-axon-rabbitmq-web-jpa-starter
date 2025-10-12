package com.groupe2cs.bizyhub.security.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.security.application.command.*;

import java.util.UUID;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;

import static org.awaitility.Awaitility.await;

public class UserRoleFixtures {

	public static UserRole byId(UserRoleRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static UserRole byIdWaitExist(UserRoleRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static UserRole byIdWaitNotExist(UserRoleRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateUserRoleCommand> randomManyViaCommand(
			CommandGateway commandGateway,
			UserRoleRepository repository,
			UserRepository userDataRepository,
			RoleRepository roleDataRepository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			int count,
			User user
	) {
		List<CreateUserRoleCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateUserRoleCommand command = randomOneViaCommand(
					commandGateway,
					repository,
					userDataRepository,
					roleDataRepository,
					createdByDataRepository,
					tenantDataRepository,
					user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(UserRoleRepository repository) {
		repository.deleteAll();
	}

	public static CreateUserRoleCommand randomOneViaCommand(
			CommandGateway commandGateway,
			UserRoleRepository repository,
			UserRepository userDataRepository,
			RoleRepository roleDataRepository,
			UserRepository createdByDataRepository,
			TenantRepository tenantDataRepository,
			User user) {

		CreateUserRoleCommand command = CreateUserRoleCommand.builder()
				.user(UserRoleUser.create(UserFixtures.randomOneViaCommand(commandGateway, userDataRepository, user)
						.getId().value()))
				.role(UserRoleRole.create(RoleFixtures.randomOneViaCommand(commandGateway, roleDataRepository, user)
						.getId().value()))
				.build();

		command.setCreatedBy(UserRoleCreatedBy.create(user.getId()));
		command.setTenant(UserRoleTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateUserRoleCommand randomOneViaCommand(
			CommandGateway commandGateway,
			UserRoleRepository repository,
			User user
	) {

		CreateUserRoleCommand command = CreateUserRoleCommand.builder()
				.build();

		command.setCreatedBy(UserRoleCreatedBy.create(user.getId()));
		command.setTenant(UserRoleTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
