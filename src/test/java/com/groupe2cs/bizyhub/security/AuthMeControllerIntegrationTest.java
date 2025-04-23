package com.groupe2cs.bizyhub.security;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthMeControllerIntegrationTest extends BaseIntegrationTests {


@Test
void it_should_return_authenticated_user_infos() {

ResponseEntity<Map> response = this.getForEntity("/auth/me", Map.class);
	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody()).containsKeys("data");
	assertThat(response.getBody().get("data")).isInstanceOf(Map.class);
	assertThat(((Map) response.getBody().get("data")).get("username")).isEqualTo("admin");
	assertThat(((Map) response.getBody().get("data")).get("roles")).isInstanceOf(java.util.ArrayList.class);
	assertThat(((Map) response.getBody().get("data")).get("authorities")).isInstanceOf(java.util.ArrayList.class);
	}
}
