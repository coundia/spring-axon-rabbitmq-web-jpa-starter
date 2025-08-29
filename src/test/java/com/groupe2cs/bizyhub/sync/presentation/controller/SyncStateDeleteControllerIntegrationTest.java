package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncState;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.SyncStateFixtures;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.SyncStateRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class SyncStateDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private SyncStateRepository syncstateRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_syncstate() {
		String existingId = SyncStateFixtures.randomOneViaCommand(commandGateway, syncstateRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		SyncStateFixtures.byIdWaitExist(syncstateRepository, existingId);

		String uri = "/v1/commands/syncState/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		SyncState found = SyncStateFixtures.byIdWaitNotExist(syncstateRepository, existingId);
		assertThat(found).isNull();
	}
}
