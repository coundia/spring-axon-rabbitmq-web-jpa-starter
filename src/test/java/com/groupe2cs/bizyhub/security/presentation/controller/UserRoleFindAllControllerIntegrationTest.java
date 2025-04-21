package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.UserRolePagedResponse;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRoleRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRoleFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private UserRoleRepository userroleRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_be_able_to_get_all_userroles() {
		List<?> list = UserRoleFixtures.randomManyViaCommand(commandGateway, 5);

		String uri = "/v1/queries/userRoles";
		ResponseEntity<UserRolePagedResponse> response = this.getForEntity(uri, UserRolePagedResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getContent()).isNotEmpty();
	}
}
