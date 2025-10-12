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
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_transaction() {

		TransactionRequest requestDTO = new TransactionRequest();

		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setCode(UUID.randomUUID().toString());
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setAmount(5840.54);
		requestDTO.setTypeEntry(UUID.randomUUID().toString());
		requestDTO.setDateTransaction(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setEntityName(UUID.randomUUID().toString());
		requestDTO.setEntityId(UUID.randomUUID().toString());
		requestDTO.setAccount(UUID.randomUUID().toString());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setCategory(UUID.randomUUID().toString());
		requestDTO.setCompany(UUID.randomUUID().toString());
		requestDTO.setCustomer(UUID.randomUUID().toString());
		requestDTO.setDebt(UUID.randomUUID().toString());

		String uri = "/v1/commands/transaction";
		ResponseEntity<TransactionResponse> response = this.postForEntity(uri, requestDTO, TransactionResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getCode()).isEqualTo(requestDTO.getCode());
		assertThat(response.getBody().getDescription()).isEqualTo(requestDTO.getDescription());
		assertThat(response.getBody().getAmount()).isEqualTo(requestDTO.getAmount());
		assertThat(response.getBody().getTypeEntry()).isEqualTo(requestDTO.getTypeEntry());
		assertThat(response.getBody().getDateTransaction()).isEqualTo(requestDTO.getDateTransaction());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getEntityName()).isEqualTo(requestDTO.getEntityName());
		assertThat(response.getBody().getEntityId()).isEqualTo(requestDTO.getEntityId());
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getCategory()).isEqualTo(requestDTO.getCategory());
		assertThat(response.getBody().getCompany()).isEqualTo(requestDTO.getCompany());
		assertThat(response.getBody().getCustomer()).isEqualTo(requestDTO.getCustomer());
		assertThat(response.getBody().getDebt()).isEqualTo(requestDTO.getDebt());
	}
}
