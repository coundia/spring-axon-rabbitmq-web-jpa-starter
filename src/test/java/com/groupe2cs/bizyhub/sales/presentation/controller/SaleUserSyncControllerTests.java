package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
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

public class SaleUserSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private SaleUserRepository Repository;

    @Autowired
    private com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository saleDataRepository ;
    @Autowired
    private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository ;
    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_saleUsers() {
		SaleUserSyncRequest requestDTO = SaleUserSyncRequest.builder()
		.deltas(List.of(
		SaleUserDeltaDto.builder()
.name(UUID.randomUUID().toString())
.sale(com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleFixtures.randomOneViaCommand(commandGateway,saleDataRepository, user).getId().value())
.user(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(commandGateway,userDataRepository, user).getId().value())
.username(UUID.randomUUID().toString())
.details(UUID.randomUUID().toString())
.isActive(true)
.updatedAt(java.time.Instant.now().plusSeconds(3600))
.reference(UUID.randomUUID().toString())
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/saleUser/sync";
	HttpEntity<SaleUserSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_saleUsers() {

			String existingId = SaleUserFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			SaleUserSyncRequest requestDTO = SaleUserSyncRequest.builder()
			.deltas(List.of(
			SaleUserDeltaDto.builder()
			.id(existingId)
.name(UUID.randomUUID().toString())
.sale(com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleFixtures.randomOneViaCommand(commandGateway,saleDataRepository, user).getId().value())
.user(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(commandGateway,userDataRepository, user).getId().value())
.username(UUID.randomUUID().toString())
.details(UUID.randomUUID().toString())
.isActive(true)
.updatedAt(java.time.Instant.now().plusSeconds(3600))
.reference(UUID.randomUUID().toString())
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/saleUser/sync";
			HttpEntity<SaleUserSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_saleUsers() {
					String existingId = SaleUserFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					SaleUserSyncRequest requestDTO = SaleUserSyncRequest.builder()
					.deltas(List.of(
					SaleUserDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/saleUser/sync";
					HttpEntity<SaleUserSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							SaleUserSyncRequest requestDTO = SaleUserSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/saleUser/sync";
							HttpEntity<SaleUserSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}