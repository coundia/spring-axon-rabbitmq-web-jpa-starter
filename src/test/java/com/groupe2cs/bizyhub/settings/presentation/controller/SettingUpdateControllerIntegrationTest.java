package com.groupe2cs.bizyhub.settings.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.settings.application.command.CreateSettingCommand;
import com.groupe2cs.bizyhub.settings.application.dto.SettingRequest;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.SettingFixtures;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.SettingRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class SettingUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private SettingRepository settingRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_setting() {

		String existingId = SettingFixtures.randomOneViaCommand(
				commandGateway, settingRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		CreateSettingCommand updated = SettingFixtures.randomOneViaCommand(commandGatewayUpdate,
				settingRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser());

		SettingFixtures.byIdWaitExist(settingRepository, existingId);
		SettingFixtures.byIdWaitExist(settingRepository, updated.getId().value());

		SettingRequest requestDTO = new SettingRequest();
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setValue(UUID.randomUUID().toString());
		requestDTO.setLocale(UUID.randomUUID().toString());
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(false);
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

		String uri = "/v1/commands/setting/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
