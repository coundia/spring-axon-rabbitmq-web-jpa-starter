package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionUserCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository
			transactionDataRepository;
	@Autowired
	private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_transactionuser() {

		TransactionUserRequest requestDTO = new TransactionUserRequest();

		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setTransaction(com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures.randomOneViaCommand(
				commandGateway,
				transactionDataRepository,
				user).getId().value());
		requestDTO.setUser(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(
				commandGateway,
				userDataRepository,
				user).getId().value());
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(false);

		String uri = "/v1/commands/transactionUser";
		ResponseEntity<TransactionUserResponse>
				response =
				this.postForEntity(uri, requestDTO, TransactionUserResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getTransaction()).isEqualTo(requestDTO.getTransaction());
		assertThat(response.getBody().getUser()).isEqualTo(requestDTO.getUser());
		assertThat(response.getBody().getUsername()).isEqualTo(requestDTO.getUsername());
		assertThat(response.getBody().getDetails()).isEqualTo(requestDTO.getDetails());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
	}
}
