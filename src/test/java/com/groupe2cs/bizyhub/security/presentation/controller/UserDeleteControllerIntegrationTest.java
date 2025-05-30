package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_user() {
		String existingId = UserFixtures.randomOneViaCommand(commandGateway, userRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		UserFixtures.byIdWaitExist(userRepository, existingId);

		String uri = "/v1/admin/commands/user/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		User found = UserFixtures.byIdWaitNotExist(userRepository, existingId);
		assertThat(found).isNull();
	}
}
