package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermission;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RolePermissionFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.PermissionRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RolePermissionRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
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


	@Autowired
	private RoleRepository roleDataRepository;
	@Autowired
	private PermissionRepository permissionDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_rolepermission() {
		String existingId = RolePermissionFixtures.randomOneViaCommand(commandGateway, rolepermissionRepository,
				roleDataRepository,
				permissionDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		RolePermissionFixtures.byIdWaitExist(rolepermissionRepository, existingId);

		String uri = "/v1/admin/commands/rolePermission/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		RolePermission found = RolePermissionFixtures.byIdWaitNotExist(rolepermissionRepository, existingId);
		assertThat(found).isNull();
	}
}
