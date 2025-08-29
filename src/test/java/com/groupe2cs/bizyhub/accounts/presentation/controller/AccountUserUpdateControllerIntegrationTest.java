package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUserFixtures;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountUserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountUserUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private AccountUserRepository accountuserRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_accountuser() {

		String existingId = AccountUserFixtures.randomOneViaCommand(
				commandGateway, accountuserRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		).getId().value();

		CreateAccountUserCommand updated = AccountUserFixtures.randomOneViaCommand(
				commandGatewayUpdate, accountuserRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		);

		AccountUserFixtures.byIdWaitExist(accountuserRepository, existingId);
		AccountUserFixtures.byIdWaitExist(accountuserRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("account", UUID.randomUUID().toString());
		body.add("user", UUID.randomUUID().toString());
		body.add("identity", UUID.randomUUID().toString());
		body.add("phone", UUID.randomUUID().toString());
		body.add("email", UUID.randomUUID().toString());
		body.add("role", UUID.randomUUID().toString());
		body.add("status", UUID.randomUUID().toString());
		body.add("invitedBy", UUID.randomUUID().toString());
		body.add("syncAt", java.time.Instant.now().plusSeconds(3600));
		body.add("acceptedAt", java.time.Instant.now().plusSeconds(3600));
		body.add("revokedAt", java.time.Instant.now().plusSeconds(3600));
		body.add("message", UUID.randomUUID().toString());
		body.add("remoteId", UUID.randomUUID().toString());
		body.add("localId", UUID.randomUUID().toString());
		body.add("isActive", true);

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/commands/accountUser/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
