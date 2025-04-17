package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionsFindByIdControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private TransactionsRepository transactionsRepository;

@Test
void it_should_be_able_to_get_transactions_by_id() {
	Transactions entity = TransactionsFixtures.randomOne(transactionsRepository);
	String existingId = entity.getId();

	String uri = "/v1/queries/transactions/by-id?id=" + existingId;
	ResponseEntity<TransactionsResponse> response = this.getForEntity(uri, TransactionsResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
