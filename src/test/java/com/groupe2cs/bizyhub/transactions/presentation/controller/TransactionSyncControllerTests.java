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

public class TransactionSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private TransactionRepository Repository;

    @Autowired
    private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository ;
    @Autowired
    private com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository ;
    @Autowired
    private com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository ;
    @Autowired
    private com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository ;
    @Autowired
    private com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository debtDataRepository ;
    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_transactions() {
		TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
		.deltas(List.of(
		TransactionDeltaDto.builder()
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.code(UUID.randomUUID().toString())
.description(UUID.randomUUID().toString())
.amount(6546.9)
.typeEntry(UUID.randomUUID().toString())
.dateTransaction(java.time.Instant.now().plusSeconds(3600))
.status(UUID.randomUUID().toString())
.entityName(UUID.randomUUID().toString())
.entityId(UUID.randomUUID().toString())
.account(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(commandGateway,accountDataRepository, user).getId().value())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.category(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(commandGateway,categoryDataRepository, user).getId().value())
.company(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value())
.customer(com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures.randomOneViaCommand(commandGateway,customerDataRepository, user).getId().value())
.debt(com.groupe2cs.bizyhub.debts.infrastructure.entity.DebtFixtures.randomOneViaCommand(commandGateway,debtDataRepository, user).getId().value())
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

			String existingId = TransactionFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			TransactionSyncRequest requestDTO = TransactionSyncRequest.builder()
			.deltas(List.of(
			TransactionDeltaDto.builder()
			.id(existingId)
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.code(UUID.randomUUID().toString())
.description(UUID.randomUUID().toString())
.amount(6546.9)
.typeEntry(UUID.randomUUID().toString())
.dateTransaction(java.time.Instant.now().plusSeconds(3600))
.status(UUID.randomUUID().toString())
.entityName(UUID.randomUUID().toString())
.entityId(UUID.randomUUID().toString())
.account(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(commandGateway,accountDataRepository, user).getId().value())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.category(com.groupe2cs.bizyhub.categories.infrastructure.entity.CategoryFixtures.randomOneViaCommand(commandGateway,categoryDataRepository, user).getId().value())
.company(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value())
.customer(com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures.randomOneViaCommand(commandGateway,customerDataRepository, user).getId().value())
.debt(com.groupe2cs.bizyhub.debts.infrastructure.entity.DebtFixtures.randomOneViaCommand(commandGateway,debtDataRepository, user).getId().value())
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
					String existingId = TransactionFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
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