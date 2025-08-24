package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.stock.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;

public class StockMovementUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private StockMovementRepository stockmovementRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CommandGateway commandGatewayUpdate;

    @Autowired
    private com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository;
    @Autowired
    private com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productVariantDataRepository;
    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_update_stockmovement() {

        String existingId = StockMovementFixtures.randomOneViaCommand(
            commandGateway, stockmovementRepository,
        companyDataRepository,
        productVariantDataRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        ).getId().value();

        CreateStockMovementCommand updated = StockMovementFixtures.randomOneViaCommand(
            commandGatewayUpdate, stockmovementRepository,
        companyDataRepository,
        productVariantDataRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        );

        StockMovementFixtures.byIdWaitExist(stockmovementRepository, existingId);
        StockMovementFixtures.byIdWaitExist(stockmovementRepository, updated.getId().value());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("typeStockMovement", UUID.randomUUID().toString());
        body.add("quantity", 61);
        body.add("remoteId", UUID.randomUUID().toString());
        body.add("localId", UUID.randomUUID().toString());
        body.add("company", updated.getCompany().value());
        body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
        body.add("productVariant", updated.getProductVariant().value());
        body.add("orderLineId", UUID.randomUUID().toString());
        body.add("discriminator", UUID.randomUUID().toString());

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/stockMovement/" + existingId;
        ResponseEntity<String> response = testRestTemplate.exchange(
            uri,
            HttpMethod.PUT,
            requestEntity,
            String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
