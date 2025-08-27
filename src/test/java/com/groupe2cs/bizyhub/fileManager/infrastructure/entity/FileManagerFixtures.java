package com.groupe2cs.bizyhub.fileManager.infrastructure.entity;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.fileManager.application.command.*;
import java.util.UUID;

import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.mock.web.MockMultipartFile;
import static org.awaitility.Awaitility.await;

public class FileManagerFixtures {

	public static FileManager byId(FileManagerRepository repository, String id) {
		return repository.findById(id).orElse(null);
	}

	public static FileManager byIdWaitExist(FileManagerRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isPresent());
		return repository.findById(id).orElse(null);
	}

	public static FileManager byIdWaitNotExist(FileManagerRepository repository, String id) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(id).isEmpty());
		return null;
	}

	public static List<CreateFileManagerCommand> randomManyViaCommand(
		CommandGateway commandGateway,
		FileManagerRepository repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		int count,
		User user
	) {
		List<CreateFileManagerCommand> items = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			CreateFileManagerCommand command = randomOneViaCommand(
			commandGateway,
			 repository,
            createdByDataRepository,
            tenantDataRepository,
			 user);
			items.add(command);
		}
		return items;
	}

	public static void deleteAll(FileManagerRepository repository) {
		repository.deleteAll();
	}

		public static CreateFileManagerCommand randomOneViaCommand(
		CommandGateway commandGateway,
		FileManagerRepository  repository,
        UserRepository createdByDataRepository,
        TenantRepository tenantDataRepository,
		 User user) {

			CreateFileManagerCommand command = CreateFileManagerCommand.builder()
				.name(FileManagerName.create(UUID.randomUUID().toString()))
				.details(FileManagerDetails.create(UUID.randomUUID().toString()))
				.objectId(FileManagerObjectId.create(UUID.randomUUID().toString()))
				.objectName(FileManagerObjectName.create(UUID.randomUUID().toString()))
				.originalName(FileManagerOriginalName.create(UUID.randomUUID().toString()))
				.mimeType(FileManagerMimeType.create(UUID.randomUUID().toString()))
				.size(FileManagerSize.create(5991L))
				.path(FileManagerPath.create(UUID.randomUUID().toString()))
				.uri(FileManagerUri.create(UUID.randomUUID().toString()))
				.isPublic(FileManagerIsPublic.create(false))
			.build();

		command.setCreatedBy(FileManagerCreatedBy.create(user.getId()));
		command.setTenant(FileManagerTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}


	public static CreateFileManagerCommand randomOneViaCommand(
        CommandGateway commandGateway,
        FileManagerRepository  repository,
        User user
        ) {

        CreateFileManagerCommand command = CreateFileManagerCommand.builder()
        .name(FileManagerName.create(UUID.randomUUID().toString()))
        .details(FileManagerDetails.create(UUID.randomUUID().toString()))
        .objectId(FileManagerObjectId.create(UUID.randomUUID().toString()))
        .objectName(FileManagerObjectName.create(UUID.randomUUID().toString()))
        .originalName(FileManagerOriginalName.create(UUID.randomUUID().toString()))
        .mimeType(FileManagerMimeType.create(UUID.randomUUID().toString()))
        .size(FileManagerSize.create(5991L))
        .path(FileManagerPath.create(UUID.randomUUID().toString()))
        .uri(FileManagerUri.create(UUID.randomUUID().toString()))
        .isPublic(FileManagerIsPublic.create(false))
        .build();

		command.setCreatedBy(FileManagerCreatedBy.create(user.getId()));
		command.setTenant(FileManagerTenant.create(user.getTenant().getId()));
		commandGateway.sendAndWait(command);
		await().atMost(10, TimeUnit.SECONDS).until(() -> repository.findById(command.getId().value()).isPresent());
		return command;
	}
}
