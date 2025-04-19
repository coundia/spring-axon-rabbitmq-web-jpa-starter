package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionRequest;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_update_transaction() {

		String existingId = TransactionFixtures.randomOneViaCommand(commandGateway);

		TransactionRequest requestDTO = TransactionRequest.random();

		String uri = "/v1/commands/transaction/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		Transaction found = TransactionFixtures.byIdWaitExist(transactionRepository, existingId);
		assertThat(found).isNotNull();
		assertThat(found.getReference()).isEqualTo(requestDTO.getReference());
		assertThat(found.getAmount()).isEqualTo(requestDTO.getAmount());

	}
}
