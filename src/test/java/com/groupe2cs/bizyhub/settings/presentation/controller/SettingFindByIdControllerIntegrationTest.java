package com.groupe2cs.bizyhub.settings.presentation.controller;

import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.SettingFixtures;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.SettingRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class SettingFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private SettingRepository repository;

	@Test
	void it_should_be_able_to_get_setting_by_id() {

		String existingId = SettingFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		SettingFixtures.byIdWaitExist(repository, existingId);

		String uri = "/v1/queries/setting/id?id=" + existingId;
		ResponseEntity<SettingResponse> response = this.getForEntity(uri, SettingResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
