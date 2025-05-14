package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionDeltaDto;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionSyncRequest;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private TransactionRepository Repository;

	@Autowired
	private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository;
	@Autowired
	private com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository;
	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_initiate_sync_of_transactions() {
		TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
				.deltas(List.of(
						TransactionDeltaDto.builder()
								.name(UUID.randomUUID().toString())
								.amount(7018.14)
								.details(UUID.randomUUID().toString())
								.isActive(false)
								.account(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(
										commandGateway,
										accountDataRepository,
										user).getId().value())
								.category(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(
										commandGateway,
										categoryDataRepository,
										user).getId().value())
								.typeTransactionRaw(UUID.randomUUID().toString())
								.dateTransaction(java.time.Instant.now().plusSeconds(3600))
								.updatedAt(java.time.Instant.now().plusSeconds(3600))
								.reference(UUID.randomUUID().toString())
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

		String
				existingId =
				TransactionFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();

		TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
				.deltas(List.of(
						TransactionDeltaDto.builder()
								.id(existingId)
								.name(UUID.randomUUID().toString())
								.amount(7018.14)
								.details(UUID.randomUUID().toString())
								.isActive(false)
								.account(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(
										commandGateway,
										accountDataRepository,
										user).getId().value())
								.category(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(
										commandGateway,
										categoryDataRepository,
										user).getId().value())
								.typeTransactionRaw(UUID.randomUUID().toString())
								.dateTransaction(java.time.Instant.now().plusSeconds(3600))
								.updatedAt(java.time.Instant.now().plusSeconds(3600))
								.reference(UUID.randomUUID().toString())
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
		String
				existingId =
				TransactionFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();
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