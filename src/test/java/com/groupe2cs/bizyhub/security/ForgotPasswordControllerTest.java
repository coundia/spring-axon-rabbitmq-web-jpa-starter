package com.groupe2cs.bizyhub.security;

	import com.groupe2cs.bizyhub.security.application.service.*;
	import com.groupe2cs.bizyhub.security.infrastructure.config.*;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ForgotPasswordControllerTest {

		@Autowired
		private MockMvc mockMvc;
		@Autowired
		private ObjectMapper objectMapper;
		@Autowired
		private PasswordResetRepository tokenRepository;
		@Autowired
		private UserRepository userRepository;
		@Autowired
		private PasswordEncoder encoder;

		@BeforeEach
		void setUp() {
		tokenRepository.deleteAll();
		userRepository.deleteAll();

		userRepository.save(User.builder()
		.id(UUID.randomUUID().toString())
		.username("admin")
		.password(encoder.encode("admin"))
		.build());
		}

		@Test
		void it_should_generate_reset_token() throws Exception {
		ForgotPasswordRequestDto dto = ForgotPasswordRequestDto.builder()
		.username("admin")
		.build();

		mockMvc.perform(post("/api/auth/forgot-password")
		.contentType(MediaType.APPLICATION_JSON)
		.content(objectMapper.writeValueAsString(dto)))
		.andExpect(status().isOk());

		}

		@Test
		void it_should_reset_password_with_valid_token() throws Exception {
			var uuid = UUID.randomUUID().toString();
			tokenRepository.save(PasswordReset.builder()
				.id(uuid)
				.token(uuid)
				.username("admin")
				.expiration(Instant.now().plusSeconds(3600))
				.build());

			ResetPasswordDto dto = ResetPasswordDto.builder()
			.token(uuid)
			.newPassword("newpass")
			.build();

			mockMvc.perform(post("/api/auth/reset-password")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(dto)))
			.andExpect(status().isOk());

			var user = userRepository.findByUsername("admin").orElseThrow();
			assertThat(encoder.matches("newpass", user.getPassword())).isTrue();
		}

		@Test
		void it_should_fail_reset_if_token_invalid() throws Exception {
		ResetPasswordDto dto = ResetPasswordDto.builder()
		.token("invalid")
		.newPassword("xxx")
		.build();

		mockMvc.perform(post("/api/auth/reset-password")
		.contentType(MediaType.APPLICATION_JSON)
		.content(objectMapper.writeValueAsString(dto)))
		.andExpect(status().isBadRequest());
		}

		@Test
		void it_should_fail_reset_if_token_expired() throws Exception {
		var uuid = UUID.randomUUID().toString();
		tokenRepository.save(PasswordReset.builder()
		.id(uuid)
		.token(uuid)
		.username(uuid)
		.expiration(Instant.now().minusSeconds(60))
		.build());

		ResetPasswordDto dto = ResetPasswordDto.builder()
		.token(uuid)
		.newPassword("newpass")
		.build();

		mockMvc.perform(post("/api/auth/reset-password")
		.contentType(MediaType.APPLICATION_JSON)
		.content(objectMapper.writeValueAsString(dto)))
		.andExpect(status().isBadRequest());
		}
}
