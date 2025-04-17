package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class TransactionsFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private TransactionsRepository transactionsRepository;

@Test
void it_should_be_able_to_get_all_transactionss() {
	TransactionsFixtures.randomMany(transactionsRepository, 5);

	String uri = "/v1/queries/list-transactions";
	ResponseEntity<TransactionsPagedResponse> response = this.getForEntity(uri, TransactionsPagedResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getContent()).isNotEmpty();
	}
}
