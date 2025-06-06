package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
	@Autowired
	private com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_transaction() {

		TransactionRequest requestDTO = new TransactionRequest();

		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setAmount(9717.32);
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(true);
		requestDTO.setAccount(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(
				commandGateway,
				accountDataRepository,
				user).getId().value());
		requestDTO.setCategory(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(
				commandGateway,
				categoryDataRepository,
				user).getId().value());
		requestDTO.setTypeTransactionRaw(UUID.randomUUID().toString());
		requestDTO.setDateTransaction(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/commands/transaction";
		ResponseEntity<TransactionResponse> response = this.postForEntity(uri, requestDTO, TransactionResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getAmount()).isEqualTo(requestDTO.getAmount());
		assertThat(response.getBody().getDetails()).isEqualTo(requestDTO.getDetails());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getCategory()).isEqualTo(requestDTO.getCategory());
		assertThat(response.getBody().getTypeTransactionRaw()).isEqualTo(requestDTO.getTypeTransactionRaw());
		assertThat(response.getBody().getDateTransaction()).isEqualTo(requestDTO.getDateTransaction());
	}
}
