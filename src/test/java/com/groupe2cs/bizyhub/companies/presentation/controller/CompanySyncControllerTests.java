package com.groupe2cs.bizyhub.companies.presentation.controller;

import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
import com.groupe2cs.bizyhub.shared.application.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.*;
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

public class CompanySyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
private CompanyRepository Repository;

    @Autowired
    private UserRepository createdByDataRepository ;
    @Autowired
    private TenantRepository tenantDataRepository ;

	@Test
	void it_should_initiate_sync_of_companys() {
		CompanySyncRequest requestDTO = CompanySyncRequest.builder()
		.deltas(List.of(
		CompanyDeltaDto.builder()
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.code(UUID.randomUUID().toString())
.name(UUID.randomUUID().toString())
.description(UUID.randomUUID().toString())
.phone(UUID.randomUUID().toString())
.email(UUID.randomUUID().toString())
.website(UUID.randomUUID().toString())
.taxId(UUID.randomUUID().toString())
.currency(UUID.randomUUID().toString())
.addressLine1(UUID.randomUUID().toString())
.addressLine2(UUID.randomUUID().toString())
.city(UUID.randomUUID().toString())
.region(UUID.randomUUID().toString())
.country(UUID.randomUUID().toString())
.postalCode(UUID.randomUUID().toString())
.isActive(false)
.syncAt(java.time.Instant.now().plusSeconds(3600))
.isDefault(true)
		.type("CREATE")
		.build()
		))
		.build();

	String uri = "/api/v1/commands/company/sync";
	HttpEntity<CompanySyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(response.getBody()).isNotNull();
			assertThat(response.getBody().getCode()).isEqualTo(1);
			assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
			}

			@Test
			void it_should_initiate_update_of_companys() {

			String existingId = CompanyFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();

			CompanySyncRequest requestDTO = CompanySyncRequest.builder()
			.deltas(List.of(
			CompanyDeltaDto.builder()
			.id(existingId)
.remoteId(UUID.randomUUID().toString())
.localId(UUID.randomUUID().toString())
.code(UUID.randomUUID().toString())
.name(UUID.randomUUID().toString())
.description(UUID.randomUUID().toString())
.phone(UUID.randomUUID().toString())
.email(UUID.randomUUID().toString())
.website(UUID.randomUUID().toString())
.taxId(UUID.randomUUID().toString())
.currency(UUID.randomUUID().toString())
.addressLine1(UUID.randomUUID().toString())
.addressLine2(UUID.randomUUID().toString())
.city(UUID.randomUUID().toString())
.region(UUID.randomUUID().toString())
.country(UUID.randomUUID().toString())
.postalCode(UUID.randomUUID().toString())
.isActive(false)
.syncAt(java.time.Instant.now().plusSeconds(3600))
.isDefault(true)
			.type("UPDATE")
			.build()
			))
			.build();

			String uri = "/api/v1/commands/company/sync";
			HttpEntity<CompanySyncRequest> request = new HttpEntity<>(requestDTO, headers);
				ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody().getCode()).isEqualTo(1);
					assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
					}

					@Test
					void it_should_initiate_delete_of_companys() {
					String existingId = CompanyFixtures.randomOneViaCommand(commandGateway,Repository, getCurrentUser()).getId().value();
					CompanySyncRequest requestDTO = CompanySyncRequest.builder()
					.deltas(List.of(
					CompanyDeltaDto.builder()
					.id(existingId)
					.type("DELETE")
					.build()
					))
					.build();

					String uri = "/api/v1/commands/company/sync";
					HttpEntity<CompanySyncRequest> request = new HttpEntity<>(requestDTO, headers);
						ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

							assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
							assertThat(response.getBody().getCode()).isEqualTo(1);
							assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
							}

							@Test
							void it_should_handle_empty_delta_list() {

							CompanySyncRequest requestDTO = CompanySyncRequest.builder()
							.deltas(List.of())
							.build();

							String uri = "/api/v1/commands/company/sync";
							HttpEntity<CompanySyncRequest> request = new HttpEntity<>(requestDTO, headers);
								ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

									assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
									assertThat(response.getBody().getCode()).isEqualTo(1);
									assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
				}
}