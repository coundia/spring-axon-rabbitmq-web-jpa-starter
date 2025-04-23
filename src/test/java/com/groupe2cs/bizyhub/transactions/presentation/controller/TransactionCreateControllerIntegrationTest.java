package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_add_transaction() {

		TransactionRequest requestDTO = new TransactionRequest();

		requestDTO.setReference(UUID.randomUUID().toString());
	requestDTO.setAmount(1295.66);

 		String uri = "/v1/commands/transaction";
		ResponseEntity<TransactionResponse> response = this.postForEntity(uri, requestDTO, TransactionResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getReference()).isEqualTo(requestDTO.getReference());
		assertThat(response.getBody().getAmount()).isEqualTo(requestDTO.getAmount());
	}
}
