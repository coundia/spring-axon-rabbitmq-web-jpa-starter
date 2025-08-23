package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.stock.application.command.*;
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


class StockMovementFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private StockMovementRepository stockMovementRepository;

@Autowired
private com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productVariantDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_return_only_user_stockMovements_for_normal_user() throws Exception {

List<CreateStockMovementCommand> userCommands =
StockMovementFixtures.randomManyViaCommand(
commandGateway,stockMovementRepository,
companyDataRepository,
productVariantDataRepository,
createdByDataRepository,
tenantDataRepository,
 3, login("user", "user"));
userCommands.forEach(cmd ->
StockMovementFixtures.byIdWaitExist(stockMovementRepository, cmd.getId().value())
);

login("user", "user");
ResponseEntity<StockMovementPagedResponse> response = this.getForEntity(
"/v1/queries/stockMovements?page=0&limit=1000000",
StockMovementPagedResponse.class
);

assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<StockMovementResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(StockMovementResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);
}

@Test
void it_should_return_all_stockMovements_for_admin() throws Exception {

    List<CreateStockMovementCommand> userCommands =
    StockMovementFixtures.randomManyViaCommand(
        commandGateway,
        stockMovementRepository,
         companyDataRepository,
         productVariantDataRepository,
         createdByDataRepository,
         tenantDataRepository,
         5, login("user", "user")
      );
    userCommands.forEach(cmd ->
    StockMovementFixtures.byIdWaitExist(stockMovementRepository, cmd.getId().value())
    );


List<CreateStockMovementCommand> adminCommands =
StockMovementFixtures.randomManyViaCommand(
commandGateway,stockMovementRepository,
        companyDataRepository,
        productVariantDataRepository,
        createdByDataRepository,
        tenantDataRepository,
 5, login("admin", "admin"));
adminCommands.forEach(cmd ->
StockMovementFixtures.byIdWaitExist(stockMovementRepository, cmd.getId().value())
);

login("admin", "admin");
ResponseEntity<StockMovementPagedResponse> response = this.getForEntity(
"/v1/queries/stockMovements?page=0&limit=1000000",
StockMovementPagedResponse.class
);
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<StockMovementResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(StockMovementResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);

}
}
