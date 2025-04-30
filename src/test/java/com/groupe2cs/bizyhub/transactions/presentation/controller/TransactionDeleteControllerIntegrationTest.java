package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_delete_transaction() {
		String existingId = TransactionFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		TransactionFixtures.byIdWaitExist(transactionRepository, existingId);

		String uri = "/v1/commands/transaction/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Transaction found = TransactionFixtures.byIdWaitNotExist(transactionRepository, existingId);
		assertThat(found).isNull();
	}
}
