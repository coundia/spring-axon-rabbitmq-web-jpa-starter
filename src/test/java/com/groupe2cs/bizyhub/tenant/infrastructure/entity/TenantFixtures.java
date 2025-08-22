package com.groupe2cs.bizyhub.tenant.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class TenantFixtures {

	public static Tenant byId(TenantRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static Tenant byIdWaitExist(TenantRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static Tenant byIdWaitNotExist(TenantRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateTenantCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		TenantRepository repository,
        TenantRepository tenantDataRepository,
        UserRepository createdByDataRepository,
		int count,
		User user
	) {
		List<CreateTenantCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateTenantCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            tenantDataRepository,
            createdByDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(TenantRepository repository) {
		repository.deleteAll();
	}

		public static CreateTenantCommand randomOneViaCommand(
		CommandGateway commandGateway,
		TenantRepository  repository,
        TenantRepository tenantDataRepository,
        UserRepository createdByDataRepository,
		 User user) {

			CreateTenantCommand command = CreateTenantCommand.builder()
				.name(TenantName.create(UUID.randomUUID().toString()))
				.description(TenantDescription.create(UUID.randomUUID().toString()))
				.domain(TenantDomain.create(UUID.randomUUID().toString()))
				.language(TenantLanguage.create(UUID.randomUUID().toString()))
				.active(TenantActive.create(true))
			.build();

		command.setCreatedBy(TenantCreatedBy.create(user.getId()));
		command.setTenant(TenantTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


}
