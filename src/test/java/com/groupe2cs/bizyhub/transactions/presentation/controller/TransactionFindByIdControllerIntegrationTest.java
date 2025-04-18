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
