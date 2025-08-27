package com.groupe2cs.bizyhub.debts.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.debts.application.command.*;
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


class DebtFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private DebtRepository debtRepository;

@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_return_only_user_debts_for_normal_user() throws Exception {

List<CreateDebtCommand> userCommands =
DebtFixtures.randomManyViaCommand(
commandGateway,debtRepository,
createdByDataRepository,
tenantDataRepository,
 3, login("user", "user"));
userCommands.forEach(cmd ->
DebtFixtures.byIdWaitExist(debtRepository, cmd.getId().value())
);

login("user", "user");
ResponseEntity<DebtPagedResponse> response = this.getForEntity(
"/v1/queries/debts?page=0&limit=1000000",
DebtPagedResponse.class
);

assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<DebtResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(DebtResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);
}

@Test
void it_should_return_all_debts_for_admin() throws Exception {

    List<CreateDebtCommand> userCommands =
    DebtFixtures.randomManyViaCommand(
        commandGateway,
        debtRepository,
         createdByDataRepository,
         tenantDataRepository,
         5, login("user", "user")
      );
    userCommands.forEach(cmd ->
    DebtFixtures.byIdWaitExist(debtRepository, cmd.getId().value())
    );


List<CreateDebtCommand> adminCommands =
DebtFixtures.randomManyViaCommand(
commandGateway,debtRepository,
        createdByDataRepository,
        tenantDataRepository,
 5, login("admin", "admin"));
adminCommands.forEach(cmd ->
DebtFixtures.byIdWaitExist(debtRepository, cmd.getId().value())
);

login("admin", "admin");
ResponseEntity<DebtPagedResponse> response = this.getForEntity(
"/v1/queries/debts?page=0&limit=1000000",
DebtPagedResponse.class
);
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<DebtResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(DebtResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);

}
}
