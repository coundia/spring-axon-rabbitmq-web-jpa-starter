package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserResponse;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionUserFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionUserRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionUserFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private TransactionUserRepository repository;

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
	void it_should_be_able_to_get_transactionuser_by_id() {

		String existingId = TransactionUserFixtures.randomOneViaCommand(
				commandGateway, repository,
				transactionDataRepository,
				userDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		TransactionUserFixtures.byIdWaitExist(repository, existingId);

		String uri = "/v1/queries/transactionUser/id?id=" + existingId;
		ResponseEntity<TransactionUserResponse> response = this.getForEntity(uri, TransactionUserResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
