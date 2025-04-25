package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
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

public class TransactionSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Test
	void it_should_initiate_sync_of_transactions() {
		TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
		.deltas(List.of(
		TransactionDeltaDto.builder()
.reference(UUID.randomUUID().toString())
.amount(8558.99)
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

			String existingId = TransactionFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();

			TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
			.deltas(List.of(
			TransactionDeltaDto.builder()
			.id(existingId)
.reference(UUID.randomUUID().toString())
.amount(8558.99)
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
					String existingId = TransactionFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();
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