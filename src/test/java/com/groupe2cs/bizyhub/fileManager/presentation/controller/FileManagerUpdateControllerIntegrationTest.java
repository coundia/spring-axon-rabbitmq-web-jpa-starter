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
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;

public class FileManagerUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private FileManagerRepository filemanagerRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CommandGateway commandGatewayUpdate;

    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_update_filemanager() {

        String existingId = FileManagerFixtures.randomOneViaCommand(
            commandGateway, filemanagerRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        ).getId().value();

        CreateFileManagerCommand updated = FileManagerFixtures.randomOneViaCommand(
            commandGatewayUpdate, filemanagerRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        );

        FileManagerFixtures.byIdWaitExist(filemanagerRepository, existingId);
        FileManagerFixtures.byIdWaitExist(filemanagerRepository, updated.getId().value());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("name", UUID.randomUUID().toString());
        body.add("details", UUID.randomUUID().toString());
        body.add("objectId", UUID.randomUUID().toString());
        body.add("objectName", UUID.randomUUID().toString());
        body.add("originalName", UUID.randomUUID().toString());
        body.add("mimeType", UUID.randomUUID().toString());
        body.add("size", 65736L);
        body.add("path", UUID.randomUUID().toString());
        body.add("uri", UUID.randomUUID().toString());
        body.add("isPublic", false);

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/fileManager/" + existingId;
        ResponseEntity<String> response = testRestTemplate.exchange(
            uri,
            HttpMethod.PUT,
            requestEntity,
            String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
