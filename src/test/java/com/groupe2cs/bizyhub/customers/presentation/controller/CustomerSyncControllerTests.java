package com.groupe2cs.bizyhub.customers.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.customers.infrastructure.repository.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.customers.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private CustomerRepository Repository;

    @Autowired
    private com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository companyDataRepository ;
    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_customers() {
		CustomerSyncRequest requestDTO = CustomerSyncRequest.builder()
		.deltas(List.of(
		CustomerDeltaDto.builder()
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.code(UUID.randomUUID().toString())
.firstName(UUID.randomUUID().toString())
.lastName(UUID.randomUUID().toString())
.fullName(UUID.randomUUID().toString())
.balance(8627.78)
.balanceDebt(3726.11)
.phone(UUID.randomUUID().toString())
.email(UUID.randomUUID().toString())
.notes(UUID.randomUUID().toString())
.status(UUID.randomUUID().toString())
.company(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value())
.addressLine1(UUID.randomUUID().toString())
.addressLine2(UUID.randomUUID().toString())
.city(UUID.randomUUID().toString())
.region(UUID.randomUUID().toString())
.country(UUID.randomUUID().toString())
.postalCode(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.isActive(false)
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/customer/sync";
	HttpEntity<CustomerSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_customers() {

			String existingId = CustomerFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			CustomerSyncRequest requestDTO = CustomerSyncRequest.builder()
			.deltas(List.of(
			CustomerDeltaDto.builder()
			.id(existingId)
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.code(UUID.randomUUID().toString())
.firstName(UUID.randomUUID().toString())
.lastName(UUID.randomUUID().toString())
.fullName(UUID.randomUUID().toString())
.balance(8627.78)
.balanceDebt(3726.11)
.phone(UUID.randomUUID().toString())
.email(UUID.randomUUID().toString())
.notes(UUID.randomUUID().toString())
.status(UUID.randomUUID().toString())
.company(com.groupe2cs.bizyhub.companies.infrastructure.entity.CompanyFixtures.randomOneViaCommand(commandGateway,companyDataRepository, user).getId().value())
.addressLine1(UUID.randomUUID().toString())
.addressLine2(UUID.randomUUID().toString())
.city(UUID.randomUUID().toString())
.region(UUID.randomUUID().toString())
.country(UUID.randomUUID().toString())
.postalCode(UUID.randomUUID().toString())
.syncAt(java.time.Instant.now().plusSeconds(3600))
.isActive(false)
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/customer/sync";
			HttpEntity<CustomerSyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_customers() {
					String existingId = CustomerFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					CustomerSyncRequest requestDTO = CustomerSyncRequest.builder()
					.deltas(List.of(
					CustomerDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/customer/sync";
					HttpEntity<CustomerSyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							CustomerSyncRequest requestDTO = CustomerSyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/customer/sync";
							HttpEntity<CustomerSyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}