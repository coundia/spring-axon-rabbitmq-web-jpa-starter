package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.sync.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;

public class ChangeLogUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private ChangeLogRepository changelogRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CommandGateway commandGatewayUpdate;

    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_update_changelog() {

        String existingId = ChangeLogFixtures.randomOneViaCommand(
            commandGateway, changelogRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        ).getId().value();

        CreateChangeLogCommand updated = ChangeLogFixtures.randomOneViaCommand(
            commandGatewayUpdate, changelogRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        );

        ChangeLogFixtures.byIdWaitExist(changelogRepository, existingId);
        ChangeLogFixtures.byIdWaitExist(changelogRepository, updated.getId().value());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("entityTable", UUID.randomUUID().toString());
        body.add("account", UUID.randomUUID().toString());
        body.add("remoteId", UUID.randomUUID().toString());
        body.add("localId", UUID.randomUUID().toString());
        body.add("operation", UUID.randomUUID().toString());
        body.add("payload", UUID.randomUUID().toString());
        body.add("status", UUID.randomUUID().toString());
        body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
        body.add("attempts", 51);
        body.add("error", UUID.randomUUID().toString());

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/changeLog/" + existingId;
        ResponseEntity<String> response = testRestTemplate.exchange(
            uri,
            HttpMethod.PUT,
            requestEntity,
            String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
