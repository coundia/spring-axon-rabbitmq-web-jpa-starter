package com.groupe2cs.bizyhub.transactions.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionCreateControllerIntegrationTest extends BaseIntegrationTests {

@Test
void it_should_be_able_to_add_transaction() {
TransactionRequest requestDTO = TransactionRequest.random();
HttpEntity<TransactionRequest> request = new HttpEntity<>(requestDTO);

		String uri = "/v1/commands/transaction";
		ResponseEntity<TransactionResponse> response = this.postForEntity(uri, request, TransactionResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getReference()).isEqualTo(requestDTO.getReference());
		assertThat(response.getBody().getAmount()).isEqualTo(requestDTO.getAmount());
	}
}
