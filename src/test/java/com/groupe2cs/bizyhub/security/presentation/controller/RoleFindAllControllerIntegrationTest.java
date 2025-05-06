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


class RoleFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private RoleRepository roleRepository;

@Test
void it_should_return_only_user_roles_for_normal_user() throws Exception {

List<CreateRoleCommand> userCommands =
RoleFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
userCommands.forEach(cmd ->
RoleFixtures.byIdWaitExist(roleRepository, cmd.getId().value())
);

login("user", "user");
ResponseEntity<RolePagedResponse> response = this.getForEntity(
"/v1/admin/queries/roles?page=0&limit=1000000",
RolePagedResponse.class
);
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

}

@Test
void it_should_return_all_roles_for_admin() throws Exception {

List<CreateRoleCommand> userCommands =
RoleFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
userCommands.forEach(cmd ->
RoleFixtures.byIdWaitExist(roleRepository, cmd.getId().value())
);


List<CreateRoleCommand> adminCommands =
RoleFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
adminCommands.forEach(cmd ->
RoleFixtures.byIdWaitExist(roleRepository, cmd.getId().value())
);

login("admin", "admin");
ResponseEntity<RolePagedResponse> response = this.getForEntity(
"/v1/admin/queries/roles?page=0&limit=1000000",
RolePagedResponse.class
);
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<RoleResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(RoleResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);

}
}
