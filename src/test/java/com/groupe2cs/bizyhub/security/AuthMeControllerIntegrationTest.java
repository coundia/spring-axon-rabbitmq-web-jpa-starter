package com.groupe2cs.bizyhub.security;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthMeControllerIntegrationTest extends BaseIntegrationTests {

	@Test
	void unauthenticated_should_be_unauthorized() {
		this.headers = new HttpHeaders();
		ResponseEntity<Map> response = this.getForEntity("/auth/me", Map.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}

	@Test
	void it_should_return_authenticated_user_infos() {
		ResponseEntity<Map> response = this.getForEntity("/auth/me", Map.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		Map<String, Object> body = response.getBody();
		assertThat(body).containsKeys("code", "message", "data");

		@SuppressWarnings("unchecked")
		Map<String, Object> data = (Map<String, Object>) body.get("data");

		assertThat(data.get("username")).isEqualTo("admin");
		assertThat(data.get("tenantId")).isNotNull();

		assertThat(data.get("roles")).isInstanceOf(List.class);
		assertThat(data.get("authorities")).isInstanceOf(List.class);

		List<String> roles = (List<String>) data.get("roles");
		assertThat(roles).contains("ROLE_ADMIN");
	}
}
