package com.groupe2cs.bizyhub.infrastructure.controller;

import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteProductControllerTest extends BaseIntegrationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void it_should_delete_product_by_id_and_return_ok() {
        // Arrange
        String id = UUID.randomUUID().toString();
        String productName = "test product to delete";
        double productPrice = 25.99;
        Product savedProduct = new Product(id, productName, productPrice);
        productRepository.save(savedProduct);
        URI deleteUrl = URI.create(this.getBaseUrl() + "v1/commands/products/" + id);

        ResponseEntity<String> response = testRestTemplate.exchange(deleteUrl, HttpMethod.DELETE, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product deleted successfully", response.getBody());
    }

    @Test
    void it_should_return_not_found_if_product_id_does_not_exist() {
        String nonExistingId = UUID.randomUUID().toString();
        URI deleteUrl = URI.create(this.getBaseUrl() + "v1/commands/products/" + nonExistingId);

        ResponseEntity<String> response = testRestTemplate.exchange(deleteUrl, HttpMethod.DELETE, null, String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}