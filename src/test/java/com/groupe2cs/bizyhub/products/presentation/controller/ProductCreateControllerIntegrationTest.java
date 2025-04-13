package com.groupe2cs.bizyhub.products.presentation.controller;
import com.groupe2cs.bizyhub.products.shared.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.products.application.command.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductCreateControllerIntegrationTest extends BaseIntegrationTests {

@Test
void it_should_be_able_to_add_product() {
ProductRequest requestDTO = ProductRequest.random();
HttpEntity<ProductRequest> request = new HttpEntity<>(requestDTO);

		String uri = "/v1/commands/product";
		ResponseEntity<ProductResponse> response = this.postForEntity(uri, request, ProductResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getPrice()).isEqualTo(requestDTO.getPrice());
	}
}
