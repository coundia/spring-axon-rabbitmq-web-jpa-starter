package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.SaleRequest;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import com.groupe2cs.bizyhub.sales.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        ResponseEntity<String> response = this.put(uri, request);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Sale found = SaleFixtures.byId(saleRepository, existingId);
        assertThat(found).isNotNull();
        assertThat(found.getQuantity()).isEqualTo(requestDTO.getQuantity());
        assertThat(found.getTotal_price()).isEqualTo(requestDTO.getTotal_price());
    }
}
