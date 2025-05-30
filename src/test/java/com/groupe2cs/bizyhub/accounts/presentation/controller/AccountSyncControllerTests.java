package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountDeltaDto;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountSyncRequest;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private AccountRepository Repository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_initiate_sync_of_accounts() {
		AccountSyncRequest requestDTO = AccountSyncRequest.builder()
				.deltas(List.of(
						AccountDeltaDto.builder()
								.name(UUID.randomUUID().toString())
								.currency(UUID.randomUUID().toString())
								.currentBalance(7870.76)
								.previousBalance(1033.81)
								.details(UUID.randomUUID().toString())
								.isActive(true)
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

		String
				existingId =
				AccountFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();

		AccountSyncRequest requestDTO = AccountSyncRequest.builder()
				.deltas(List.of(
						AccountDeltaDto.builder()
								.id(existingId)
								.name(UUID.randomUUID().toString())
								.currency(UUID.randomUUID().toString())
								.currentBalance(7870.76)
								.previousBalance(1033.81)
								.details(UUID.randomUUID().toString())
								.isActive(true)
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
		String
				existingId =
				AccountFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();
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