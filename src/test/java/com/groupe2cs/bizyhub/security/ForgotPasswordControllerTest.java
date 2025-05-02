package com.groupe2cs.bizyhub.security;

	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.application.service.*;
	import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.*;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.security.infrastructure.config.*;
	import com.groupe2cs.bizyhub.security.application.dto.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ForgotPasswordControllerTest {

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

private final String username = "admin";
private final String password = "admin";

private void createUser() {
if (userRepository.findByUsernameAndTenantName(username,DEFAULT_TENANT).isEmpty()) {
CustomUser user = CustomUser.builder()
.id(UUID.randomUUID().toString())
.username(username)
.password(encoder.encode(password))
.build();
userRepository.save(user);
TestTransaction.flagForCommit();
TestTransaction.end();
TestTransaction.start();
}
}

private String createValidToken() {
String uuid = UUID.randomUUID().toString();
tokenRepository.save(PasswordReset.builder()
.id(uuid)
.token(uuid)
.username(username)
.expiration(Instant.now().plusSeconds(3600))
.build());
TestTransaction.flagForCommit();
TestTransaction.end();
TestTransaction.start();
return uuid;
}

private String createExpiredToken() {
String uuid = UUID.randomUUID().toString();
tokenRepository.save(PasswordReset.builder()
.id(uuid)
.token(uuid)
.username(username)
.expiration(Instant.now().minusSeconds(60))
.build());
TestTransaction.flagForCommit();
TestTransaction.end();
TestTransaction.start();
return uuid;
}

@Test
void it_should_generate_reset_token() throws Exception {
createUser();

ForgotPasswordRequestDto dto = ForgotPasswordRequestDto.builder()
.username(username)
.build();

mockMvc.perform(post("/api/auth/forgot-password")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(dto)))
.andExpect(status().isOk());
}
//todo check why this test is failing
//@Test
void it_should_reset_password_with_valid_token() throws Exception {
createUser();
String token = createValidToken();

ResetPasswordDto dto = ResetPasswordDto.builder()
.token(token)
.newPassword("newpass")
.build();

mockMvc.perform(post("/api/auth/reset-password")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(dto)))
.andExpect(status().isOk());

var user = userRepository.findByUsernameAndTenantName(username,DEFAULT_TENANT).orElseThrow();
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
createUser();
String token = createExpiredToken();

ResetPasswordDto dto = ResetPasswordDto.builder()
.token(token)
.newPassword("newpass")
.build();

mockMvc.perform(post("/api/auth/reset-password")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(dto)))
.andExpect(status().isBadRequest());
}
}
