package com.groupe2cs.bizyhub.settings.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.*;
import com.groupe2cs.bizyhub.settings.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.settings.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class SettingUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private SettingRepository settingRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;


@Test
void it_should_be_able_to_update_setting() {

	String existingId = SettingFixtures.randomOneViaCommand(commandGateway, getCurrentUser() ).getId().value();
	CreateSettingCommand updated = SettingFixtures.randomOneViaCommand(commandGatewayUpdate, getCurrentUser());

	SettingFixtures.byIdWaitExist(settingRepository, existingId);
	SettingFixtures.byIdWaitExist(settingRepository, updated.getId().value());

	SettingRequest requestDTO = new SettingRequest();
	 requestDTO.setName(UUID.randomUUID().toString());
	 requestDTO.setReference(UUID.randomUUID().toString());
	 requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setStringValue(UUID.randomUUID().toString());
	 requestDTO.setDescriptions(UUID.randomUUID().toString());
	 requestDTO.setIsActive(false);

	String uri = "/v1/commands/setting/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
