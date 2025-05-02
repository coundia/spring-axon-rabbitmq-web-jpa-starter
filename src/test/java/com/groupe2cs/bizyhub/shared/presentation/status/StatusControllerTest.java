package com.groupe2cs.bizyhub.shared.presentation.status;

	import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
	import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class StatusControllerTest extends BaseUnitTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void it_should_return_open_status() throws Exception {
		mockMvc.perform(get("/api/v1/status"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(1))
				.andExpect(jsonPath("$.message").exists());
	}

	@Test
	void it_should_return_fallback_status() throws Exception {
		mockMvc.perform(get("/api/v1/status/fallback"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(1))
				.andExpect(jsonPath("$.message").exists());
	}

	@Test
	void it_should_return_admin_status() throws Exception {
		mockMvc.perform(get("/api/v1/admin/status"))
				.andExpect(status().isUnauthorized());
	}

	@Test
	void it_should_return_logged_in_status_unauthorized() throws Exception {
		mockMvc.perform(get("/api/v1/status/logged-in"))
				.andExpect(status().isUnauthorized());
	}
}
