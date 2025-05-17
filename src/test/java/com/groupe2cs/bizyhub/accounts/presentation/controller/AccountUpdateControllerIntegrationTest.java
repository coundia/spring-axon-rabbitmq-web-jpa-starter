package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountCommand;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountRequest;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_account() {

		String existingId = AccountFixtures.randomOneViaCommand(
				commandGateway, accountRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		CreateAccountCommand updated = AccountFixtures.randomOneViaCommand(commandGatewayUpdate,
				accountRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser());

		AccountFixtures.byIdWaitExist(accountRepository, existingId);
		AccountFixtures.byIdWaitExist(accountRepository, updated.getId().value());

		AccountRequest requestDTO = new AccountRequest();
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setCurrency(UUID.randomUUID().toString());
		requestDTO.setCurrentBalance(4634.42);
		requestDTO.setPreviousBalance(5169.81);
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(false);
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

		String uri = "/v1/commands/account/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
