package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.command.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;

public class SaleFindByIdControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private SaleRepository saleRepository;

@Test
void it_should_be_able_to_get_sale_by_id() {
Sale entity = SaleFixtures.randomOne(saleRepository);
String existingId = entity.getId();

String uri = "/v1/queries/sale/by-id?id=" + existingId;
ResponseEntity<SaleResponse> response = this.getForEntity(uri, SaleResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
