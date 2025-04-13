package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import com.groupe2cs.bizyhub.products.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductUpdateControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Test
    void it_should_be_able_to_update_product() {

        String existingId = ProductFixtures.randomOneViaCommand(commandGateway);

        ProductRequest requestDTO = ProductRequest.random();
        HttpEntity<ProductRequest> request = new HttpEntity<>(requestDTO);

        String uri = "/v1/commands/product/" + existingId;
        ResponseEntity<String> response = this.put(uri, request);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Product found = ProductFixtures.byId(productRepository, existingId);
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(requestDTO.getName());
        assertThat(found.getPrice()).isEqualTo(requestDTO.getPrice());
    }
}
