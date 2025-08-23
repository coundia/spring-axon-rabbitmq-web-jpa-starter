package com.groupe2cs.bizyhub.companies.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.companies.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;

public class CompanyUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CommandGateway commandGatewayUpdate;

    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_update_company() {

        String existingId = CompanyFixtures.randomOneViaCommand(
            commandGateway, companyRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        ).getId().value();

        CreateCompanyCommand updated = CompanyFixtures.randomOneViaCommand(
            commandGatewayUpdate, companyRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        );

        CompanyFixtures.byIdWaitExist(companyRepository, existingId);
        CompanyFixtures.byIdWaitExist(companyRepository, updated.getId().value());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("remoteId", UUID.randomUUID().toString());
        body.add("code", UUID.randomUUID().toString());
        body.add("name", UUID.randomUUID().toString());
        body.add("description", UUID.randomUUID().toString());
        body.add("phone", UUID.randomUUID().toString());
        body.add("email", UUID.randomUUID().toString());
        body.add("website", UUID.randomUUID().toString());
        body.add("taxId", UUID.randomUUID().toString());
        body.add("currency", UUID.randomUUID().toString());
        body.add("addressLine1", UUID.randomUUID().toString());
        body.add("addressLine2", UUID.randomUUID().toString());
        body.add("city", UUID.randomUUID().toString());
        body.add("region", UUID.randomUUID().toString());
        body.add("country", UUID.randomUUID().toString());
        body.add("postalCode", UUID.randomUUID().toString());
        body.add("isActive", false);
        body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
        body.add("isDefault", false);

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/company/" + existingId;
        ResponseEntity<String> response = testRestTemplate.exchange(
            uri,
            HttpMethod.PUT,
            requestEntity,
            String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
