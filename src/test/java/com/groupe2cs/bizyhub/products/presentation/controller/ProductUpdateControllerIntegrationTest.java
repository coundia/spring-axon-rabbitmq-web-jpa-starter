package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.products.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CommandGateway commandGatewayUpdate;

    @Autowired
    private com.groupe2cs.bizyhub.units.infrastructure.repository.UnitRepository unitDataRepository;
    @Autowired
    private com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository;
    @Autowired
    private UserRepository createdByDataRepository;
    @Autowired
    private TenantRepository tenantDataRepository;

    @Test
    void it_should_be_able_to_update_product() {

        String existingId = ProductFixtures.randomOneViaCommand(
            commandGateway, productRepository,
        unitDataRepository,
        categoryDataRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        ).getId().value();

        CreateProductCommand updated = ProductFixtures.randomOneViaCommand(
            commandGatewayUpdate, productRepository,
        unitDataRepository,
        categoryDataRepository,
        createdByDataRepository,
        tenantDataRepository,
            getCurrentUser()
        );

        ProductFixtures.byIdWaitExist(productRepository, existingId);
        ProductFixtures.byIdWaitExist(productRepository, updated.getId().value());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("remoteId", UUID.randomUUID().toString());
        body.add("localId", UUID.randomUUID().toString());
        body.add("code", UUID.randomUUID().toString());
        body.add("name", UUID.randomUUID().toString());
        body.add("description", UUID.randomUUID().toString());
        body.add("barcode", UUID.randomUUID().toString());
        body.add("unit", updated.getUnit().value());
        body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
        body.add("category", updated.getCategory().value());
        body.add("defaultPrice", 4864.13);
        body.add("statuses", UUID.randomUUID().toString());
        body.add("purchasePrice", 4431.45);

        HttpHeaders multipartHeaders = new HttpHeaders();
        multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

        String uri = "/api/v1/commands/product/" + existingId;
        ResponseEntity<String> response = testRestTemplate.exchange(
            uri,
            HttpMethod.PUT,
            requestEntity,
            String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
