package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_account() {
		String existingId = AccountFixtures.randomOneViaCommand(commandGateway, accountRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		AccountFixtures.byIdWaitExist(accountRepository, existingId);

		String uri = "/v1/commands/account/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Account found = AccountFixtures.byIdWaitNotExist(accountRepository, existingId);
		assertThat(found).isNull();
	}
}
