package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUser;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUserFixtures;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountUserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountUserDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private AccountUserRepository accountuserRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_accountuser() {
		String existingId = AccountUserFixtures.randomOneViaCommand(commandGateway, accountuserRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		AccountUserFixtures.byIdWaitExist(accountuserRepository, existingId);

		String uri = "/v1/commands/accountUser/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		AccountUser found = AccountUserFixtures.byIdWaitNotExist(accountuserRepository, existingId);
		assertThat(found).isNull();
	}
}
