package com.groupe2cs.bizyhub.settings.presentation.controller;

import com.groupe2cs.bizyhub.settings.application.dto.SettingDeltaDto;
import com.groupe2cs.bizyhub.settings.application.dto.SettingSyncRequest;
import com.groupe2cs.bizyhub.settings.infrastructure.entity.SettingFixtures;
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

public class SettingSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_initiate_sync_of_settings() {
		SettingSyncRequest requestDTO = SettingSyncRequest.builder()
				.deltas(List.of(
						SettingDeltaDto.builder()
								.name(UUID.randomUUID().toString())
								.stringValue(UUID.randomUUID().toString())
								.description(UUID.randomUUID().toString())
								.isActive(true)
								.type("CREATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/setting/sync";
		HttpEntity<SettingSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_update_of_settings() {

		String existingId = SettingFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		SettingSyncRequest requestDTO = SettingSyncRequest.builder()
				.deltas(List.of(
						SettingDeltaDto.builder()
								.id(existingId)
								.name(UUID.randomUUID().toString())
								.stringValue(UUID.randomUUID().toString())
								.description(UUID.randomUUID().toString())
								.isActive(true)
								.type("UPDATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/setting/sync";
		HttpEntity<SettingSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_delete_of_settings() {
		String existingId = SettingFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();
		SettingSyncRequest requestDTO = SettingSyncRequest.builder()
				.deltas(List.of(
						SettingDeltaDto.builder()
								.id(existingId)
								.type("DELETE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/setting/sync";
		HttpEntity<SettingSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_handle_empty_delta_list() {

		SettingSyncRequest requestDTO = SettingSyncRequest.builder()
				.deltas(List.of())
				.build();

		String uri = "/api/v1/commands/setting/sync";
		HttpEntity<SettingSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}
}