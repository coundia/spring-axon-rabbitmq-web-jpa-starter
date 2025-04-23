package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.List;

public class PermissionFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private PermissionRepository permissionRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_get_all_permissions() {
	List<?> list = PermissionFixtures.randomManyViaCommand(commandGateway, 5);

	String uri = "/v1/queries/permissions";
	ResponseEntity<PermissionPagedResponse> response = this.getForEntity(uri, PermissionPagedResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getContent()).isNotEmpty();
	}
}
