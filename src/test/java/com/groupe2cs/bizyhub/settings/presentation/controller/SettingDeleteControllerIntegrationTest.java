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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

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
