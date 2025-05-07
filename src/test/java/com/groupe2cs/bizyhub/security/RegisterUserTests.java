package com.groupe2cs.bizyhub.security;
	import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
	import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.security.application.service.*;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.*;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
	import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.TENANT_HEADER;
	import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import static com.groupe2cs.bizyhub.security.infrastructure.config.ConstanteConfig.API_KEY_HEADER;
	import com.groupe2cs.bizyhub.security.infrastructure.config.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class RegisterUserTests {

@Autowired
private MockMvc mockMvc;

@Autowired
private ObjectMapper objectMapper;

@Autowired
private UserRepository userRepository;

@Autowired
private TenantRepository tenantRepository;

@Autowired
private PasswordEncoder passwordEncoder;

@BeforeEach
void setUpTenants() {

if (tenantRepository.findByName(DEFAULT_TENANT).isEmpty()) {
tenantRepository.save(Tenant.builder()
.id(DEFAULT_TENANT)
.name(DEFAULT_TENANT)
.build());
}
if (tenantRepository.findByName("tenant-b").isEmpty()) {
tenantRepository.save(Tenant.builder()
.id("tenant-b")
.name("tenant-b")
.build());
}
}

@Test
void it_should_register_user_and_return_token() throws Exception {
AuthRequestDto request = new AuthRequestDto("newuser", "newpassword");

String json = mockMvc.perform(post("/api/auth/register")
.header(ConstanteConfig.TENANT_HEADER, DEFAULT_TENANT)
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isOk())
.andExpect(jsonPath("$.code").value(1))
.andExpect(jsonPath("$.message").value("Registration successful"))
.andExpect(jsonPath("$.token").isNotEmpty())
.andReturn()
.getResponse()
.getContentAsString();

AuthResponseDto dto = objectMapper.readValue(json, AuthResponseDto.class);
assertThat(dto.getUsername()).isEqualTo("newuser");
assertThat(dto.getExpirationAt()).isNotNull();
}

@Test
void it_should_not_register_user_if_username_exists() throws Exception {

AuthRequestDto request = new AuthRequestDto("admin", "admin");
mockMvc.perform(post("/api/auth/register")
.header(ConstanteConfig.TENANT_HEADER, DEFAULT_TENANT)
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isBadRequest())
.andExpect(jsonPath("$.message")
.value("Username “admin” already exists in tenant"));
}

@Test
void it_should_return_bad_request_when_input_invalid() throws Exception {
mockMvc.perform(post("/api/auth/register")
.header(ConstanteConfig.TENANT_HEADER, DEFAULT_TENANT)
.contentType(MediaType.APPLICATION_JSON)
.content("{}"))
.andExpect(status().isBadRequest());
}

@Test
void it_should_return_register_user_when_missing_tenant_header() throws Exception {
	AuthRequestDto request = new AuthRequestDto("foo", "bar");
	mockMvc.perform(post("/api/auth/register")
	.contentType(MediaType.APPLICATION_JSON)
	.content(objectMapper.writeValueAsString(request)))
	.andExpect(status().isOk());
}

@Test
void it_should_allow_same_username_in_different_tenants() throws Exception {
AuthRequestDto request = new AuthRequestDto("cross", "pwd");

mockMvc.perform(post("/api/auth/register")
.header(ConstanteConfig.TENANT_HEADER, DEFAULT_TENANT)
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isOk());

mockMvc.perform(post("/api/auth/register")
.header(ConstanteConfig.TENANT_HEADER, "tenant-b")
.contentType(MediaType.APPLICATION_JSON)
.content(objectMapper.writeValueAsString(request)))
.andExpect(status().isOk());
}
}
