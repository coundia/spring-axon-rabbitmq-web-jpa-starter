package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeRequest;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class VerificationCodeCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_verificationcode() {

		VerificationCodeRequest requestDTO = new VerificationCodeRequest();

		requestDTO.setNotes(UUID.randomUUID().toString());
		requestDTO.setToken(UUID.randomUUID().toString());
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setPhone(UUID.randomUUID().toString());
		requestDTO.setEmail(UUID.randomUUID().toString());
		requestDTO.setCode(UUID.randomUUID().toString());
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setSource(UUID.randomUUID().toString());
		requestDTO.setExpiration(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/commands/verificationCode";
		ResponseEntity<VerificationCodeResponse>
				response =
				this.postForEntity(uri, requestDTO, VerificationCodeResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getNotes()).isEqualTo(requestDTO.getNotes());
		assertThat(response.getBody().getToken()).isEqualTo(requestDTO.getToken());
		assertThat(response.getBody().getUsername()).isEqualTo(requestDTO.getUsername());
		assertThat(response.getBody().getPhone()).isEqualTo(requestDTO.getPhone());
		assertThat(response.getBody().getEmail()).isEqualTo(requestDTO.getEmail());
		assertThat(response.getBody().getCode()).isEqualTo(requestDTO.getCode());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getSource()).isEqualTo(requestDTO.getSource());
		assertThat(response.getBody().getExpiration()).isEqualTo(requestDTO.getExpiration());
	}
}
