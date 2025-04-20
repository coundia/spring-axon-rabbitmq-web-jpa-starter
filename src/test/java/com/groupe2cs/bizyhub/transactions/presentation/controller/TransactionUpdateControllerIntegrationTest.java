package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
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

	String existingId = TransactionFixtures.randomOneViaCommand(commandGateway).getId().value();

	CreateTransactionCommand updated = TransactionFixtures.randomOneViaCommand(commandGatewayUpdate);

	TransactionRequest requestDTO = new TransactionRequest();
	 requestDTO.setReference(UUID.randomUUID().toString());
	 requestDTO.setAmount(8943.9);

	String uri = "/v1/commands/transaction/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	Transaction found = TransactionFixtures.byIdWaitExist(transactionRepository, existingId);
	assertThat(found).isNotNull();
			assertThat(found.getReference()).isEqualTo(requestDTO.getReference());
			assertThat(found.getAmount()).isEqualTo(requestDTO.getAmount());

	}
}
