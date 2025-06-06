package com.groupe2cs.bizyhub.settings.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.settings.application.command.CreateSettingCommand;
import com.groupe2cs.bizyhub.settings.application.dto.SettingPagedResponse;
import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.SettingFixtures;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.SettingRepository;
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


class SettingFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private SettingRepository settingRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_settings_for_normal_user() throws Exception {

		List<CreateSettingCommand> userCommands =
				SettingFixtures.randomManyViaCommand(
						commandGateway, settingRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				SettingFixtures.byIdWaitExist(settingRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<SettingPagedResponse> response = this.getForEntity(
				"/v1/queries/settings?page=0&limit=1000000",
				SettingPagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<SettingResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(SettingResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_settings_for_admin() throws Exception {

		List<CreateSettingCommand> userCommands =
				SettingFixtures.randomManyViaCommand(
						commandGateway,
						settingRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				SettingFixtures.byIdWaitExist(settingRepository, cmd.getId().value())
		);


		List<CreateSettingCommand> adminCommands =
				SettingFixtures.randomManyViaCommand(
						commandGateway, settingRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				SettingFixtures.byIdWaitExist(settingRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<SettingPagedResponse> response = this.getForEntity(
				"/v1/queries/settings?page=0&limit=1000000",
				SettingPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<SettingResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(SettingResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
