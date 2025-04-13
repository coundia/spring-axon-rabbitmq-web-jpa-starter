package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.shared.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.products.application.command.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductFindByIdControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private ProductRepository productRepository;

@Test
void it_should_be_able_to_get_product_by_id() {
	Product entity = ProductFixtures.randomOne(productRepository);
	String existingId = entity.getId();

	String uri = "/v1/queries/product/by-id?id=" + existingId;
	ResponseEntity<ProductResponse> response = this.getForEntity(uri, ProductResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
