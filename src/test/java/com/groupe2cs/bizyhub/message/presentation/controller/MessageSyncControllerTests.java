package com.groupe2cs.bizyhub.message.presentation.controller;

import com.groupe2cs.bizyhub.message.application.dto.MessageDeltaDto;
import com.groupe2cs.bizyhub.message.application.dto.MessageSyncRequest;
import com.groupe2cs.bizyhub.message.infrastructure.entity.MessageFixtures;
import com.groupe2cs.bizyhub.message.infrastructure.repository.MessageRepository;
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

public class MessageSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private MessageRepository Repository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_initiate_sync_of_messages() {
		MessageSyncRequest requestDTO = MessageSyncRequest.builder()
				.deltas(List.of(
						MessageDeltaDto.builder()
								.code(UUID.randomUUID().toString())
								.email(UUID.randomUUID().toString())
								.phone(UUID.randomUUID().toString())
								.content(UUID.randomUUID().toString())
								.plateforme(UUID.randomUUID().toString())
								.source(UUID.randomUUID().toString())
								.agent(UUID.randomUUID().toString())
								.status(UUID.randomUUID().toString())
								.description(UUID.randomUUID().toString())
								.isActive(true)
								.isDefault(true)
								.remoteId(UUID.randomUUID().toString())
								.localId(UUID.randomUUID().toString())
								.depotAt(java.time.Instant.now().plusSeconds(3600))
								.syncAt(java.time.Instant.now().plusSeconds(3600))
								.type("CREATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/message/sync";
		HttpEntity<MessageSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_update_of_messages() {

		String
				existingId =
				MessageFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();

		MessageSyncRequest requestDTO = MessageSyncRequest.builder()
				.deltas(List.of(
						MessageDeltaDto.builder()
								.id(existingId)
								.code(UUID.randomUUID().toString())
								.email(UUID.randomUUID().toString())
								.phone(UUID.randomUUID().toString())
								.content(UUID.randomUUID().toString())
								.plateforme(UUID.randomUUID().toString())
								.source(UUID.randomUUID().toString())
								.agent(UUID.randomUUID().toString())
								.status(UUID.randomUUID().toString())
								.description(UUID.randomUUID().toString())
								.isActive(true)
								.isDefault(true)
								.remoteId(UUID.randomUUID().toString())
								.localId(UUID.randomUUID().toString())
								.depotAt(java.time.Instant.now().plusSeconds(3600))
								.syncAt(java.time.Instant.now().plusSeconds(3600))
								.type("UPDATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/message/sync";
		HttpEntity<MessageSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_delete_of_messages() {
		String
				existingId =
				MessageFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();
		MessageSyncRequest requestDTO = MessageSyncRequest.builder()
				.deltas(List.of(
						MessageDeltaDto.builder()
								.id(existingId)
								.type("DELETE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/message/sync";
		HttpEntity<MessageSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_handle_empty_delta_list() {

		MessageSyncRequest requestDTO = MessageSyncRequest.builder()
				.deltas(List.of())
				.build();

		String uri = "/api/v1/commands/message/sync";
		HttpEntity<MessageSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}
}