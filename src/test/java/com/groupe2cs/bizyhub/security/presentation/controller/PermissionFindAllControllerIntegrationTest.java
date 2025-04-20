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

import java.util.List;

public class PermissionFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private PermissionRepository permissionRepository;

@Test
void it_should_be_able_to_get_all_permissions() {
	PermissionFixtures.randomMany(permissionRepository, 5);

	String uri = "/v1/queries/list-permission";
	ResponseEntity<PermissionPagedResponse> response = this.getForEntity(uri, PermissionPagedResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getContent()).isNotEmpty();
	}
}
