package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserRequest;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUserFixtures;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountUserRepository;
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

public class AccountUserUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private AccountUserRepository accountuserRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
	@Autowired
	private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_accountuser() {

		String existingId = AccountUserFixtures.randomOneViaCommand(
				commandGateway, accountuserRepository,
				accountDataRepository,
				userDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		CreateAccountUserCommand updated = AccountUserFixtures.randomOneViaCommand(commandGatewayUpdate,
				accountuserRepository,
				accountDataRepository,
				userDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser());

		AccountUserFixtures.byIdWaitExist(accountuserRepository, existingId);
		AccountUserFixtures.byIdWaitExist(accountuserRepository, updated.getId().value());

		AccountUserRequest requestDTO = new AccountUserRequest();
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setAccount(updated.getAccount().value());
		requestDTO.setUser(updated.getUser().value());
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(false);
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

		String uri = "/v1/commands/accountUser/" + existingId;
		ResponseEntity<String> response = this.put(uri, requestDTO);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
