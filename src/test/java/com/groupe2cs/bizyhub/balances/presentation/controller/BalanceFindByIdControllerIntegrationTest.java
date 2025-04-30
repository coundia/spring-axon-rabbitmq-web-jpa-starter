package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.BalanceFixtures;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private BalanceRepository repository;

	@Test
	void it_should_be_able_to_get_balance_by_id() {

		String existingId = BalanceFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		BalanceFixtures.byIdWaitExist(repository, existingId);

		String uri = "/v1/queries/balance/id?id=" + existingId;
		ResponseEntity<BalanceResponse> response = this.getForEntity(uri, BalanceResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
