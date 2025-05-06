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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class RolePermissionDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private RolePermissionRepository rolepermissionRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_delete_rolepermission() {
	String existingId = RolePermissionFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

	RolePermissionFixtures.byIdWaitExist(rolepermissionRepository, existingId);

	String uri = "/v1/admin/commands/rolePermission/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	RolePermission found = RolePermissionFixtures.byIdWaitNotExist(rolepermissionRepository, existingId);
	assertThat(found).isNull();
	}
}
