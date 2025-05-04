package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.sales.application.command.*;
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


class SaleFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private SaleRepository saleRepository;

@Test
void it_should_return_only_user_sales_for_normal_user() throws Exception {

List<CreateSaleCommand> userCommands =
SaleFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
userCommands.forEach(cmd ->
SaleFixtures.byIdWaitExist(saleRepository, cmd.getId().value())
);

login("user", "user");
ResponseEntity<SalePagedResponse> response = this.getForEntity(
"/v1/queries/sales?page=0&limit=1000000",
SalePagedResponse.class
);

assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<SaleResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(SaleResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);
}

@Test
void it_should_return_all_sales_for_admin() throws Exception {

List<CreateSaleCommand> userCommands =
SaleFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
userCommands.forEach(cmd ->
SaleFixtures.byIdWaitExist(saleRepository, cmd.getId().value())
);


List<CreateSaleCommand> adminCommands =
SaleFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
adminCommands.forEach(cmd ->
SaleFixtures.byIdWaitExist(saleRepository, cmd.getId().value())
);

login("admin", "admin");
ResponseEntity<SalePagedResponse> response = this.getForEntity(
"/v1/queries/sales?page=0&limit=1000000",
SalePagedResponse.class
);
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<SaleResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(SaleResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);

}
}
