package com.groupe2cs.bizyhub.infrastructure.controller;

import com.groupe2cs.bizyhub.products.application.Mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequestDTO;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponseDTO;
import com.groupe2cs.bizyhub.products.domain.aggregate.ProductAggregate;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class AddProductControllerTests extends BaseIntegrationTests {

    @Test
    void it_should_be_able_to_add_product() {
        ProductAggregate productModel = new ProductAggregate(
                ProductName.create("Product 1"),
                ProductPrice.create(1000)

        );

        ProductRequestDTO productRequestDTO = ProductMapper.toRequestDto(productModel);
        HttpEntity<ProductRequestDTO> request = new HttpEntity<>(productRequestDTO);

        String url = getBaseUrl() + "v1/commands/products";

        ResponseEntity<ProductResponseDTO> response = testRestTemplate.postForEntity(url, request, ProductResponseDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().id).isNotNull();
        assertThat(response.getBody().name).isEqualTo(productModel.getName().value());
        assertThat(response.getBody().price).isEqualTo(productModel.getPrice().value());
    }
}
