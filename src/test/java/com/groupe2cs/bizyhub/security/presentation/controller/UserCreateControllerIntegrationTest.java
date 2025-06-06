package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.UserRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
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

public class UserCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_user() {

		UserRequest requestDTO = new UserRequest();

		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setPassword(UUID.randomUUID().toString());
		requestDTO.setFirstName(UUID.randomUUID().toString());
		requestDTO.setLastName(UUID.randomUUID().toString());
		requestDTO.setEmail(UUID.randomUUID().toString());
		requestDTO.setTelephone(UUID.randomUUID().toString());
		requestDTO.setLimitPerDay(72);
		requestDTO.setIsPremium(true);
		requestDTO.setEnabled(false);
		requestDTO.setIsBan(true);
		requestDTO.setMessage(UUID.randomUUID().toString());

		String uri = "/v1/admin/commands/user";
		ResponseEntity<UserResponse> response = this.postForEntity(uri, requestDTO, UserResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getUsername()).isEqualTo(requestDTO.getUsername());
		assertThat(response.getBody().getPassword()).isEqualTo(requestDTO.getPassword());
		assertThat(response.getBody().getFirstName()).isEqualTo(requestDTO.getFirstName());
		assertThat(response.getBody().getLastName()).isEqualTo(requestDTO.getLastName());
		assertThat(response.getBody().getEmail()).isEqualTo(requestDTO.getEmail());
		assertThat(response.getBody().getTelephone()).isEqualTo(requestDTO.getTelephone());
		assertThat(response.getBody().getLimitPerDay()).isEqualTo(requestDTO.getLimitPerDay());
		assertThat(response.getBody().getIsPremium()).isEqualTo(requestDTO.getIsPremium());
		assertThat(response.getBody().getEnabled()).isEqualTo(requestDTO.getEnabled());
		assertThat(response.getBody().getIsBan()).isEqualTo(requestDTO.getIsBan());
		assertThat(response.getBody().getMessage()).isEqualTo(requestDTO.getMessage());
	}
}
