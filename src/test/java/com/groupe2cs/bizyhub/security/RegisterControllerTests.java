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

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTests {

@Autowired
private MockMvc mockMvc;

@Autowired
private ObjectMapper objectMapper;

@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;

@BeforeEach
void setUp() {
userRepository.deleteAll();
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
}

@Test
void it_should_not_register_user_if_username_exists() throws Exception {
User user = User.builder()
.id(UUID.randomUUID().toString())
.username("admin")
.password(passwordEncoder.encode("admin"))
.build();
userRepository.save(user);

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
