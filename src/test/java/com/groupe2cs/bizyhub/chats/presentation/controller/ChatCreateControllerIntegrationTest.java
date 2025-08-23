package com.groupe2cs.bizyhub.chats.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.*;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.chats.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import java.nio.charset.StandardCharsets;

public class ChatCreateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
    @Autowired
    private FileManagerRepository filesDataRepository;
    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_add_chat() {

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("messages", UUID.randomUUID().toString());
        body.add("responsesJson", UUID.randomUUID().toString());
        body.add("responses", UUID.randomUUID().toString());
        body.add("state", UUID.randomUUID().toString());
        body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
        body.add("account", com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(commandGateway,accountDataRepository, user).getId().value());
        body.add("dateTransaction", java.time.Instant.now().plusSeconds(3600));
        body.add("files", new ByteArrayResource("dummy content".getBytes(StandardCharsets.UTF_8)) {
            @Override
            public String getFilename() {
                return "test.txt";
            }
        });

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/chat";
        ResponseEntity<ChatResponse> response =
            testRestTemplate.postForEntity(uri, requestEntity, ChatResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

        assertThat(response.getBody().getMessages().toString())
            .isEqualTo(body.getFirst("messages").toString());
        assertThat(response.getBody().getResponsesJson().toString())
            .isEqualTo(body.getFirst("responsesJson").toString());
        assertThat(response.getBody().getResponses().toString())
            .isEqualTo(body.getFirst("responses").toString());
        assertThat(response.getBody().getState().toString())
            .isEqualTo(body.getFirst("state").toString());
        assertThat(response.getBody().getSyncAt().toString())
            .isEqualTo(body.getFirst("syncAt").toString());
        assertThat(response.getBody().getAccount().toString())
            .isEqualTo(body.getFirst("account").toString());
        assertThat(response.getBody().getDateTransaction().toString())
            .isEqualTo(body.getFirst("dateTransaction").toString());
    }
}
