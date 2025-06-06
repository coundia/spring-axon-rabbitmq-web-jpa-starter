package com.groupe2cs.bizyhub.notifications.presentation.controller;

import com.groupe2cs.bizyhub.notifications.application.dto.NotificationDeltaDto;
import com.groupe2cs.bizyhub.notifications.application.dto.NotificationSyncRequest;
import com.groupe2cs.bizyhub.notifications.infrastructure.entity.NotificationFixtures;
import com.groupe2cs.bizyhub.notifications.infrastructure.repository.NotificationRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private NotificationRepository Repository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_initiate_sync_of_notifications() {
		NotificationSyncRequest requestDTO = NotificationSyncRequest.builder()
				.deltas(List.of(
						NotificationDeltaDto.builder()
								.deviceToken(UUID.randomUUID().toString())
								.title(UUID.randomUUID().toString())
								.message(UUID.randomUUID().toString())
								.status(UUID.randomUUID().toString())
								.reserved(UUID.randomUUID().toString())
								.errorMessage(UUID.randomUUID().toString())
								.type("CREATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/notification/sync";
		HttpEntity<NotificationSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_update_of_notifications() {

		String
				existingId =
				NotificationFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();

		NotificationSyncRequest requestDTO = NotificationSyncRequest.builder()
				.deltas(List.of(
						NotificationDeltaDto.builder()
								.id(existingId)
								.deviceToken(UUID.randomUUID().toString())
								.title(UUID.randomUUID().toString())
								.message(UUID.randomUUID().toString())
								.status(UUID.randomUUID().toString())
								.reserved(UUID.randomUUID().toString())
								.errorMessage(UUID.randomUUID().toString())
								.type("UPDATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/notification/sync";
		HttpEntity<NotificationSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_delete_of_notifications() {
		String
				existingId =
				NotificationFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();
		NotificationSyncRequest requestDTO = NotificationSyncRequest.builder()
				.deltas(List.of(
						NotificationDeltaDto.builder()
								.id(existingId)
								.type("DELETE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/notification/sync";
		HttpEntity<NotificationSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_handle_empty_delta_list() {

		NotificationSyncRequest requestDTO = NotificationSyncRequest.builder()
				.deltas(List.of())
				.build();

		String uri = "/api/v1/commands/notification/sync";
		HttpEntity<NotificationSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}
}