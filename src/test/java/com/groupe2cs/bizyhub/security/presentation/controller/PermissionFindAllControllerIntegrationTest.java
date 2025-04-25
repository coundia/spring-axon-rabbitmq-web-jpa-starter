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

class PermissionFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private PermissionRepository permissionRepository;

private void waitForPermission(String PermissionId) {
long timeout = Duration.ofSeconds(5).toMillis();
long start = System.currentTimeMillis();
while (System.currentTimeMillis() - start < timeout) {
if (permissionRepository.findById(PermissionId).isPresent()) {
return;
}
try {
Thread.sleep(100);
} catch (InterruptedException ignored) {
}
}
throw new RuntimeException("Permission not found after timeout: " + PermissionId);
}

@Test
void it_should_be_able_to_get_all_Permissions_as_admin() {
var userId = login("admin", "admin");

//PermissionFixtures.deleteAll(permissionRepository);

List<CreatePermissionCommand> commands = PermissionFixtures
	.randomManyViaCommand(commandGateway, 5, userId);

	commands.forEach(cmd -> waitForPermission(cmd.getId().value()));

	String uri = "/v1/queries/permissions";
	ResponseEntity<PermissionPagedResponse> response = this.getForEntity(uri, PermissionPagedResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getContent()).hasSizeGreaterThanOrEqualTo(5);
		}

		@Test
		void it_should_only_return_user_Permissions_as_normal_user() {
		var userId = login("user", "user");

		List<CreatePermissionCommand> list1 = PermissionFixtures.randomManyViaCommand(commandGateway, 3, userId);
			List<CreatePermissionCommand> list2 = PermissionFixtures.randomManyViaCommand(commandGateway, 2, userId);

				list1.forEach(cmd -> waitForPermission(cmd.getId().value()));
				list2.forEach(cmd -> waitForPermission(cmd.getId().value()));

				String uri = "/v1/queries/permissions";
				ResponseEntity<PermissionPagedResponse> response = this.getForEntity(uri, PermissionPagedResponse.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody()).isNotNull();
					assertThat(response.getBody().getContent())
					.allSatisfy(Permission -> assertThat(Permission.getCreatedBy()).isEqualTo(userId));
					}
					}
