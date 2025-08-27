package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
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

public class AccountSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private AccountRepository Repository;

    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_accounts() {
		AccountSyncRequest requestDTO = AccountSyncRequest.builder()
		.deltas(List.of(
		AccountDeltaDto.builder()
.code(UUID.randomUUID().toString())
.name(UUID.randomUUID().toString())
.status(UUID.randomUUID().toString())
.currency(UUID.randomUUID().toString())
.typeAccount(UUID.randomUUID().toString())
.balance(8322.13)
.balancePrev(9069.43)
.balanceBlocked(8909.48)
.balanceInit(5955.1)
.balanceGoal(8109.47)
.balanceLimit(3294.35)
.description(UUID.randomUUID().toString())
.isActive(false)
.isDefault(false)
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/account/sync";
	HttpEntity<AccountSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_accounts() {

			String existingId = AccountFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			AccountSyncRequest requestDTO = AccountSyncRequest.builder()
			.deltas(List.of(
			AccountDeltaDto.builder()
			.id(existingId)
.code(UUID.randomUUID().toString())
.name(UUID.randomUUID().toString())
.status(UUID.randomUUID().toString())
.currency(UUID.randomUUID().toString())
.typeAccount(UUID.randomUUID().toString())
.balance(8322.13)
.balancePrev(9069.43)
.balanceBlocked(8909.48)
.balanceInit(5955.1)
.balanceGoal(8109.47)
.balanceLimit(3294.35)
.description(UUID.randomUUID().toString())
.isActive(false)
.isDefault(false)
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/account/sync";
			HttpEntity<AccountSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_accounts() {
					String existingId = AccountFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					AccountSyncRequest requestDTO = AccountSyncRequest.builder()
					.deltas(List.of(
					AccountDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/account/sync";
					HttpEntity<AccountSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							AccountSyncRequest requestDTO = AccountSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/account/sync";
							HttpEntity<AccountSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}