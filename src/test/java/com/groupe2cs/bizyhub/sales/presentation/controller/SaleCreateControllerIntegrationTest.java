package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.SaleRequest;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class SaleCreateControllerIntegrationTest extends BaseIntegrationTests {

    @Test
    void it_should_be_able_to_add_sale() {
        SaleRequest requestDTO = SaleRequest.random();
        HttpEntity<SaleRequest> request = new HttpEntity<>(requestDTO);

        String uri = "/v1/commands/sale";
        ResponseEntity<SaleResponse> response = this.postForEntity(uri, request, SaleResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getQuantity()).isEqualTo(requestDTO.getQuantity());
        assertThat(response.getBody().getTotal_price()).isEqualTo(requestDTO.getTotal_price());
        assertThat(response.getBody().getFacture()).isEqualTo(requestDTO.getFacture());
        assertThat(response.getBody().getProduct()).isEqualTo(requestDTO.getProduct());
    }
}
