package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
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
    private com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository transactionDataRepository ;
    @Autowired
    private com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository productDataRepository ;
    @Autowired
    private com.groupe2cs.bizyhub.units.infrastructure.repository.UnitRepository unitDataRepository ;
    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_transactionItems() {
		TransactionItemSyncRequest requestDTO = TransactionItemSyncRequest.builder()
		.deltas(List.of(
		TransactionItemDeltaDto.builder()
.transaction(com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures.randomOneViaCommand(commandGateway,transactionDataRepository, user).getId().value())
.product(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(commandGateway,productDataRepository, user).getId().value())
.label(UUID.randomUUID().toString())
.quantity(32)
.unit(com.groupe2cs.bizyhub.units.infrastructure.entity.UnitFixtures.randomOneViaCommand(commandGateway,unitDataRepository, user).getId().value())
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.unitPrice(8719.42)
.total(6978.88)
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
.transaction(com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures.randomOneViaCommand(commandGateway,transactionDataRepository, user).getId().value())
.product(com.groupe2cs.bizyhub.products.infrastructure.entity.ProductFixtures.randomOneViaCommand(commandGateway,productDataRepository, user).getId().value())
.label(UUID.randomUUID().toString())
.quantity(32)
.unit(com.groupe2cs.bizyhub.units.infrastructure.entity.UnitFixtures.randomOneViaCommand(commandGateway,unitDataRepository, user).getId().value())
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.unitPrice(8719.42)
.total(6978.88)
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