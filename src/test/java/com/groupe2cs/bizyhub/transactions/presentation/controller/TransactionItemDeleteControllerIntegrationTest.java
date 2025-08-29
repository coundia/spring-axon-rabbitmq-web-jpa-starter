package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItem;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItemFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionItemRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionItemDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TransactionItemRepository transactionitemRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_transactionitem() {
		String existingId = TransactionItemFixtures.randomOneViaCommand(commandGateway, transactionitemRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		TransactionItemFixtures.byIdWaitExist(transactionitemRepository, existingId);

		String uri = "/v1/commands/transactionItem/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		TransactionItem found = TransactionItemFixtures.byIdWaitNotExist(transactionitemRepository, existingId);
		assertThat(found).isNull();
	}
}
