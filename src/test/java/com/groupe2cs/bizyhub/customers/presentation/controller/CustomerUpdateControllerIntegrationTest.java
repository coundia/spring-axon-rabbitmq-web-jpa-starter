package com.groupe2cs.bizyhub.customers.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.*;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.customers.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CommandGateway commandGatewayUpdate;

    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_update_customer() {

        String existingId = CustomerFixtures.randomOneViaCommand(
            commandGateway, customerRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        ).getId().value();

        CreateCustomerCommand updated = CustomerFixtures.randomOneViaCommand(
            commandGatewayUpdate, customerRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        );

        CustomerFixtures.byIdWaitExist(customerRepository, existingId);
        CustomerFixtures.byIdWaitExist(customerRepository, updated.getId().value());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("remoteId", UUID.randomUUID().toString());
        body.add("localId", UUID.randomUUID().toString());
        body.add("code", UUID.randomUUID().toString());
        body.add("firstName", UUID.randomUUID().toString());
        body.add("lastName", UUID.randomUUID().toString());
        body.add("fullName", UUID.randomUUID().toString());
        body.add("balance", 2413.92);
        body.add("balanceDebt", 9194.66);
        body.add("phone", UUID.randomUUID().toString());
        body.add("email", UUID.randomUUID().toString());
        body.add("notes", UUID.randomUUID().toString());
        body.add("status", UUID.randomUUID().toString());
        body.add("company", UUID.randomUUID().toString());
        body.add("addressLine1", UUID.randomUUID().toString());
        body.add("addressLine2", UUID.randomUUID().toString());
        body.add("city", UUID.randomUUID().toString());
        body.add("region", UUID.randomUUID().toString());
        body.add("country", UUID.randomUUID().toString());
        body.add("postalCode", UUID.randomUUID().toString());
        body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
        body.add("isActive", false);

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/customer/" + existingId;
        ResponseEntity<String> response = testRestTemplate.exchange(
            uri,
            HttpMethod.PUT,
            requestEntity,
            String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
