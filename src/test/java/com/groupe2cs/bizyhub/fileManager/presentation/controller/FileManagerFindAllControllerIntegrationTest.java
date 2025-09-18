package com.groupe2cs.bizyhub.fileManager.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.fileManager.application.command.*;
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


class FileManagerFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private FileManagerRepository fileManagerRepository;

@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_return_only_user_fileManagers_for_normal_user() throws Exception {

List<CreateFileManagerCommand> userCommands =
FileManagerFixtures.randomManyViaCommand(
commandGateway,fileManagerRepository,
        createdByDataRepository,
        tenantDataRepository,
 3, login("user", "user"));
userCommands.forEach(cmd ->
FileManagerFixtures.byIdWaitExist(fileManagerRepository, cmd.getId().value())
);

login("user", "user");
ResponseEntity<FileManagerPagedResponse> response = this.getForEntity(
"/v1/queries/fileManagers?page=0&limit=1000000",
FileManagerPagedResponse.class
);

assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<FileManagerResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(FileManagerResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);
}

@Test
void it_should_return_all_fileManagers_for_admin() throws Exception {

    List<CreateFileManagerCommand> userCommands =
    FileManagerFixtures.randomManyViaCommand(
        commandGateway,
        fileManagerRepository,
        createdByDataRepository,
        tenantDataRepository,
         5, login("user", "user")
      );
    userCommands.forEach(cmd ->
    FileManagerFixtures.byIdWaitExist(fileManagerRepository, cmd.getId().value())
    );


List<CreateFileManagerCommand> adminCommands =
FileManagerFixtures.randomManyViaCommand(
commandGateway,fileManagerRepository,
        createdByDataRepository,
        tenantDataRepository,
 5, login("admin", "admin"));
adminCommands.forEach(cmd ->
FileManagerFixtures.byIdWaitExist(fileManagerRepository, cmd.getId().value())
);

login("admin", "admin");
ResponseEntity<FileManagerPagedResponse> response = this.getForEntity(
"/v1/queries/fileManagers?page=0&limit=1000000",
FileManagerPagedResponse.class
);
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
List<FileManagerResponse> content = response.getBody().getContent();
assertThat(content).isNotEmpty();

List<String> expectedIds = userCommands.stream()
.map(cmd -> cmd.getId().value())
.collect(Collectors.toList());

List<String> actualIds = content.stream()
.map(FileManagerResponse::getId)
.collect(Collectors.toList());

assertThat(actualIds).containsAll(expectedIds);

}
}
