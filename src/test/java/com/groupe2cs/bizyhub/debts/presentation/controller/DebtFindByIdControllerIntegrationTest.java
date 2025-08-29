package com.groupe2cs.bizyhub.debts.presentation.controller;

import com.groupe2cs.bizyhub.debts.application.dto.DebtResponse;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.DebtFixtures;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class DebtFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private DebtRepository repository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_get_debt_by_id() {

		String existingId = DebtFixtures.randomOneViaCommand(
				commandGateway, repository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		DebtFixtures.byIdWaitExist(repository, existingId);

		String uri = "/v1/queries/debt/id?id=" + existingId;
		ResponseEntity<DebtResponse> response = this.getForEntity(uri, DebtResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
