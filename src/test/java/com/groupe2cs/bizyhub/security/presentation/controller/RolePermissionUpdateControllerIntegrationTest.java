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

public class RolePermissionUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private RolePermissionRepository rolepermissionRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;


@Test
void it_should_be_able_to_update_rolepermission() {

	String existingId = RolePermissionFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();

	CreateRolePermissionCommand updated = RolePermissionFixtures.randomOneViaCommand(commandGatewayUpdate, getUserId());

	RolePermissionRequest requestDTO = new RolePermissionRequest();
	 requestDTO.setRole( updated.getRole().value());
	 requestDTO.setPermission( updated.getPermission().value());

	String uri = "/v1/commands/rolePermission/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
