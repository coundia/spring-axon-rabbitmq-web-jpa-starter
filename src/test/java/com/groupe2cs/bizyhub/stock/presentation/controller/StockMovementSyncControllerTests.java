package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementDeltaDto;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementSyncRequest;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.StockMovementFixtures;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.StockMovementRepository;
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

public class StockMovementSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private StockMovementRepository Repository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_initiate_sync_of_stockMovements() {
		StockMovementSyncRequest requestDTO = StockMovementSyncRequest.builder()
				.deltas(List.of(
						StockMovementDeltaDto.builder()
								.typeStockMovement(UUID.randomUUID().toString())
								.quantity(7)
								.remoteId(UUID.randomUUID().toString())
								.localId(UUID.randomUUID().toString())
								.account(UUID.randomUUID().toString())
								.company(UUID.randomUUID().toString())
								.syncAt(java.time.Instant.now().plusSeconds(3600))
								.productVariant(UUID.randomUUID().toString())
								.orderLineId(UUID.randomUUID().toString())
								.discriminator(UUID.randomUUID().toString())
								.type("CREATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/stockMovement/sync";
		HttpEntity<StockMovementSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_update_of_stockMovements() {

		String
				existingId =
				StockMovementFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();

		StockMovementSyncRequest requestDTO = StockMovementSyncRequest.builder()
				.deltas(List.of(
						StockMovementDeltaDto.builder()
								.id(existingId)
								.typeStockMovement(UUID.randomUUID().toString())
								.quantity(7)
								.remoteId(UUID.randomUUID().toString())
								.localId(UUID.randomUUID().toString())
								.account(UUID.randomUUID().toString())
								.company(UUID.randomUUID().toString())
								.syncAt(java.time.Instant.now().plusSeconds(3600))
								.productVariant(UUID.randomUUID().toString())
								.orderLineId(UUID.randomUUID().toString())
								.discriminator(UUID.randomUUID().toString())
								.type("UPDATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/stockMovement/sync";
		HttpEntity<StockMovementSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_delete_of_stockMovements() {
		String
				existingId =
				StockMovementFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();
		StockMovementSyncRequest requestDTO = StockMovementSyncRequest.builder()
				.deltas(List.of(
						StockMovementDeltaDto.builder()
								.id(existingId)
								.type("DELETE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/stockMovement/sync";
		HttpEntity<StockMovementSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_handle_empty_delta_list() {

		StockMovementSyncRequest requestDTO = StockMovementSyncRequest.builder()
				.deltas(List.of())
				.build();

		String uri = "/api/v1/commands/stockMovement/sync";
		HttpEntity<StockMovementSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}
}