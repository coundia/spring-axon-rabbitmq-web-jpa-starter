package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserRequest;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserResponse;
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

public class AccountUserCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
	@Autowired
	private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_accountuser() {

		AccountUserRequest requestDTO = new AccountUserRequest();

		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setAccount(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(
				commandGateway,
				accountDataRepository,
				user).getId().value());
		requestDTO.setUser(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(
				commandGateway,
				userDataRepository,
				user).getId().value());
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(true);
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

		String uri = "/v1/commands/accountUser";
		ResponseEntity<AccountUserResponse> response = this.postForEntity(uri, requestDTO, AccountUserResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getUser()).isEqualTo(requestDTO.getUser());
		assertThat(response.getBody().getUsername()).isEqualTo(requestDTO.getUsername());
		assertThat(response.getBody().getDetails()).isEqualTo(requestDTO.getDetails());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
		assertThat(response.getBody().getUpdatedAt()).isEqualTo(requestDTO.getUpdatedAt());
		assertThat(response.getBody().getReference()).isEqualTo(requestDTO.getReference());
	}
}
