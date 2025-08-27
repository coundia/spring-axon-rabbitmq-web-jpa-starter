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

public class AccountUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CommandGateway commandGatewayUpdate;

    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_update_account() {

        String existingId = AccountFixtures.randomOneViaCommand(
            commandGateway, accountRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        ).getId().value();

        CreateAccountCommand updated = AccountFixtures.randomOneViaCommand(
            commandGatewayUpdate, accountRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        );

        AccountFixtures.byIdWaitExist(accountRepository, existingId);
        AccountFixtures.byIdWaitExist(accountRepository, updated.getId().value());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("code", UUID.randomUUID().toString());
        body.add("name", UUID.randomUUID().toString());
        body.add("status", UUID.randomUUID().toString());
        body.add("currency", UUID.randomUUID().toString());
        body.add("typeAccount", UUID.randomUUID().toString());
        body.add("balance", 4027.37);
        body.add("balancePrev", 6636.54);
        body.add("balanceBlocked", 8313.8);
        body.add("balanceInit", 698.89);
        body.add("balanceGoal", 9783.6);
        body.add("balanceLimit", 8824.13);
        body.add("description", UUID.randomUUID().toString());
        body.add("isActive", true);
        body.add("isDefault", true);
        body.add("remoteId", UUID.randomUUID().toString());
        body.add("localId", UUID.randomUUID().toString());
        body.add("syncAt", java.time.Instant.now().plusSeconds(3600));

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/account/" + existingId;
        ResponseEntity<String> response = testRestTemplate.exchange(
            uri,
            HttpMethod.PUT,
            requestEntity,
            String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
