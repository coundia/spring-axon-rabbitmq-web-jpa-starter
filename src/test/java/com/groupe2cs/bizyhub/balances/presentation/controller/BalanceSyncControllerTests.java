package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.balances.application.dto.BalanceDeltaDto;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceSyncRequest;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.BalanceFixtures;
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

public class BalanceSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_initiate_sync_of_balances() {
		BalanceSyncRequest requestDTO = BalanceSyncRequest.builder()
				.deltas(List.of(
						BalanceDeltaDto.builder()
								.name(UUID.randomUUID().toString())
								.currency(UUID.randomUUID().toString())
								.currentBalance(1778.99)
								.previousBalance(1887.51)
								.lastUpdated(java.time.Instant.now().plusSeconds(3600))
								.isDefault(true)
								.ordre(11)
								.isArchived(false)
								.isAllowDebit(true)
								.isAllowCredit(false)
								.isExcluTotal(true)
								.activateNotification(true)
								.syncedAt(java.time.Instant.now().plusSeconds(3600))
								.type("CREATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/balance/sync";
		HttpEntity<BalanceSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_update_of_balances() {

		String existingId = BalanceFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

		BalanceSyncRequest requestDTO = BalanceSyncRequest.builder()
				.deltas(List.of(
						BalanceDeltaDto.builder()
								.id(existingId)
								.name(UUID.randomUUID().toString())
								.currency(UUID.randomUUID().toString())
								.currentBalance(1778.99)
								.previousBalance(1887.51)
								.lastUpdated(java.time.Instant.now().plusSeconds(3600))
								.isDefault(true)
								.ordre(11)
								.isArchived(false)
								.isAllowDebit(true)
								.isAllowCredit(false)
								.isExcluTotal(true)
								.activateNotification(true)
								.syncedAt(java.time.Instant.now().plusSeconds(3600))
								.type("UPDATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/balance/sync";
		HttpEntity<BalanceSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_delete_of_balances() {
		String existingId = BalanceFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();
		BalanceSyncRequest requestDTO = BalanceSyncRequest.builder()
				.deltas(List.of(
						BalanceDeltaDto.builder()
								.id(existingId)
								.type("DELETE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/balance/sync";
		HttpEntity<BalanceSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_handle_empty_delta_list() {

		BalanceSyncRequest requestDTO = BalanceSyncRequest.builder()
				.deltas(List.of())
				.build();

		String uri = "/api/v1/commands/balance/sync";
		HttpEntity<BalanceSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}
}