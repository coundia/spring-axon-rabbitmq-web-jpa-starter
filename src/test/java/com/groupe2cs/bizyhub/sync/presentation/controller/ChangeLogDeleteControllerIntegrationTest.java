package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.ChangeLog;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.ChangeLogFixtures;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.ChangeLogRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeLogDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private ChangeLogRepository changelogRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_changelog() {
		String existingId = ChangeLogFixtures.randomOneViaCommand(commandGateway, changelogRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		ChangeLogFixtures.byIdWaitExist(changelogRepository, existingId);

		String uri = "/v1/commands/changeLog/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		ChangeLog found = ChangeLogFixtures.byIdWaitNotExist(changelogRepository, existingId);
		assertThat(found).isNull();
	}
}
