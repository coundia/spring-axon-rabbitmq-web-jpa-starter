package com.groupe2cs.bizyhub.security;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class RefreshTokenControllerTest extends BaseIntegrationTests {

@Test
void it_should_return_new_token_when_refresh_token_valid() {

AuthRequestDto authRequest = new AuthRequestDto();

ResponseEntity<AuthResponseDto> refreshResponse = this.postForEntity("/auth/refresh", authRequest, AuthResponseDto.class);

	assertThat(refreshResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(refreshResponse.getBody()).isNotNull();
	assertThat(refreshResponse.getBody().getCode()).isEqualTo(1);
	assertThat(refreshResponse.getBody().getToken()).isNotNull();
	assertThat(refreshResponse.getBody().getUsername()).isEqualTo("admin");
	assertThat(refreshResponse.getBody().getExpirationAt()).isNotNull();
	}

	@Test
	void it_should_return_bad_request_when_refresh_token_invalid() {
	headers.setBearerAuth("invalid-token");

	ResponseEntity<AuthResponseDto> refreshResponse = this.postForEntity("/auth/refresh", null, AuthResponseDto.class);

		assertThat(refreshResponse.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
		}
		}
