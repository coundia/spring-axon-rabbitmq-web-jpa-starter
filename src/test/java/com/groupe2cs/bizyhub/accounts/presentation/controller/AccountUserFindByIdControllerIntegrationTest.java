package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserResponse;
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

import static org.assertj.core.api.Assertions.assertThat;

public class AccountUserFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private AccountUserRepository repository;

	@Autowired
	private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
	@Autowired
	private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_get_accountuser_by_id() {

		String existingId = AccountUserFixtures.randomOneViaCommand(
				commandGateway, repository,
				accountDataRepository,
				userDataRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		AccountUserFixtures.byIdWaitExist(repository, existingId);

		String uri = "/v1/queries/accountUser/id?id=" + existingId;
		ResponseEntity<AccountUserResponse> response = this.getForEntity(uri, AccountUserResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
