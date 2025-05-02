package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_initiate_sync_of_transactions() {
		TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
		.deltas(List.of(
		TransactionDeltaDto.builder()
.amount(5911.72)
.dateOperation(java.time.Instant.now().plusSeconds(3600))
.description(UUID.randomUUID().toString())
.reference(UUID.randomUUID().toString())
.isRecurring(true)
.isExcluToRapport(false)
.status(UUID.randomUUID().toString())
.balance(com.groupe2cs.bizyhub.balances.infrastructure.entity.BalanceFixtures.randomOneViaCommand(commandGateway, user).getId().value())
.category(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(commandGateway, user).getId().value())
.updatedAt(java.time.Instant.now().plusSeconds(3600))
.createdAt(java.time.Instant.now().plusSeconds(3600))
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/transaction/sync";
	HttpEntity<TransactionSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_transactions() {

			String existingId = TransactionFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();

			TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
			.deltas(List.of(
			TransactionDeltaDto.builder()
			.id(existingId)
.amount(5911.72)
.dateOperation(java.time.Instant.now().plusSeconds(3600))
.description(UUID.randomUUID().toString())
.reference(UUID.randomUUID().toString())
.isRecurring(true)
.isExcluToRapport(false)
.status(UUID.randomUUID().toString())
.balance(com.groupe2cs.bizyhub.balances.infrastructure.entity.BalanceFixtures.randomOneViaCommand(commandGateway, user).getId().value())
.category(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(commandGateway, user).getId().value())
.updatedAt(java.time.Instant.now().plusSeconds(3600))
.createdAt(java.time.Instant.now().plusSeconds(3600))
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/transaction/sync";
			HttpEntity<TransactionSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_transactions() {
					String existingId = TransactionFixtures.randomOneViaCommand(commandGateway, getCurrentUser()).getId().value();
					TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
					.deltas(List.of(
					TransactionDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/transaction/sync";
					HttpEntity<TransactionSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/transaction/sync";
							HttpEntity<TransactionSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}