package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
import com.groupe2cs.bizyhub.tenant.application.command.*;
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


class TenantFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private TenantRepository tenantRepository;

@Test
void it_should_return_only_user_tenants_for_normal_user() throws Exception {
String userId = login("user", "user");
List<CreateTenantCommand> userCommands =
TenantFixtures.randomManyViaCommand(commandGateway, 3, userId);
userCommands.forEach(cmd ->
TenantFixtures.byIdWaitExist(tenantRepository, cmd.getId().value())
);

login("user", "user");
ResponseEntity<TenantPagedResponse> response = this.getForEntity(
"/v1/admin/queries/tenants",
TenantPagedResponse.class
);
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

}

@Test
void it_should_return_all_tenants_for_admin() throws Exception {
String userId = login("user", "user");
List<CreateTenantCommand> userCommands =
TenantFixtures.randomManyViaCommand(commandGateway, 5, userId);
userCommands.forEach(cmd ->
TenantFixtures.byIdWaitExist(tenantRepository, cmd.getId().value())
);

String adminId = login("admin", "admin");
List<CreateTenantCommand> adminCommands =
TenantFixtures.randomManyViaCommand(commandGateway, 5, adminId);
adminCommands.forEach(cmd ->
TenantFixtures.byIdWaitExist(tenantRepository, cmd.getId().value())
);

login("admin", "admin");
ResponseEntity<TenantPagedResponse> response = this.getForEntity(
"/v1/admin/queries/tenants",
TenantPagedResponse.class
);

assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<TenantResponse> content = response.getBody().getContent();
assertThat(content).hasSizeGreaterThanOrEqualTo(10);

}
}
