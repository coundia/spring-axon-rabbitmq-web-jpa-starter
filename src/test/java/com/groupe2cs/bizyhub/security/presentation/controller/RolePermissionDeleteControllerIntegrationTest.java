package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class RolePermissionDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private RolePermissionRepository rolepermissionRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_delete_rolepermission() {
		String existingId = RolePermissionFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();

		RolePermissionFixtures.byIdWaitExist(rolepermissionRepository, existingId);

		String uri = "/v1/admin/commands/rolePermission/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		RolePermission found = RolePermissionFixtures.byIdWaitNotExist(rolepermissionRepository, existingId);
		assertThat(found).isNull();
	}
}
