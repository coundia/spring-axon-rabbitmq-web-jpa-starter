package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.application.dto.UserPagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class UserFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private UserRepository userRepository;

	@Test
	void it_should_return_only_user_users_for_normal_user() throws Exception {

		List<CreateUserCommand> userCommands =
				UserFixtures.randomManyViaCommand(commandGateway, 3, login("user", "user"));
		userCommands.forEach(cmd ->
				UserFixtures.byIdWaitExist(userRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<UserPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/users?page=0&limit=1000000",
				UserPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

	}

	@Test
	void it_should_return_all_users_for_admin() throws Exception {

		List<CreateUserCommand> userCommands =
				UserFixtures.randomManyViaCommand(commandGateway, 5, login("user", "user"));
		userCommands.forEach(cmd ->
				UserFixtures.byIdWaitExist(userRepository, cmd.getId().value())
		);


		List<CreateUserCommand> adminCommands =
				UserFixtures.randomManyViaCommand(commandGateway, 5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				UserFixtures.byIdWaitExist(userRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<UserPagedResponse> response = this.getForEntity(
				"/v1/admin/queries/users?page=0&limit=1000000",
				UserPagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<UserResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(UserResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
