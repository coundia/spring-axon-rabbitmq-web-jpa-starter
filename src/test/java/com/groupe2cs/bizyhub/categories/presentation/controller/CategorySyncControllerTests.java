package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class CategorySyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private CategoryRepository Repository;

    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_categorys() {
		CategorySyncRequest requestDTO = CategorySyncRequest.builder()
		.deltas(List.of(
		CategoryDeltaDto.builder()
.code(UUID.randomUUID().toString())
.name(UUID.randomUUID().toString())
.remoteId(UUID.randomUUID().toString())
.description(UUID.randomUUID().toString())
.typeEntry(UUID.randomUUID().toString())
.version(14)
.syncAt(java.time.Instant.now().plusSeconds(3600))
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/category/sync";
	HttpEntity<CategorySyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_categorys() {

			String existingId = CategoryFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			CategorySyncRequest requestDTO = CategorySyncRequest.builder()
			.deltas(List.of(
			CategoryDeltaDto.builder()
			.id(existingId)
.code(UUID.randomUUID().toString())
.name(UUID.randomUUID().toString())
.remoteId(UUID.randomUUID().toString())
.description(UUID.randomUUID().toString())
.typeEntry(UUID.randomUUID().toString())
.version(14)
.syncAt(java.time.Instant.now().plusSeconds(3600))
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/category/sync";
			HttpEntity<CategorySyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_categorys() {
					String existingId = CategoryFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					CategorySyncRequest requestDTO = CategorySyncRequest.builder()
					.deltas(List.of(
					CategoryDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/category/sync";
					HttpEntity<CategorySyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							CategorySyncRequest requestDTO = CategorySyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/category/sync";
							HttpEntity<CategorySyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}