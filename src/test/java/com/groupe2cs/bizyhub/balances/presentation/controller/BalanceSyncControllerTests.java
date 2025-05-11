package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.balances.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.*;
import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class BalanceSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private BalanceRepository Repository;

    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_balances() {
		BalanceSyncRequest requestDTO = BalanceSyncRequest.builder()
		.deltas(List.of(
		BalanceDeltaDto.builder()
.name(UUID.randomUUID().toString())
.currency(UUID.randomUUID().toString())
.currentBalance(2659.93)
.previousBalance(144.14)
.lastUpdated(java.time.Instant.now().plusSeconds(3600))
.isDefault(true)
.ordre(96)
.isArchived(false)
.isAllowDebit(true)
.isAllowCredit(false)
.isExcluTotal(false)
.activateNotification(true)
.syncedAt(java.time.Instant.now().plusSeconds(3600))
.updatedAt(java.time.Instant.now().plusSeconds(3600))
.reference(UUID.randomUUID().toString())
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

			String existingId = BalanceFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			BalanceSyncRequest requestDTO = BalanceSyncRequest.builder()
			.deltas(List.of(
			BalanceDeltaDto.builder()
			.id(existingId)
.name(UUID.randomUUID().toString())
.currency(UUID.randomUUID().toString())
.currentBalance(2659.93)
.previousBalance(144.14)
.lastUpdated(java.time.Instant.now().plusSeconds(3600))
.isDefault(true)
.ordre(96)
.isArchived(false)
.isAllowDebit(true)
.isAllowCredit(false)
.isExcluTotal(false)
.activateNotification(true)
.syncedAt(java.time.Instant.now().plusSeconds(3600))
.updatedAt(java.time.Instant.now().plusSeconds(3600))
.reference(UUID.randomUUID().toString())
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
					String existingId = BalanceFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
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