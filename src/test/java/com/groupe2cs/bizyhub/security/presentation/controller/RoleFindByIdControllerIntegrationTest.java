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
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class RoleFindByIdControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private RoleRepository repository;

@Test
void it_should_be_able_to_get_role_by_id() {

	String existingId = RoleFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();

	 RoleFixtures.byIdWaitExist(repository, existingId);

	String uri = "/v1/queries/role/id?id=" + existingId;
	ResponseEntity<RoleResponse> response = this.getForEntity(uri, RoleResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
