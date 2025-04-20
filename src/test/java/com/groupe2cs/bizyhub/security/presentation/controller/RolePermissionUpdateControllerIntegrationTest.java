package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class RolePermissionUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private RolePermissionRepository rolepermissionRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;

//to check why failed sometimes
@Disabled
@Test
void it_should_be_able_to_update_rolepermission() {

	String existingId = RolePermissionFixtures.randomOneViaCommand(commandGateway).getId().value();

	CreateRolePermissionCommand updated = RolePermissionFixtures.randomOneViaCommand(commandGatewayUpdate);

	RolePermissionRequest requestDTO = new RolePermissionRequest();
	 requestDTO.setRole( updated.getRole().value());
	 requestDTO.setPermission( updated.getPermission().value());

	String uri = "/v1/commands/rolepermission/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	RolePermission found = RolePermissionFixtures.byIdWaitExist(rolepermissionRepository, existingId);
	assertThat(found).isNotNull();
			assertThat(found.getRole()).isEqualTo(requestDTO.getRole());
			assertThat(found.getPermission()).isEqualTo(requestDTO.getPermission());

	}
}
