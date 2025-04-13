package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.shared.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.products.application.command.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class ProductFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private ProductRepository productRepository;

@Test
void it_should_be_able_to_get_all_products() {
	ProductFixtures.randomMany(productRepository, 5);

	String uri = "/v1/queries/list-product";
	ResponseEntity<ProductPagedResponse> response = this.getForEntity(uri, ProductPagedResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getContent()).isNotEmpty();
	}
}
