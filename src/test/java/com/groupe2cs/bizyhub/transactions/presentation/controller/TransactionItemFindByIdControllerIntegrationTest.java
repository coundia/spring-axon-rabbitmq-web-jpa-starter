package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemResponse;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItemFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionItemRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionItemFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private TransactionItemRepository repository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_get_transactionitem_by_id() {

		String existingId = TransactionItemFixtures.randomOneViaCommand(
				commandGateway, repository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		TransactionItemFixtures.byIdWaitExist(repository, existingId);

		String uri = "/v1/queries/transactionItem/id?id=" + existingId;
		ResponseEntity<TransactionItemResponse> response = this.getForEntity(uri, TransactionItemResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
