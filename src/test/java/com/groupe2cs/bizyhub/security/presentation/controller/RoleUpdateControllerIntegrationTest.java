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

public class RoleUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private RoleRepository roleRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;

@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_update_role() {

	String existingId = RoleFixtures.randomOneViaCommand(
	commandGateway,roleRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser() ).getId().value();

	CreateRoleCommand updated = RoleFixtures.randomOneViaCommand(commandGatewayUpdate,
    roleRepository,
            createdByDataRepository,
            tenantDataRepository,
     getCurrentUser());

	RoleFixtures.byIdWaitExist(roleRepository, existingId);
	RoleFixtures.byIdWaitExist(roleRepository, updated.getId().value());

	RoleRequest requestDTO = new RoleRequest();
	 requestDTO.setName(UUID.randomUUID().toString());

	String uri = "/v1/admin/commands/role/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
