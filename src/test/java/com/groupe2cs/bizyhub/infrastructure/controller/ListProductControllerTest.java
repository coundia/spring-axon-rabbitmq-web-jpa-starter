package com.groupe2cs.bizyhub.infrastructure.controller;

import com.groupe2cs.bizyhub.products.application.dto.ProductResponseDTO;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ListProductControllerTest extends BaseIntegrationTests {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void it_should_list_products_with_pagination() {
        productRepository.save(new Product(UUID.randomUUID().toString(), "Product1", 100.0));
        productRepository.save(new Product(UUID.randomUUID().toString(), "Product2", 200.0));

        ResponseEntity<ProductResponseDTO[]> response = this.testRestTemplate.getForEntity(
                this.getBaseUrl() + "v1/queries/products?page=0&size=1",
                ProductResponseDTO[].class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().length).isEqualTo(1);
    }
}
