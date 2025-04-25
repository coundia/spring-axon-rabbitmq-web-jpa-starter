package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
import com.groupe2cs.bizyhub.tenant.presentation.controller.TenantFixtures;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class RolePermissionFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private RolePermissionRepository rolePermissionRepository;

private void waitForRolePermission(String RolePermissionId) {
long timeout = Duration.ofSeconds(5).toMillis();
long start = System.currentTimeMillis();
while (System.currentTimeMillis() - start < timeout) {
if (rolePermissionRepository.findById(RolePermissionId).isPresent()) {
return;
}
try {
Thread.sleep(100);
} catch (InterruptedException ignored) {
}
}
throw new RuntimeException("RolePermission not found after timeout: " + RolePermissionId);
}

@Test
void it_should_be_able_to_get_all_RolePermissions_as_admin() {
var userId = login("admin", "admin");

//RolePermissionFixtures.deleteAll(rolePermissionRepository);

List<CreateRolePermissionCommand> commands = RolePermissionFixtures
	.randomManyViaCommand(commandGateway, 5, userId);

	commands.forEach(cmd -> waitForRolePermission(cmd.getId().value()));

	String uri = "/v1/queries/rolePermissions";
	ResponseEntity<RolePermissionPagedResponse> response = this.getForEntity(uri, RolePermissionPagedResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getContent()).hasSizeGreaterThanOrEqualTo(5);
		}

		@Test
		void it_should_only_return_user_RolePermissions_as_normal_user() {
		var userId = login("user", "user");

		List<CreateRolePermissionCommand> list1 = RolePermissionFixtures.randomManyViaCommand(commandGateway, 3, userId);
			List<CreateRolePermissionCommand> list2 = RolePermissionFixtures.randomManyViaCommand(commandGateway, 2, userId);

				list1.forEach(cmd -> waitForRolePermission(cmd.getId().value()));
				list2.forEach(cmd -> waitForRolePermission(cmd.getId().value()));

				String uri = "/v1/queries/rolePermissions";
				ResponseEntity<RolePermissionPagedResponse> response = this.getForEntity(uri, RolePermissionPagedResponse.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody()).isNotNull();
					assertThat(response.getBody().getContent())
					.allSatisfy(RolePermission -> assertThat(RolePermission.getCreatedBy()).isEqualTo(userId));
					}
					}
