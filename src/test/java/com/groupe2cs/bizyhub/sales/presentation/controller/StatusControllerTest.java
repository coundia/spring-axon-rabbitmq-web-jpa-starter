package com.groupe2cs.bizyhub.sales.presentation.controller;
	import com.groupe2cs.bizyhub.sales.shared.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class StatusControllerTest extends BaseIntegrationTests {

@Test
void it_should_status() {
ResponseEntity<String> response = this.get("/api/v1/status");

	assertThat(response.getStatusCodeValue()).isEqualTo(200);
	assertThat(response.getBody()).contains("\"code\":1");
	assertThat(response.getBody()).contains("\"message\":\"\"");
	}
	}
