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
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AuthControllerTests {

@Autowired
private MockMvc mockMvc;

@Autowired
private ObjectMapper objectMapper;

@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;

private String existingUsername = "admin";
private String existingPassword = "admin";

private void createUserIfNotExist() {
if (userRepository.findByUsernameAndTenantName(existingUsername,DEFAULT_TENANT).isEmpty()) {
CustomUser user = CustomUser.builder()
.id(UUID.randomUUID().toString())
.username(existingUsername)
.password(passwordEncoder.encode(existingPassword))
.build();
userRepository.save(user);
TestTransaction.flagForCommit();
TestTransaction.end();
TestTransaction.start();
}
}

@Test
void it_should_return_jwt_token_when_credentials_are_valid() throws Exception {
createUserIfNotExist();

AuthRequestDto request = new AuthRequestDto();
request.setUsername(existingUsername);
request.setPassword(existingPassword);

String response = mockMvc.perform(post("/api/auth/login")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isOk())
.andReturn().getResponse().getContentAsString();

AuthResponseDto dto = objectMapper.readValue(response, AuthResponseDto.class);
assertThat(dto.getToken()).isNotNull();
assertThat(dto.getUsername()).isEqualTo(existingUsername);
assertThat(dto.getCode()).isEqualTo(1);
assertThat(dto.getMessage()).isEqualTo("Login successful");
assertThat(dto.getExpirationAt()).isNotNull();
}

@Test
void it_should_return_unauthorized_when_user_not_exist() throws Exception {
AuthRequestDto request = new AuthRequestDto();
request.setUsername("unknown");
request.setPassword("admin");

mockMvc.perform(post("/api/auth/login")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isUnauthorized());
}

@Test
void it_should_return_unauthorized_when_password_invalid() throws Exception {
createUserIfNotExist();

AuthRequestDto request = new AuthRequestDto();
request.setUsername(existingUsername);
request.setPassword("wrong");

mockMvc.perform(post("/api/auth/login")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isUnauthorized());
}

@Test
void it_should_return_unauthorized_request_when_body_empty() throws Exception {
mockMvc.perform(post("/api/auth/login")
.contentType(MediaType.APPLICATION_JSON)
.content("{}"))
.andExpect(status().isUnauthorized());
}
}
