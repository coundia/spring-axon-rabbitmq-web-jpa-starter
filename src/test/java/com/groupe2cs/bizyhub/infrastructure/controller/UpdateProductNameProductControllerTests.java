package com.groupe2cs.bizyhub.infrastructure.controller;

import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateProductNameProductControllerTests extends BaseIntegrationTests {

    @Test
    void it_should_be_able_to_update_name_of_product() {
        String id = UUID.randomUUID().toString();
        String productName = "test product";
        double productPrice = 30.0;
        Product savedProduct = new Product(id, productName, productPrice);
        productRepository.save(savedProduct);

        Map<String,String> requestBody = Map.of(
                "name", "test product to update"
        );

        HttpEntity<Map<String,String>> request = new HttpEntity<>(requestBody);

        URI url = URI.create(this.getBaseUrl() + "v1/commands/products/" + savedProduct.getId());
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.PUT, request,String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product updated successfully", response.getBody());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
