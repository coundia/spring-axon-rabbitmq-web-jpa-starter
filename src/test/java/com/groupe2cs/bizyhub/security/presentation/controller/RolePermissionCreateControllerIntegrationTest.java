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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class RolePermissionCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private RoleRepository roleDataRepository ;
@Autowired
private PermissionRepository permissionDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_rolepermission() {

		RolePermissionRequest requestDTO = new RolePermissionRequest();

		requestDTO.setRole(RoleFixtures.randomOneViaCommand(commandGateway,roleDataRepository, user).getId().value());
		requestDTO.setPermission(PermissionFixtures.randomOneViaCommand(commandGateway,permissionDataRepository, user).getId().value());

 		String uri = "/v1/admin/commands/rolePermission";
		ResponseEntity<RolePermissionResponse> response = this.postForEntity(uri, requestDTO, RolePermissionResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getRole()).isEqualTo(requestDTO.getRole());
		assertThat(response.getBody().getPermission()).isEqualTo(requestDTO.getPermission());
	}
}
