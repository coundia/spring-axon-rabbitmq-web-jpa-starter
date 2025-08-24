package com.groupe2cs.bizyhub.debts.presentation.controller;

import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class DebtSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private DebtRepository Repository;

    @Autowired
    private com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository ;
    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_debts() {
		DebtSyncRequest requestDTO = DebtSyncRequest.builder()
		.deltas(List.of(
		DebtDeltaDto.builder()
.remoteId(UUID.randomUUID().toString())
.code(UUID.randomUUID().toString())
.notes(UUID.randomUUID().toString())
.balance(5932.27)
.balanceDebt(8950.37)
.dueDate(java.time.Instant.now().plusSeconds(3600))
.statuses(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.customer(com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures.randomOneViaCommand(commandGateway,customerDataRepository, user).getId().value())
.isActive(false)
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/debt/sync";
	HttpEntity<DebtSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_debts() {

			String existingId = DebtFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			DebtSyncRequest requestDTO = DebtSyncRequest.builder()
			.deltas(List.of(
			DebtDeltaDto.builder()
			.id(existingId)
.remoteId(UUID.randomUUID().toString())
.code(UUID.randomUUID().toString())
.notes(UUID.randomUUID().toString())
.balance(5932.27)
.balanceDebt(8950.37)
.dueDate(java.time.Instant.now().plusSeconds(3600))
.statuses(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.customer(com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures.randomOneViaCommand(commandGateway,customerDataRepository, user).getId().value())
.isActive(false)
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/debt/sync";
			HttpEntity<DebtSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_debts() {
					String existingId = DebtFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					DebtSyncRequest requestDTO = DebtSyncRequest.builder()
					.deltas(List.of(
					DebtDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/debt/sync";
					HttpEntity<DebtSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							DebtSyncRequest requestDTO = DebtSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/debt/sync";
							HttpEntity<DebtSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}