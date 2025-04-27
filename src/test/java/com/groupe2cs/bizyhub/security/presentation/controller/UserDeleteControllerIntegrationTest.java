package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
import com.groupe2cs.bizyhub.tenant.presentation.controller.TenantFixtures;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class UserDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private UserRepository userRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_delete_user() {
	String existingId = UserFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();

	UserFixtures.byIdWaitExist(userRepository, existingId);

	String uri = "/v1/admin/commands/user/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	CustomUser found = UserFixtures.byIdWaitNotExist(userRepository, existingId);
	assertThat(found).isNull();
	}
}
