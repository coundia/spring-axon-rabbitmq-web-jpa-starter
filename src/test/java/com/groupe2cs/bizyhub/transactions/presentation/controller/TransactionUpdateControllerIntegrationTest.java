package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
	@Autowired
	private com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_transaction() {

		String existingId = TransactionFixtures.randomOneViaCommand(
				commandGateway, transactionRepository,
				accountDataRepository,
				categoryDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		).getId().value();

		CreateTransactionCommand updated = TransactionFixtures.randomOneViaCommand(
				commandGatewayUpdate, transactionRepository,
				accountDataRepository,
				categoryDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		);

		TransactionFixtures.byIdWaitExist(transactionRepository, existingId);
		TransactionFixtures.byIdWaitExist(transactionRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("name", UUID.randomUUID().toString());
		body.add("amount", 9720.04);
		body.add("details", UUID.randomUUID().toString());
		body.add("isActive", true);
		body.add("account", updated.getAccount().value());
		body.add("category", updated.getCategory().value());
		body.add("typeTransactionRaw", UUID.randomUUID().toString());
		body.add("dateTransaction", java.time.Instant.now().plusSeconds(3600));

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/commands/transaction/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
