package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.sync.application.command.CreateChangeLogCommand;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogPagedResponse;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogResponse;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.ChangeLogFixtures;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.ChangeLogRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class ChangeLogFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private ChangeLogRepository changeLogRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_changeLogs_for_normal_user() throws Exception {

		List<CreateChangeLogCommand> userCommands =
				ChangeLogFixtures.randomManyViaCommand(
						commandGateway, changeLogRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				ChangeLogFixtures.byIdWaitExist(changeLogRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<ChangeLogPagedResponse> response = this.getForEntity(
				"/v1/queries/changeLogs?page=0&limit=1000000",
				ChangeLogPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<ChangeLogResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(ChangeLogResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_changeLogs_for_admin() throws Exception {

		List<CreateChangeLogCommand> userCommands =
				ChangeLogFixtures.randomManyViaCommand(
						commandGateway,
						changeLogRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				ChangeLogFixtures.byIdWaitExist(changeLogRepository, cmd.getId().value())
		);


		List<CreateChangeLogCommand> adminCommands =
				ChangeLogFixtures.randomManyViaCommand(
						commandGateway, changeLogRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				ChangeLogFixtures.byIdWaitExist(changeLogRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<ChangeLogPagedResponse> response = this.getForEntity(
				"/v1/queries/changeLogs?page=0&limit=1000000",
				ChangeLogPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<ChangeLogResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(ChangeLogResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
