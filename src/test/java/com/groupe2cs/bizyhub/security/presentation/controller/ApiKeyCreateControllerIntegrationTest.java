package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyRequest;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiKeyCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_apikey() {

		ApiKeyRequest requestDTO = new ApiKeyRequest();

		requestDTO.setAppKey(UUID.randomUUID().toString());
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setActive(false);
		requestDTO.setCreatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setExpiration(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/admin/commands/apiKey";
		ResponseEntity<ApiKeyResponse> response = this.postForEntity(uri, requestDTO, ApiKeyResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getAppKey()).isEqualTo(requestDTO.getAppKey());
		assertThat(response.getBody().getUsername()).isEqualTo(requestDTO.getUsername());
		assertThat(response.getBody().getActive()).isEqualTo(requestDTO.getActive());
		assertThat(response.getBody().getCreatedAt()).isEqualTo(requestDTO.getCreatedAt());
		assertThat(response.getBody().getExpiration()).isEqualTo(requestDTO.getExpiration());
	}
}
