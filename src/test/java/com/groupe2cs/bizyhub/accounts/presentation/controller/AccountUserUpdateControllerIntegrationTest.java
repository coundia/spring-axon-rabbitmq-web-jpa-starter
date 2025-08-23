package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountUserUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private AccountUserRepository accountuserRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CommandGateway commandGatewayUpdate;

    @Autowired
    private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
    @Autowired
    private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository;
    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_update_accountuser() {

        String existingId = AccountUserFixtures.randomOneViaCommand(
            commandGateway, accountuserRepository,
        accountDataRepository,
        userDataRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        ).getId().value();

        CreateAccountUserCommand updated = AccountUserFixtures.randomOneViaCommand(
            commandGatewayUpdate, accountuserRepository,
        accountDataRepository,
        userDataRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        );

        AccountUserFixtures.byIdWaitExist(accountuserRepository, existingId);
        AccountUserFixtures.byIdWaitExist(accountuserRepository, updated.getId().value());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("name", UUID.randomUUID().toString());
        body.add("account", updated.getAccount().value());
        body.add("user", updated.getUser().value());
        body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
        body.add("username", UUID.randomUUID().toString());
        body.add("details", UUID.randomUUID().toString());
        body.add("isActive", true);

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/accountUser/" + existingId;
        ResponseEntity<String> response = testRestTemplate.exchange(
            uri,
            HttpMethod.PUT,
            requestEntity,
            String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
