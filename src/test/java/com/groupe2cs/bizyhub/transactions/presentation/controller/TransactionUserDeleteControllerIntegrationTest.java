package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionUser;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionUserFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionUserRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionUserDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TransactionUserRepository transactionuserRepository;

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
	void it_should_be_able_to_delete_transactionuser() {
		String existingId = TransactionUserFixtures.randomOneViaCommand(commandGateway, transactionuserRepository,
				transactionDataRepository,
				userDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		TransactionUserFixtures.byIdWaitExist(transactionuserRepository, existingId);

		String uri = "/v1/commands/transactionUser/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		TransactionUser found = TransactionUserFixtures.byIdWaitNotExist(transactionuserRepository, existingId);
		assertThat(found).isNull();
	}
}
