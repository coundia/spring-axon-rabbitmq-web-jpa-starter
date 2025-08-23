package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeRequest;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCode;
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

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthVerificationCodeControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	VerificationCodeRepository verificationCodeRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_request_code_create_user_and_mask_code() {
		VerificationCodeRequest req = new VerificationCodeRequest();
		req.setUsername("it_user@example.com");
		req.setEmail("it_user@example.com");
		ResponseEntity<VerificationCodeResponse>
				resp =
				postForEntity("/auth/request-code", req, VerificationCodeResponse.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(resp.getBody()).isNotNull();
		assertThat(resp.getBody().getUsername()).isEqualTo("it_user@example.com");
		assertThat(resp.getBody().getCode()).isEqualTo(" ***** ");
		VerificationCode
				vc =
				verificationCodeRepository.findAll().stream().filter(v -> "it_user@example.com".equals(v.getUsername()))
						.reduce((a, b) -> b).orElse(null);
		assertThat(vc).isNotNull();
		User u = userRepository.findFirstByUsernameAndTenantId("it_user@example.com", getTenantId()).orElse(null);
		assertThat(u).isNotNull();
	}

	@Test
	void it_should_verify_code_and_return_token() {

		String existingId = VerificationCodeFixtures.randomOneViaCommand(
				commandGateway,
				verificationCodeRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		VerificationCodeFixtures.byIdWaitExist(verificationCodeRepository, existingId);

		String username = verificationCodeRepository.findById(existingId).orElseThrow().getUsername();

		String code = verificationCodeRepository.findById(existingId).orElseThrow().getCode();

		VerificationCodeRequest check = new VerificationCodeRequest();
		check.setUsername(username);
		check.setUsername(code);


		ResponseEntity<AuthResponseDto> ok = postForEntity("/auth/check-code", check, AuthResponseDto.class);
		assertThat(ok.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(ok.getBody()).isNotNull();
		assertThat(ok.getBody().getCode()).isEqualTo(1);
		assertThat(ok.getBody().getToken()).isNotBlank();
		assertThat(ok.getBody().getUsername()).isEqualTo(username);

		ResponseEntity<AuthResponseDto> ko = postForEntity("/auth/check-code", check, AuthResponseDto.class);
		assertThat(ko.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

		User u = userRepository.findFirstByUsernameAndTenantId(username, getTenantId()).orElse(null);
		assertThat(u).isNotNull();
	}


}
