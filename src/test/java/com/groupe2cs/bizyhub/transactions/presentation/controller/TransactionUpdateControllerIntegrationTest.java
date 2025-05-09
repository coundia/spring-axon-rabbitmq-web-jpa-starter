package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionRequest;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_transaction() {

		String existingId = TransactionFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();
		CreateTransactionCommand
				updated =
				TransactionFixtures.randomOneViaCommand(commandGatewayUpdate, getCurrentUser());

		TransactionFixtures.byIdWaitExist(transactionRepository, existingId);
		TransactionFixtures.byIdWaitExist(transactionRepository, updated.getId().value());

		TransactionRequest requestDTO = new TransactionRequest();
		requestDTO.setAmount(1779.62);
		requestDTO.setDateOperation(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setReference(UUID.randomUUID().toString());
		requestDTO.setIsRecurring(true);
		requestDTO.setIsExcluToRapport(true);
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setBalance(updated.getBalance().value());
		requestDTO.setCategory(updated.getCategory().value());
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setCreatedAt(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/commands/transaction/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
