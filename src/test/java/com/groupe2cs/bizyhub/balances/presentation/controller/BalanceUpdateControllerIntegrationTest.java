package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.balances.application.command.CreateBalanceCommand;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceRequest;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.BalanceFixtures;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private BalanceRepository balanceRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;


	@Test
	void it_should_be_able_to_update_balance() {

		String existingId = BalanceFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();
		CreateBalanceCommand updated = BalanceFixtures.randomOneViaCommand(commandGatewayUpdate, getCurrentUser());

		BalanceFixtures.byIdWaitExist(balanceRepository, existingId);
		BalanceFixtures.byIdWaitExist(balanceRepository, updated.getId().value());

		BalanceRequest requestDTO = new BalanceRequest();
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setCurrency(UUID.randomUUID().toString());
		requestDTO.setCurrentBalance(5408.78);
		requestDTO.setPreviousBalance(8759.62);
		requestDTO.setLastUpdated(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setIsDefault(true);
		requestDTO.setOrdre(49);
		requestDTO.setIsArchived(true);
		requestDTO.setIsAllowDebit(false);
		requestDTO.setIsAllowCredit(true);
		requestDTO.setIsExcluTotal(false);
		requestDTO.setActivateNotification(false);
		requestDTO.setSyncedAt(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/commands/balance/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
