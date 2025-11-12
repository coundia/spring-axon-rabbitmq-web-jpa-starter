package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.command.CreateVerificationCodeCommand;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCodeFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.VerificationCodeRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class VerificationCodeUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private VerificationCodeRepository verificationcodeRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_verificationcode() {

		String existingId = VerificationCodeFixtures.randomOneViaCommand(
				commandGateway, verificationcodeRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		).getId().value();

		CreateVerificationCodeCommand updated = VerificationCodeFixtures.randomOneViaCommand(
				commandGatewayUpdate, verificationcodeRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		);

		VerificationCodeFixtures.byIdWaitExist(verificationcodeRepository, existingId);
		VerificationCodeFixtures.byIdWaitExist(verificationcodeRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("notes", UUID.randomUUID().toString());
		body.add("token", UUID.randomUUID().toString());
		body.add("username", UUID.randomUUID().toString());
		body.add("phone", UUID.randomUUID().toString());
		body.add("email", UUID.randomUUID().toString());
		body.add("code", UUID.randomUUID().toString());
		body.add("status", UUID.randomUUID().toString());
		body.add("source", UUID.randomUUID().toString());
		body.add("expiration", java.time.Instant.now().plusSeconds(3600));

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/commands/verificationCode/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
