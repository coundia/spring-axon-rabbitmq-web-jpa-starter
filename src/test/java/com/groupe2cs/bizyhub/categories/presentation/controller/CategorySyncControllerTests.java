package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryDeltaDto;
import com.groupe2cs.bizyhub.categories.application.dto.CategorySyncRequest;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CategorySyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_initiate_sync_of_categorys() {
		CategorySyncRequest requestDTO = CategorySyncRequest.builder()
				.deltas(List.of(
						CategoryDeltaDto.builder()
								.name(UUID.randomUUID().toString())
								.typeCategory(UUID.randomUUID().toString())
								.parentId(UUID.randomUUID().toString())
								.isDefault(true)
								.icon(UUID.randomUUID().toString())
								.colorHex(UUID.randomUUID().toString())
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

		String existingId = CategoryFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		CategorySyncRequest requestDTO = CategorySyncRequest.builder()
				.deltas(List.of(
						CategoryDeltaDto.builder()
								.id(existingId)
								.name(UUID.randomUUID().toString())
								.typeCategory(UUID.randomUUID().toString())
								.parentId(UUID.randomUUID().toString())
								.isDefault(true)
								.icon(UUID.randomUUID().toString())
								.colorHex(UUID.randomUUID().toString())
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
		String existingId = CategoryFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();
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