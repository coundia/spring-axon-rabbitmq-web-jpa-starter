package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
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

public class TransactionItemSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private TransactionItemRepository Repository;

    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_transactionItems() {
		TransactionItemSyncRequest requestDTO = TransactionItemSyncRequest.builder()
		.deltas(List.of(
		TransactionItemDeltaDto.builder()
.transaction(UUID.randomUUID().toString())
.product(UUID.randomUUID().toString())
.label(UUID.randomUUID().toString())
.quantity(45)
.unit(UUID.randomUUID().toString())
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.unitPrice(2969.57)
.total(9214.77)
.notes(UUID.randomUUID().toString())
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/transactionItem/sync";
	HttpEntity<TransactionItemSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_transactionItems() {

			String existingId = TransactionItemFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			TransactionItemSyncRequest requestDTO = TransactionItemSyncRequest.builder()
			.deltas(List.of(
			TransactionItemDeltaDto.builder()
			.id(existingId)
.transaction(UUID.randomUUID().toString())
.product(UUID.randomUUID().toString())
.label(UUID.randomUUID().toString())
.quantity(45)
.unit(UUID.randomUUID().toString())
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.unitPrice(2969.57)
.total(9214.77)
.notes(UUID.randomUUID().toString())
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/transactionItem/sync";
			HttpEntity<TransactionItemSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_transactionItems() {
					String existingId = TransactionItemFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					TransactionItemSyncRequest requestDTO = TransactionItemSyncRequest.builder()
					.deltas(List.of(
					TransactionItemDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/transactionItem/sync";
					HttpEntity<TransactionItemSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							TransactionItemSyncRequest requestDTO = TransactionItemSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/transactionItem/sync";
							HttpEntity<TransactionItemSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}