package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.BalanceFixtures;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private BalanceRepository balanceRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_delete_balance() {
		String existingId = BalanceFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		BalanceFixtures.byIdWaitExist(balanceRepository, existingId);

		String uri = "/v1/commands/balance/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Balance found = BalanceFixtures.byIdWaitNotExist(balanceRepository, existingId);
		assertThat(found).isNull();
	}
}
