package com.groupe2cs.bizyhub.settings.presentation.controller;

import com.groupe2cs.bizyhub.settings.infrastructure.entity.Setting;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.SettingFixtures;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.SettingRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class SettingDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private SettingRepository settingRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_delete_setting() {
		String existingId = SettingFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		SettingFixtures.byIdWaitExist(settingRepository, existingId);

		String uri = "/v1/commands/setting/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Setting found = SettingFixtures.byIdWaitNotExist(settingRepository, existingId);
		assertThat(found).isNull();
	}
}
