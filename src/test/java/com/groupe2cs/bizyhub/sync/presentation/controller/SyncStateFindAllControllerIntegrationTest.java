package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.sync.application.command.CreateSyncStateCommand;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStatePagedResponse;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncStateFixtures;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.SyncStateRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class SyncStateFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private SyncStateRepository syncStateRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_syncStates_for_normal_user() throws Exception {

		List<CreateSyncStateCommand> userCommands =
				SyncStateFixtures.randomManyViaCommand(
						commandGateway, syncStateRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				SyncStateFixtures.byIdWaitExist(syncStateRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<SyncStatePagedResponse> response = this.getForEntity(
				"/v1/queries/syncStates?page=0&limit=1000000",
				SyncStatePagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<SyncStateResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(SyncStateResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_syncStates_for_admin() throws Exception {

		List<CreateSyncStateCommand> userCommands =
				SyncStateFixtures.randomManyViaCommand(
						commandGateway,
						syncStateRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				SyncStateFixtures.byIdWaitExist(syncStateRepository, cmd.getId().value())
		);


		List<CreateSyncStateCommand> adminCommands =
				SyncStateFixtures.randomManyViaCommand(
						commandGateway, syncStateRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				SyncStateFixtures.byIdWaitExist(syncStateRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<SyncStatePagedResponse> response = this.getForEntity(
				"/v1/queries/syncStates?page=0&limit=1000000",
				SyncStatePagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<SyncStateResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(SyncStateResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
