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
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class UserUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private UserRepository userRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;


@Test
void it_should_be_able_to_update_user() {

	String existingId = UserFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();
	CreateUserCommand updated = UserFixtures.randomOneViaCommand(commandGatewayUpdate, getUserId());

	UserFixtures.byIdWaitExist(userRepository, existingId);
	UserFixtures.byIdWaitExist(userRepository, updated.getId().value());

	UserRequest requestDTO = new UserRequest();
	 requestDTO.setUsername(UUID.randomUUID().toString());
	 requestDTO.setPassword(UUID.randomUUID().toString());

	String uri = "/v1/admin/commands/user/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
