package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class StockLevelSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private StockLevelRepository Repository;

    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_stockLevels() {
		StockLevelSyncRequest requestDTO = StockLevelSyncRequest.builder()
		.deltas(List.of(
		StockLevelDeltaDto.builder()
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.stockOnHand(56)
.stockAllocated(22)
.productVariant(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.company(UUID.randomUUID().toString())
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/stockLevel/sync";
	HttpEntity<StockLevelSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_stockLevels() {

			String existingId = StockLevelFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			StockLevelSyncRequest requestDTO = StockLevelSyncRequest.builder()
			.deltas(List.of(
			StockLevelDeltaDto.builder()
			.id(existingId)
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.stockOnHand(56)
.stockAllocated(22)
.productVariant(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.company(UUID.randomUUID().toString())
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/stockLevel/sync";
			HttpEntity<StockLevelSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_stockLevels() {
					String existingId = StockLevelFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					StockLevelSyncRequest requestDTO = StockLevelSyncRequest.builder()
					.deltas(List.of(
					StockLevelDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/stockLevel/sync";
					HttpEntity<StockLevelSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							StockLevelSyncRequest requestDTO = StockLevelSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/stockLevel/sync";
							HttpEntity<StockLevelSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}