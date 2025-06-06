package com.groupe2cs.bizyhub.notifications.presentation.controller;

import com.groupe2cs.bizyhub.notifications.application.dto.NotificationRequest;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
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

public class NotificationCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_notification() {

		NotificationRequest requestDTO = new NotificationRequest();

		requestDTO.setDeviceToken(UUID.randomUUID().toString());
		requestDTO.setTitle(UUID.randomUUID().toString());
		requestDTO.setMessage(UUID.randomUUID().toString());
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setReserved(UUID.randomUUID().toString());
		requestDTO.setErrorMessage(UUID.randomUUID().toString());

		String uri = "/v1/commands/notification";
		ResponseEntity<NotificationResponse> response = this.postForEntity(uri, requestDTO, NotificationResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getDeviceToken()).isEqualTo(requestDTO.getDeviceToken());
		assertThat(response.getBody().getTitle()).isEqualTo(requestDTO.getTitle());
		assertThat(response.getBody().getMessage()).isEqualTo(requestDTO.getMessage());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getReserved()).isEqualTo(requestDTO.getReserved());
		assertThat(response.getBody().getErrorMessage()).isEqualTo(requestDTO.getErrorMessage());
	}
}
