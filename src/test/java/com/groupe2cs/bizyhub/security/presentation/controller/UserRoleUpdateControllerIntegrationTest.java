package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class UserRoleUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private UserRoleRepository userroleRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;


@Test
void it_should_be_able_to_update_userrole() {

	String existingId = UserRoleFixtures.randomOneViaCommand(commandGateway, getCurrentUser() ).getId().value();
	CreateUserRoleCommand updated = UserRoleFixtures.randomOneViaCommand(commandGatewayUpdate, getCurrentUser());

	UserRoleFixtures.byIdWaitExist(userroleRepository, existingId);
	UserRoleFixtures.byIdWaitExist(userroleRepository, updated.getId().value());

	UserRoleRequest requestDTO = new UserRoleRequest();
	 requestDTO.setUser( updated.getUser().value());
	 requestDTO.setRole( updated.getRole().value());

	String uri = "/v1/admin/commands/userRole/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
