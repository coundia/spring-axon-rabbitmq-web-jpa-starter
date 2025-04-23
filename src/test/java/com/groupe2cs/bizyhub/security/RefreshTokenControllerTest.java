package com.groupe2cs.bizyhub.security;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenDto;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class RefreshTokenControllerTest extends BaseIntegrationTests {


	@Test
	void it_should_return_new_token_when_refresh_token_valid() throws Exception {
		RefreshTokenDto dto = new RefreshTokenDto();
		dto.setRefreshToken("invalid-token");
		String uri = "/auth/refresh";
		ResponseEntity<PasswordResetResponse>
				response =
				this.postForEntity(uri, dto, PasswordResetResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}

	@Test
	void it_should_return_bad_request_when_refresh_token_invalid() throws Exception {
		RefreshTokenDto dto = new RefreshTokenDto();
		dto.setRefreshToken("invalid-token");
		String uri = "/auth/refresh";
		ResponseEntity<PasswordResetResponse>
				response =
				this.postForEntity(uri, dto, PasswordResetResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);


	}
}
