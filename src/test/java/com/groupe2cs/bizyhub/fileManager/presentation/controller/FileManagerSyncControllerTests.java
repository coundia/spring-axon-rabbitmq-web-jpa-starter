package com.groupe2cs.bizyhub.fileManager.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.repository.*;
import com.groupe2cs.bizyhub.fileManager.infrastructure.entity.*;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class FileManagerSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private FileManagerRepository Repository;

    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_fileManagers() {
		FileManagerSyncRequest requestDTO = FileManagerSyncRequest.builder()
		.deltas(List.of(
		FileManagerDeltaDto.builder()
.name(UUID.randomUUID().toString())
.details(UUID.randomUUID().toString())
.objectId(UUID.randomUUID().toString())
.objectName(UUID.randomUUID().toString())
.originalName(UUID.randomUUID().toString())
.mimeType(UUID.randomUUID().toString())
.size(84952L)
.path(UUID.randomUUID().toString())
.uri(UUID.randomUUID().toString())
.isPublic(true)
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/fileManager/sync";
	HttpEntity<FileManagerSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_fileManagers() {

			String existingId = FileManagerFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			FileManagerSyncRequest requestDTO = FileManagerSyncRequest.builder()
			.deltas(List.of(
			FileManagerDeltaDto.builder()
			.id(existingId)
.name(UUID.randomUUID().toString())
.details(UUID.randomUUID().toString())
.objectId(UUID.randomUUID().toString())
.objectName(UUID.randomUUID().toString())
.originalName(UUID.randomUUID().toString())
.mimeType(UUID.randomUUID().toString())
.size(84952L)
.path(UUID.randomUUID().toString())
.uri(UUID.randomUUID().toString())
.isPublic(true)
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/fileManager/sync";
			HttpEntity<FileManagerSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_fileManagers() {
					String existingId = FileManagerFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					FileManagerSyncRequest requestDTO = FileManagerSyncRequest.builder()
					.deltas(List.of(
					FileManagerDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/fileManager/sync";
					HttpEntity<FileManagerSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							FileManagerSyncRequest requestDTO = FileManagerSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/fileManager/sync";
							HttpEntity<FileManagerSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}