package com.groupe2cs.bizyhub.security;
import com.groupe2cs.bizyhub.security.application.service.*;
import com.groupe2cs.bizyhub.security.infrastructure.config.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTests {

@Autowired
private MockMvc mockMvc;

@Autowired
private ObjectMapper objectMapper;

@Autowired
private UserRepository userRepository;

@Autowired
PasswordEncoder passwordEncoder;

@BeforeEach
void setUp() {
userRepository.deleteAll();

User user = User.builder()
.id(UUID.randomUUID().toString())
.username("admin")
.password(passwordEncoder.encode("admin"))
.build();

userRepository.save(user);
}

@Test
void it_should_return_jwt_token_when_credentials_are_valid() throws Exception {
AuthRequestDto request = new AuthRequestDto();
request.setUsername("admin");
request.setPassword("admin");

String response = mockMvc.perform(post("/api/auth/login")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isOk())
.andReturn().getResponse().getContentAsString();

AuthResponseDto dto = objectMapper.readValue(response, AuthResponseDto.class);
assertThat(dto.getToken()).isNotNull();
assertThat(dto.getUsername()).isEqualTo("admin");
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
AuthRequestDto request = new AuthRequestDto();
request.setUsername("admin");
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
