package com.groupe2cs.bizyhub.security;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.application.service.*;
	import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.*;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.infrastructure.config.*;


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

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class RegisterControllerTests {

@Autowired
private MockMvc mockMvc;

@Autowired
private ObjectMapper objectMapper;

@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;

private void createUser(String username, String password) {
if (userRepository.findByUsernameAndTenantName(username,DEFAULT_TENANT).isEmpty()) {
CustomUser user = CustomUser.builder()
.id(UUID.randomUUID().toString())
.username(username)
.password(passwordEncoder.encode(password))
.build();
userRepository.save(user);
TestTransaction.flagForCommit();
TestTransaction.end();
TestTransaction.start();
}
}

@Test
void it_should_register_user_and_return_token() throws Exception {
AuthRequestDto request = new AuthRequestDto();
request.setUsername("newuser");
request.setPassword("newpassword");

String response = mockMvc.perform(post("/api/auth/register")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isOk())
.andReturn().getResponse().getContentAsString();

AuthResponseDto dto = objectMapper.readValue(response, AuthResponseDto.class);
assertThat(dto.getToken()).isNotNull();
assertThat(dto.getUsername()).isEqualTo("newuser");
assertThat(dto.getCode()).isEqualTo(1);
assertThat(dto.getMessage()).isEqualTo("Registration successful");
assertThat(dto.getExpirationAt()).isNotNull();
}

@Test
void it_should_not_register_user_if_username_exists() throws Exception {
createUser("admin", "admin");

AuthRequestDto request = new AuthRequestDto();
request.setUsername("admin");
request.setPassword("admin");

mockMvc.perform(post("/api/auth/register")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isBadRequest());
}

@Test
void it_should_return_bad_request_when_input_invalid() throws Exception {
mockMvc.perform(post("/api/auth/register")
.contentType(MediaType.APPLICATION_JSON)
.content("{}"))
.andExpect(status().isBadRequest());
}
}

