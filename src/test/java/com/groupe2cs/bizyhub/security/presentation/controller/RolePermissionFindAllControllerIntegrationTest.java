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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class RolePermissionFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private RolePermissionRepository rolePermissionRepository;

@Test
void it_should_return_only_user_rolePermissions_for_normal_user() throws Exception {
String userId = login("user", "user");
List<CreateRolePermissionCommand> userCommands =
RolePermissionFixtures.randomManyViaCommand(commandGateway, 3, userId);
userCommands.forEach(cmd ->
RolePermissionFixtures.byIdWaitExist(rolePermissionRepository, cmd.getId().value())
);

login("user", "user");
ResponseEntity<RolePermissionPagedResponse> response = this.getForEntity(
"/v1/admin/queries/rolePermissions",
RolePermissionPagedResponse.class
);
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

}

@Test
void it_should_return_all_rolePermissions_for_admin() throws Exception {
String userId = login("user", "user");
List<CreateRolePermissionCommand> userCommands =
RolePermissionFixtures.randomManyViaCommand(commandGateway, 5, userId);
userCommands.forEach(cmd ->
RolePermissionFixtures.byIdWaitExist(rolePermissionRepository, cmd.getId().value())
);

String adminId = login("admin", "admin");
List<CreateRolePermissionCommand> adminCommands =
RolePermissionFixtures.randomManyViaCommand(commandGateway, 5, adminId);
adminCommands.forEach(cmd ->
RolePermissionFixtures.byIdWaitExist(rolePermissionRepository, cmd.getId().value())
);

login("admin", "admin");
ResponseEntity<RolePermissionPagedResponse> response = this.getForEntity(
"/v1/admin/queries/rolePermissions",
RolePermissionPagedResponse.class
);

assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<RolePermissionResponse> content = response.getBody().getContent();
assertThat(content).hasSizeGreaterThanOrEqualTo(10);

}
}
