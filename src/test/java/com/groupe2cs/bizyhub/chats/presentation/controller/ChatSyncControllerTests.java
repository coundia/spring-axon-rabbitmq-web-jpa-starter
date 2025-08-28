package com.groupe2cs.bizyhub.chats.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private ChatRepository Repository;

    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_chats() {
		ChatSyncRequest requestDTO = ChatSyncRequest.builder()
		.deltas(List.of(
		ChatDeltaDto.builder()
.messages(UUID.randomUUID().toString())
.responsesJson(UUID.randomUUID().toString())
.responses(UUID.randomUUID().toString())
.state(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.account(UUID.randomUUID().toString())
.dateTransaction(java.time.Instant.now().plusSeconds(3600))
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/chat/sync";
	HttpEntity<ChatSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_chats() {

			String existingId = ChatFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			ChatSyncRequest requestDTO = ChatSyncRequest.builder()
			.deltas(List.of(
			ChatDeltaDto.builder()
			.id(existingId)
.messages(UUID.randomUUID().toString())
.responsesJson(UUID.randomUUID().toString())
.responses(UUID.randomUUID().toString())
.state(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.account(UUID.randomUUID().toString())
.dateTransaction(java.time.Instant.now().plusSeconds(3600))
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/chat/sync";
			HttpEntity<ChatSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_chats() {
					String existingId = ChatFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					ChatSyncRequest requestDTO = ChatSyncRequest.builder()
					.deltas(List.of(
					ChatDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/chat/sync";
					HttpEntity<ChatSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							ChatSyncRequest requestDTO = ChatSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/chat/sync";
							HttpEntity<ChatSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}