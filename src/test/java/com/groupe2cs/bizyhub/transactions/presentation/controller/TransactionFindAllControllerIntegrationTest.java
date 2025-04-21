package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionPagedResponse;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_get_all_transactions() {
		List<?> list = TransactionFixtures.randomManyViaCommand(commandGateway, 5);

		String uri = "/v1/queries/transactions";
		ResponseEntity<TransactionPagedResponse> response = this.getForEntity(uri, TransactionPagedResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getContent()).isNotEmpty();
	}
}
