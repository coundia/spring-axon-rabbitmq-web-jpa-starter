package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateVerificationCodeCommand;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodePagedResponse;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCodeFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.VerificationCodeRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class VerificationCodeFindAllControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private VerificationCodeRepository verificationCodeRepository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_return_only_user_verificationCodes_for_normal_user() throws Exception {

		List<CreateVerificationCodeCommand> userCommands =
				VerificationCodeFixtures.randomManyViaCommand(
						commandGateway, verificationCodeRepository,
						createdByDataRepository,
						tenantDataRepository,
						3, login("user", "user"));
		userCommands.forEach(cmd ->
				VerificationCodeFixtures.byIdWaitExist(verificationCodeRepository, cmd.getId().value())
		);

		login("user", "user");
		ResponseEntity<VerificationCodePagedResponse> response = this.getForEntity(
				"/v1/queries/verificationCodes?page=0&limit=1000000",
				VerificationCodePagedResponse.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<VerificationCodeResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(VerificationCodeResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);
	}

	@Test
	void it_should_return_all_verificationCodes_for_admin() throws Exception {

		List<CreateVerificationCodeCommand> userCommands =
				VerificationCodeFixtures.randomManyViaCommand(
						commandGateway,
						verificationCodeRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("user", "user")
				);
		userCommands.forEach(cmd ->
				VerificationCodeFixtures.byIdWaitExist(verificationCodeRepository, cmd.getId().value())
		);


		List<CreateVerificationCodeCommand> adminCommands =
				VerificationCodeFixtures.randomManyViaCommand(
						commandGateway, verificationCodeRepository,
						createdByDataRepository,
						tenantDataRepository,
						5, login("admin", "admin"));
		adminCommands.forEach(cmd ->
				VerificationCodeFixtures.byIdWaitExist(verificationCodeRepository, cmd.getId().value())
		);

		login("admin", "admin");
		ResponseEntity<VerificationCodePagedResponse> response = this.getForEntity(
				"/v1/queries/verificationCodes?page=0&limit=1000000",
				VerificationCodePagedResponse.class
		);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		List<VerificationCodeResponse> content = response.getBody().getContent();
		assertThat(content).isNotEmpty();

		List<String> expectedIds = userCommands.stream()
				.map(cmd -> cmd.getId().value())
				.collect(Collectors.toList());

		List<String> actualIds = content.stream()
				.map(VerificationCodeResponse::getId)
				.collect(Collectors.toList());

		assertThat(actualIds).containsAll(expectedIds);

	}
}
