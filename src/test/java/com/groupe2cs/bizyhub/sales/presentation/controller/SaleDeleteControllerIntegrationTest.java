package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import com.groupe2cs.bizyhub.sales.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class SaleDeleteControllerIntegrationTest extends BaseIntegrationTests {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CommandGateway commandGateway;

    @Test
    void it_should_be_able_to_delete_sale() {
        String existingId = SaleFixtures.randomOneViaCommand(commandGateway);
        String uri = "/v1/commands/sale/" + existingId;

        ResponseEntity<String> rep = this.delete(uri);
        assertThat(rep.getStatusCode().value()).isEqualTo(200);

        Sale found = SaleFixtures.byId(saleRepository, existingId);
        assertThat(found).isNull();
    }
}
