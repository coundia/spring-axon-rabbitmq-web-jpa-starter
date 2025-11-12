package com.groupe2cs.bizyhub.fileManager.presentation.controller;

import com.groupe2cs.bizyhub.fileManager.application.command.CreateFileManagerCommand;
import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerPagedResponse;
import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerResponse;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.FileManagerFixtures;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.FileManagerRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class FileManagerFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private FileManagerRepository fileManagerRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_fileManagers_for_normal_user() throws Exception {

		List<CreateFileManagerCommand> userCommands =
				FileManagerFixtures.randomManyViaCommand(
						commandGateway, fileManagerRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				FileManagerFixtures.byIdWaitExist(fileManagerRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<FileManagerPagedResponse> response = this.getForEntity(
				"/v1/queries/fileManagers?page=0&limit=1000000",
				FileManagerPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<FileManagerResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(FileManagerResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_fileManagers_for_admin() throws Exception {

		List<CreateFileManagerCommand> userCommands =
				FileManagerFixtures.randomManyViaCommand(
						commandGateway,
						fileManagerRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				FileManagerFixtures.byIdWaitExist(fileManagerRepository, cmd.getId().value())
		);


		List<CreateFileManagerCommand> adminCommands =
				FileManagerFixtures.randomManyViaCommand(
						commandGateway, fileManagerRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				FileManagerFixtures.byIdWaitExist(fileManagerRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<FileManagerPagedResponse> response = this.getForEntity(
				"/v1/queries/fileManagers?page=0&limit=1000000",
				FileManagerPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<FileManagerResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(FileManagerResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
