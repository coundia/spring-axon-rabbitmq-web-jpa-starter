package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
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

@Autowired
private RoleRepository roleDataRepository ;
@Autowired
private PermissionRepository permissionDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_update_rolepermission() {

	String existingId = RolePermissionFixtures.randomOneViaCommand(
	commandGateway,rolepermissionRepository,
        roleDataRepository,
        permissionDataRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser() ).getId().value();

	CreateRolePermissionCommand updated = RolePermissionFixtures.randomOneViaCommand(commandGatewayUpdate,
    rolepermissionRepository,
            roleDataRepository,
            permissionDataRepository,
            createdByDataRepository,
            tenantDataRepository,
     getCurrentUser());

	RolePermissionFixtures.byIdWaitExist(rolepermissionRepository, existingId);
	RolePermissionFixtures.byIdWaitExist(rolepermissionRepository, updated.getId().value());

	RolePermissionRequest requestDTO = new RolePermissionRequest();
	 requestDTO.setRole( updated.getRole().value());
	 requestDTO.setPermission( updated.getPermission().value());

	String uri = "/v1/admin/commands/rolePermission/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
