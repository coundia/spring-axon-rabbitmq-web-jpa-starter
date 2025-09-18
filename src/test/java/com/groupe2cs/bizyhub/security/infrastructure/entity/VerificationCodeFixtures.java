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

public class VerificationCodeFixtures {

	public static VerificationCode byId(VerificationCodeRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static VerificationCode byIdWaitExist(VerificationCodeRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static VerificationCode byIdWaitNotExist(VerificationCodeRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateVerificationCodeCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		VerificationCodeRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateVerificationCodeCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateVerificationCodeCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
        createdByDataRepository,
        tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(VerificationCodeRepository repository) {
		repository.deleteAll();
	}

		public static CreateVerificationCodeCommand randomOneViaCommand(
		CommandGateway commandGateway,
		VerificationCodeRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateVerificationCodeCommand command = CreateVerificationCodeCommand.builder()
				.notes(VerificationCodeNotes.create(UUID.randomUUID().toString()))
				.token(VerificationCodeToken.create(UUID.randomUUID().toString()))
				.username(VerificationCodeUsername.create(UUID.randomUUID().toString()))
				.phone(VerificationCodePhone.create(UUID.randomUUID().toString()))
				.email(VerificationCodeEmail.create(UUID.randomUUID().toString()))
				.code(VerificationCodeCode.create(UUID.randomUUID().toString()))
				.status(VerificationCodeStatus.create(UUID.randomUUID().toString()))
				.source(VerificationCodeSource.create(UUID.randomUUID().toString()))
				.expiration(VerificationCodeExpiration.create(java.time.Instant.now().plusSeconds(3600)))
			.build();

		command.setCreatedBy(VerificationCodeCreatedBy.create(user.getId()));
		command.setTenant(VerificationCodeTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateVerificationCodeCommand randomOneViaCommand(
        CommandGateway commandGateway,
        VerificationCodeRepository  repository,
        User user
        ) {

        CreateVerificationCodeCommand command = CreateVerificationCodeCommand.builder()
        .notes(VerificationCodeNotes.create(UUID.randomUUID().toString()))
        .token(VerificationCodeToken.create(UUID.randomUUID().toString()))
        .username(VerificationCodeUsername.create(UUID.randomUUID().toString()))
        .phone(VerificationCodePhone.create(UUID.randomUUID().toString()))
        .email(VerificationCodeEmail.create(UUID.randomUUID().toString()))
        .code(VerificationCodeCode.create(UUID.randomUUID().toString()))
        .status(VerificationCodeStatus.create(UUID.randomUUID().toString()))
        .source(VerificationCodeSource.create(UUID.randomUUID().toString()))
        .expiration(VerificationCodeExpiration.create(java.time.Instant.now().plusSeconds(3600)))
        .build();

		command.setCreatedBy(VerificationCodeCreatedBy.create(user.getId()));
		command.setTenant(VerificationCodeTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
