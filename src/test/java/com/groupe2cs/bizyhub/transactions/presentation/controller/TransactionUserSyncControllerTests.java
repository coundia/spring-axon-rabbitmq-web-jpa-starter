package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
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

public class TransactionUserSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private TransactionUserRepository Repository;

    @Autowired
    private com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository transactionDataRepository ;
    @Autowired
    private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository ;
    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_transactionUsers() {
		TransactionUserSyncRequest requestDTO = TransactionUserSyncRequest.builder()
		.deltas(List.of(
		TransactionUserDeltaDto.builder()
.name(UUID.randomUUID().toString())
.transaction(com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures.randomOneViaCommand(commandGateway,transactionDataRepository, user).getId().value())
.user(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(commandGateway,userDataRepository, user).getId().value())
.username(UUID.randomUUID().toString())
.details(UUID.randomUUID().toString())
.isActive(false)
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/transactionUser/sync";
	HttpEntity<TransactionUserSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_transactionUsers() {

			String existingId = TransactionUserFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			TransactionUserSyncRequest requestDTO = TransactionUserSyncRequest.builder()
			.deltas(List.of(
			TransactionUserDeltaDto.builder()
			.id(existingId)
.name(UUID.randomUUID().toString())
.transaction(com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionFixtures.randomOneViaCommand(commandGateway,transactionDataRepository, user).getId().value())
.user(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(commandGateway,userDataRepository, user).getId().value())
.username(UUID.randomUUID().toString())
.details(UUID.randomUUID().toString())
.isActive(false)
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/transactionUser/sync";
			HttpEntity<TransactionUserSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_transactionUsers() {
					String existingId = TransactionUserFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					TransactionUserSyncRequest requestDTO = TransactionUserSyncRequest.builder()
					.deltas(List.of(
					TransactionUserDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/transactionUser/sync";
					HttpEntity<TransactionUserSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							TransactionUserSyncRequest requestDTO = TransactionUserSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/transactionUser/sync";
							HttpEntity<TransactionUserSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}