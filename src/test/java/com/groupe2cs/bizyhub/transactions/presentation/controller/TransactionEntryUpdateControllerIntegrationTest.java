package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionEntryUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private TransactionEntryRepository transactionentryRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CommandGateway commandGatewayUpdate;

    @Autowired
    private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
    @Autowired
    private com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository;
    @Autowired
    private com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository;
    @Autowired
    private com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository;
    @Autowired
    private com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository debtDataRepository;
    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_update_transactionentry() {

        String existingId = TransactionEntryFixtures.randomOneViaCommand(
            commandGateway, transactionentryRepository,
        accountDataRepository,
        categoryDataRepository,
        companyDataRepository,
        customerDataRepository,
        debtDataRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        ).getId().value();

        CreateTransactionEntryCommand updated = TransactionEntryFixtures.randomOneViaCommand(
            commandGatewayUpdate, transactionentryRepository,
        accountDataRepository,
        categoryDataRepository,
        companyDataRepository,
        customerDataRepository,
        debtDataRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        );

        TransactionEntryFixtures.byIdWaitExist(transactionentryRepository, existingId);
        TransactionEntryFixtures.byIdWaitExist(transactionentryRepository, updated.getId().value());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("remoteId", UUID.randomUUID().toString());
        body.add("localId", UUID.randomUUID().toString());
        body.add("code", UUID.randomUUID().toString());
        body.add("description", UUID.randomUUID().toString());
        body.add("amount", 7863.44);
        body.add("typeEntry", UUID.randomUUID().toString());
        body.add("dateTransaction", java.time.Instant.now().plusSeconds(3600));
        body.add("status", UUID.randomUUID().toString());
        body.add("entityName", UUID.randomUUID().toString());
        body.add("entityId", UUID.randomUUID().toString());
        body.add("account", updated.getAccount().value());
        body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
        body.add("category", updated.getCategory().value());
        body.add("company", updated.getCompany().value());
        body.add("customer", updated.getCustomer().value());
        body.add("debt", updated.getDebt().value());

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/transactionEntry/" + existingId;
        ResponseEntity<String> response = testRestTemplate.exchange(
            uri,
            HttpMethod.PUT,
            requestEntity,
            String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
