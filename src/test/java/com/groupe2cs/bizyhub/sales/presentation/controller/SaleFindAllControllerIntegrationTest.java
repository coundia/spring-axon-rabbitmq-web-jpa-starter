package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.command.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class SaleFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private SaleRepository saleRepository;

@Test
void it_should_be_able_to_get_all_sales() {
SaleFixtures.randomMany(saleRepository, 5);

String uri = "/v1/queries/list-sale";
ResponseEntity<SalePagedResponse> response = this.getForEntity(uri, SalePagedResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getContent()).isNotEmpty();
	}
}
