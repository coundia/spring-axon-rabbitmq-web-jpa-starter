package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.command.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class SaleUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private SaleRepository saleRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_update_sale() {

String existingId = SaleFixtures.randomOneViaCommand(commandGateway);

SaleRequest requestDTO = SaleRequest.random();
HttpEntity<SaleRequest> request = new HttpEntity<>(requestDTO);

	String uri = "/v1/commands/sale/" + existingId;
	ResponseEntity<String> response = this.put(uri,request);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	Sale found = SaleFixtures.byId(saleRepository, existingId);
	assertThat(found).isNotNull();
			assertThat(found.getQuantity()).isEqualTo(requestDTO.getQuantity());
			assertThat(found.getTotal_price()).isEqualTo(requestDTO.getTotal_price());

	}
}
