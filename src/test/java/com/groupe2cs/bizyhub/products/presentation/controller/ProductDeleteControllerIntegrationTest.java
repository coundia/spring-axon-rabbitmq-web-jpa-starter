package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import com.groupe2cs.bizyhub.products.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDeleteControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Test
    void it_should_be_able_to_delete_product() {
        String existingId = ProductFixtures.randomOneViaCommand(commandGateway);
        String uri = "/v1/commands/product/" + existingId;

        ResponseEntity<String> rep = this.delete(uri);
        assertThat(rep.getStatusCode().value()).isEqualTo(200);

        Product found = ProductFixtures.byId(productRepository, existingId);
        assertThat(found).isNull();
    }
}
