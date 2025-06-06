package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Permission;
import com.groupe2cs.bizyhub.security.infrastructure.entity.PermissionFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
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


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_permission() {
		String existingId = PermissionFixtures.randomOneViaCommand(commandGateway, permissionRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		PermissionFixtures.byIdWaitExist(permissionRepository, existingId);

		String uri = "/v1/admin/commands/permission/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Permission found = PermissionFixtures.byIdWaitNotExist(permissionRepository, existingId);
		assertThat(found).isNull();
	}
}
