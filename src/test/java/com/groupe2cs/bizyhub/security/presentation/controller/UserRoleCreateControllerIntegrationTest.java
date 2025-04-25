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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class UserRoleCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_add_userrole() {

		UserRoleRequest requestDTO = new UserRoleRequest();

		requestDTO.setUser(UserFixtures.randomOneViaCommand(commandGateway, userId).getId().value());
		requestDTO.setRole(RoleFixtures.randomOneViaCommand(commandGateway, userId).getId().value());

 		String uri = "/v1/commands/userRole";
		ResponseEntity<UserRoleResponse> response = this.postForEntity(uri, requestDTO, UserRoleResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getUser()).isEqualTo(requestDTO.getUser());
		assertThat(response.getBody().getRole()).isEqualTo(requestDTO.getRole());
	}
}
