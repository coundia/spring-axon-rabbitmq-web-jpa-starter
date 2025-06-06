package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountRequest;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountResponse;
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

public class AccountCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_account() {

		AccountRequest requestDTO = new AccountRequest();

		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setCurrency(UUID.randomUUID().toString());
		requestDTO.setCurrentBalance(5946.63);
		requestDTO.setPreviousBalance(6798.16);
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(false);

		String uri = "/v1/commands/account";
		ResponseEntity<AccountResponse> response = this.postForEntity(uri, requestDTO, AccountResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getCurrency()).isEqualTo(requestDTO.getCurrency());
		assertThat(response.getBody().getCurrentBalance()).isEqualTo(requestDTO.getCurrentBalance());
		assertThat(response.getBody().getPreviousBalance()).isEqualTo(requestDTO.getPreviousBalance());
		assertThat(response.getBody().getDetails()).isEqualTo(requestDTO.getDetails());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
	}
}
