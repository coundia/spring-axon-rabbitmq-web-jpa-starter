package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
import com.groupe2cs.bizyhub.security.infrastructure.entity.RoleFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RoleRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_delete_role() {
		String existingId = RoleFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		RoleFixtures.byIdWaitExist(roleRepository, existingId);

		String uri = "/v1/admin/commands/role/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Role found = RoleFixtures.byIdWaitNotExist(roleRepository, existingId);
		assertThat(found).isNull();
	}
}
