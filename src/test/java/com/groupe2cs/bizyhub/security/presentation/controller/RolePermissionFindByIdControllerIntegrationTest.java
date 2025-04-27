package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class RolePermissionFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private RolePermissionRepository repository;

	@Test
	void it_should_be_able_to_get_rolepermission_by_id() {

		String existingId = RolePermissionFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();

		RolePermissionFixtures.byIdWaitExist(repository, existingId);

		String uri = "/v1/admin/queries/rolePermission/id?id=" + existingId;
		ResponseEntity<RolePermissionResponse> response = this.getForEntity(uri, RolePermissionResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
