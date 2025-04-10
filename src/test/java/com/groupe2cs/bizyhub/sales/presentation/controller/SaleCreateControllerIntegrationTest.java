package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.command.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.Assertions.assertThat;

public class SaleCreateControllerIntegrationTest extends BaseIntegrationTests {

@Test
void it_should_be_able_to_add_sale() {
SaleRequest requestDTO = SaleRequest.random();

MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
body.add("metadata", requestDTO);
body.add("facture", createFile());

HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.MULTIPART_FORM_DATA);

HttpEntity<MultiValueMap<String, Object>> request =
new HttpEntity<>(body, headers);

String uri = "/v1/commands/sale";
ResponseEntity<SaleResponse> response =
	this.postForEntity(uri, request, SaleResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isNotNull();
	assertThat(response.getBody().getQuantity())
	.isEqualTo(requestDTO.getQuantity());
	assertThat(response.getBody().getTotal_price())
	.isEqualTo(requestDTO.getTotal_price());

	}

}
