package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class PermissionDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_delete_permission() {
		String existingId = PermissionFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();
		String uri = "/v1/commands/permission/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Permission found = PermissionFixtures.byIdWaitNotExist(permissionRepository, existingId);
		assertThat(found).isNull();
	}
}
