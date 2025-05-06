package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class SaleSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private SaleRepository Repository;

    @Autowired
    private com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productDataRepository ;
    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_sales() {
		SaleSyncRequest requestDTO = SaleSyncRequest.builder()
		.deltas(List.of(
		SaleDeltaDto.builder()
.name(UUID.randomUUID().toString())
.amount(8948.51)
.details(UUID.randomUUID().toString())
.isActive(false)
.product(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(commandGateway,productDataRepository, user).getId().value())
.updatedAt(java.time.Instant.now().plusSeconds(3600))
.reference(UUID.randomUUID().toString())
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/sale/sync";
	HttpEntity<SaleSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_sales() {

			String existingId = SaleFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			SaleSyncRequest requestDTO = SaleSyncRequest.builder()
			.deltas(List.of(
			SaleDeltaDto.builder()
			.id(existingId)
.name(UUID.randomUUID().toString())
.amount(8948.51)
.details(UUID.randomUUID().toString())
.isActive(false)
.product(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(commandGateway,productDataRepository, user).getId().value())
.updatedAt(java.time.Instant.now().plusSeconds(3600))
.reference(UUID.randomUUID().toString())
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/sale/sync";
			HttpEntity<SaleSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_sales() {
					String existingId = SaleFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					SaleSyncRequest requestDTO = SaleSyncRequest.builder()
					.deltas(List.of(
					SaleDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/sale/sync";
					HttpEntity<SaleSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							SaleSyncRequest requestDTO = SaleSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/sale/sync";
							HttpEntity<SaleSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}