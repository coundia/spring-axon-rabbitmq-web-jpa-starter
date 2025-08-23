package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeRequest;
import com.groupe2cs.bizyhub.security.application.dto.VerificationCodeResponse;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.entity.VerificationCode;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.VerificationCodeRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Comparator;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthVerificationCodeControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	VerificationCodeRepository verificationCodeRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void it_should_request_code_create_user_and_mask_code() {
		VerificationCodeRequest req = new VerificationCodeRequest();
		req.setUsername("it_user@example.com");
		req.setEmail("it_user@example.com");
		ResponseEntity<VerificationCodeResponse> resp = postForEntity("/auth/request-code", req, VerificationCodeResponse.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(resp.getBody()).isNotNull();
		assertThat(resp.getBody().getUsername()).isEqualTo("it_user@example.com");
		assertThat(resp.getBody().getCode()).isEqualTo(" ***** ");

	}

	@Test
	void it_should_verify_code_and_return_token() {
		String username = "it_check@example.com";
		VerificationCode vc = VerificationCode.builder().id(UUID.randomUUID().toString()).username(username).code("654321").build();
		verificationCodeRepository.save(vc);
		VerificationCodeRequest req = new VerificationCodeRequest();
		req.setUsername(username);
		req.setCode("654321");
		ResponseEntity<AuthResponseDto> resp = postForEntity("/auth/check-code", req, AuthResponseDto.class);
		assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(resp.getBody()).isNotNull();
		assertThat(resp.getBody().getCode()).isEqualTo(1);
		assertThat(resp.getBody().getToken()).isNotBlank();
		assertThat(resp.getBody().getUsername()).isEqualTo(username);
		User u = userRepository.findFirstByUsernameAndTenantId(username, getTenantId()).orElse(null);
		assertThat(u).isNotNull();
	}
}
