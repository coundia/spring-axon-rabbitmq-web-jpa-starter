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

		requestDTO.setAmount(471.14);
		requestDTO.setDateOperation(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setReference(UUID.randomUUID().toString());
		requestDTO.setIsRecurring(true);
		requestDTO.setIsExcluToRapport(true);
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setBalance(com.groupe2cs.bizyhub.balances.infrastructure.entity.BalanceFixtures.randomOneViaCommand(
				commandGateway,
				user).getId().value());
		requestDTO.setCategory(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(
				commandGateway,
				user).getId().value());
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setCreatedAt(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/commands/transaction";
		ResponseEntity<TransactionResponse> response = this.postForEntity(uri, requestDTO, TransactionResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getAmount()).isEqualTo(requestDTO.getAmount());
		assertThat(response.getBody().getDateOperation()).isEqualTo(requestDTO.getDateOperation());
		assertThat(response.getBody().getDescription()).isEqualTo(requestDTO.getDescription());
		assertThat(response.getBody().getReference()).isEqualTo(requestDTO.getReference());
		assertThat(response.getBody().getIsRecurring()).isEqualTo(requestDTO.getIsRecurring());
		assertThat(response.getBody().getIsExcluToRapport()).isEqualTo(requestDTO.getIsExcluToRapport());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getBalance()).isEqualTo(requestDTO.getBalance());
		assertThat(response.getBody().getCategory()).isEqualTo(requestDTO.getCategory());
		assertThat(response.getBody().getUpdatedAt()).isEqualTo(requestDTO.getUpdatedAt());
		assertThat(response.getBody().getCreatedAt()).isEqualTo(requestDTO.getCreatedAt());
	}
}
