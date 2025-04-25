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

class RoleFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private RoleRepository roleRepository;

private void waitForRole(String RoleId) {
long timeout = Duration.ofSeconds(5).toMillis();
long start = System.currentTimeMillis();
while (System.currentTimeMillis() - start < timeout) {
if (roleRepository.findById(RoleId).isPresent()) {
return;
}
try {
Thread.sleep(100);
} catch (InterruptedException ignored) {
}
}
throw new RuntimeException("Role not found after timeout: " + RoleId);
}

@Test
void it_should_be_able_to_get_all_Roles_as_admin() {
var userId = login("admin", "admin");

//RoleFixtures.deleteAll(roleRepository);

List<CreateRoleCommand> commands = RoleFixtures
	.randomManyViaCommand(commandGateway, 5, userId);

	commands.forEach(cmd -> waitForRole(cmd.getId().value()));

	String uri = "/v1/queries/roles";
	ResponseEntity<RolePagedResponse> response = this.getForEntity(uri, RolePagedResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getContent()).hasSizeGreaterThanOrEqualTo(5);
		}

		@Test
		void it_should_only_return_user_Roles_as_normal_user() {
		var userId = login("user", "user");

		List<CreateRoleCommand> list1 = RoleFixtures.randomManyViaCommand(commandGateway, 3, userId);
			List<CreateRoleCommand> list2 = RoleFixtures.randomManyViaCommand(commandGateway, 2, userId);

				list1.forEach(cmd -> waitForRole(cmd.getId().value()));
				list2.forEach(cmd -> waitForRole(cmd.getId().value()));

				String uri = "/v1/queries/roles";
				ResponseEntity<RolePagedResponse> response = this.getForEntity(uri, RolePagedResponse.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody()).isNotNull();
					assertThat(response.getBody().getContent())
					.allSatisfy(Role -> assertThat(Role.getCreatedBy()).isEqualTo(userId));
					}
					}
