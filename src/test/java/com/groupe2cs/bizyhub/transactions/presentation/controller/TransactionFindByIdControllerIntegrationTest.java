package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TransactionRepository transactionRepository;

	@Test
	void it_should_be_able_to_get_transaction_by_id() {
		Transaction entity = TransactionFixtures.randomOne(transactionRepository);
		String existingId = entity.getId();

		String uri = "/v1/queries/transaction/by-id?id=" + existingId;
		ResponseEntity<TransactionResponse> response = this.getForEntity(uri, TransactionResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
