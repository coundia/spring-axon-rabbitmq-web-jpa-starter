package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.infrastructure.entity.ApiKeyFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.ApiKeyRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class ApiKeyFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private ApiKeyRepository apiKeyRepository;

	@Test
	void it_should_return_only_user_apiKeys_for_normal_user() throws Exception {

		List<CreateApiKeyCommand> userCommands =
				ApiKeyFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
		userCommands.forEach(cmd ->
				ApiKeyFixtures.byIdWaitExist(apiKeyRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<ApiKeyPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/apiKeys?page=0&limit=1000000",
				ApiKeyPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

	}

	@Test
	void it_should_return_all_apiKeys_for_admin() throws Exception {

		List<CreateApiKeyCommand> userCommands =
				ApiKeyFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
		userCommands.forEach(cmd ->
				ApiKeyFixtures.byIdWaitExist(apiKeyRepository, cmd.getId().value())
		);


		List<CreateApiKeyCommand> adminCommands =
				ApiKeyFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				ApiKeyFixtures.byIdWaitExist(apiKeyRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<ApiKeyPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/apiKeys?page=0&limit=1000000",
				ApiKeyPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<ApiKeyResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(ApiKeyResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
