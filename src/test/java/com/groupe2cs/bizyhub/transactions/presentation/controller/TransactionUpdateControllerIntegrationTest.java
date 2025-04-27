package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
import com.groupe2cs.bizyhub.tenant.presentation.controller.TenantFixtures;
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

	String existingId = TransactionFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();
	CreateTransactionCommand updated = TransactionFixtures.randomOneViaCommand(commandGatewayUpdate, getUserId());

	TransactionFixtures.byIdWaitExist(transactionRepository, existingId);
	TransactionFixtures.byIdWaitExist(transactionRepository, updated.getId().value());

	TransactionRequest requestDTO = new TransactionRequest();
	 requestDTO.setReference(UUID.randomUUID().toString());
	 requestDTO.setAmount(4256.03);

	String uri = "/v1/commands/transaction/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
