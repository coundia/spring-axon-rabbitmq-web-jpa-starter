package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.sync.application.dto.SyncStateResponse;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncStateFixtures;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.SyncStateRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class SyncStateFindByIdControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private SyncStateRepository repository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_get_syncstate_by_id() {

		String existingId = SyncStateFixtures.randomOneViaCommand(
				commandGateway, repository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		SyncStateFixtures.byIdWaitExist(repository, existingId);

		String uri = "/v1/queries/syncState/id?id=" + existingId;
		ResponseEntity<SyncStateResponse> response = this.getForEntity(uri, SyncStateResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
