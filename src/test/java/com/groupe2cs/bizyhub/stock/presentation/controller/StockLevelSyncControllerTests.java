package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
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
    private com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productVariantDataRepository ;
    @Autowired
    private com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository ;
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
.stockOnHand(84)
.stockAllocated(7)
.productVariant(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(commandGateway,productVariantDataRepository, user).getId().value())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.company(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value())
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
.stockOnHand(84)
.stockAllocated(7)
.productVariant(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(commandGateway,productVariantDataRepository, user).getId().value())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.company(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value())
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