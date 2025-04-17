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

public class TransactionsUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private TransactionsRepository transactionsRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_update_transactions() {

String existingId = TransactionsFixtures.randomOneViaCommand(commandGateway);

TransactionsRequest requestDTO = TransactionsRequest.random();
HttpEntity<TransactionsRequest> request = new HttpEntity<>(requestDTO);

	String uri = "/v1/commands/transactions/" + existingId;
	ResponseEntity<String> response = this.put(uri,request);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	Transactions found = TransactionsFixtures.byIdWaitExist(transactionsRepository, existingId);
	assertThat(found).isNotNull();
			assertThat(found.getReference()).isEqualTo(requestDTO.getReference());
			assertThat(found.getAmount()).isEqualTo(requestDTO.getAmount());

	}
}
