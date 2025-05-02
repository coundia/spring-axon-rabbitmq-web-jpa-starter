package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.CustomUser;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.categories.application.command.*;
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


class CategoryFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private CategoryRepository categoryRepository;

@Test
void it_should_return_only_user_categorys_for_normal_user() throws Exception {

List<CreateCategoryCommand> userCommands =
CategoryFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
userCommands.forEach(cmd ->
CategoryFixtures.byIdWaitExist(categoryRepository, cmd.getId().value())
);

login("user", "user");
ResponseEntity<CategoryPagedResponse> response = this.getForEntity(
"/v1/queries/categorys?page=0&limit=1000000",
CategoryPagedResponse.class
);

assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<CategoryResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(CategoryResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);
}

@Test
void it_should_return_all_categorys_for_admin() throws Exception {

List<CreateCategoryCommand> userCommands =
CategoryFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
userCommands.forEach(cmd ->
CategoryFixtures.byIdWaitExist(categoryRepository, cmd.getId().value())
);


List<CreateCategoryCommand> adminCommands =
CategoryFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
adminCommands.forEach(cmd ->
CategoryFixtures.byIdWaitExist(categoryRepository, cmd.getId().value())
);

login("admin", "admin");
ResponseEntity<CategoryPagedResponse> response = this.getForEntity(
"/v1/queries/categorys?page=0&limit=1000000",
CategoryPagedResponse.class
);
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<CategoryResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(CategoryResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);

}
}
