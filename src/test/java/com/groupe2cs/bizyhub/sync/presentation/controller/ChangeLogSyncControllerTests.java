package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class ChangeLogSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private ChangeLogRepository Repository;

    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_changeLogs() {
		ChangeLogSyncRequest requestDTO = ChangeLogSyncRequest.builder()
		.deltas(List.of(
		ChangeLogDeltaDto.builder()
.entityTable(UUID.randomUUID().toString())
.entityId(UUID.randomUUID().toString())
.operation(UUID.randomUUID().toString())
.payload(UUID.randomUUID().toString())
.status(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.attempts(92)
.error(UUID.randomUUID().toString())
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/changeLog/sync";
	HttpEntity<ChangeLogSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_changeLogs() {

			String existingId = ChangeLogFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			ChangeLogSyncRequest requestDTO = ChangeLogSyncRequest.builder()
			.deltas(List.of(
			ChangeLogDeltaDto.builder()
			.id(existingId)
.entityTable(UUID.randomUUID().toString())
.entityId(UUID.randomUUID().toString())
.operation(UUID.randomUUID().toString())
.payload(UUID.randomUUID().toString())
.status(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.attempts(92)
.error(UUID.randomUUID().toString())
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/changeLog/sync";
			HttpEntity<ChangeLogSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_changeLogs() {
					String existingId = ChangeLogFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					ChangeLogSyncRequest requestDTO = ChangeLogSyncRequest.builder()
					.deltas(List.of(
					ChangeLogDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/changeLog/sync";
					HttpEntity<ChangeLogSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							ChangeLogSyncRequest requestDTO = ChangeLogSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/changeLog/sync";
							HttpEntity<ChangeLogSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}