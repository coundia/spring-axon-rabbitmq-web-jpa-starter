package com.groupe2cs.bizyhub.companies.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.companies.application.command.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_company() {

		CompanyRequest requestDTO = new CompanyRequest();

		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setCode(UUID.randomUUID().toString());
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setPhone(UUID.randomUUID().toString());
		requestDTO.setEmail(UUID.randomUUID().toString());
		requestDTO.setWebsite(UUID.randomUUID().toString());
		requestDTO.setTaxId(UUID.randomUUID().toString());
		requestDTO.setCurrency(UUID.randomUUID().toString());
		requestDTO.setAddressLine1(UUID.randomUUID().toString());
		requestDTO.setAddressLine2(UUID.randomUUID().toString());
		requestDTO.setCity(UUID.randomUUID().toString());
		requestDTO.setRegion(UUID.randomUUID().toString());
		requestDTO.setCountry(UUID.randomUUID().toString());
		requestDTO.setAccount(UUID.randomUUID().toString());
		requestDTO.setPostalCode(UUID.randomUUID().toString());
		requestDTO.setIsActive(true);
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setIsPublic(true);
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setIsDefault(true);

		String uri = "/v1/commands/company";
		ResponseEntity<CompanyResponse> response = this.postForEntity(uri, requestDTO, CompanyResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getCode()).isEqualTo(requestDTO.getCode());
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getDescription()).isEqualTo(requestDTO.getDescription());
		assertThat(response.getBody().getPhone()).isEqualTo(requestDTO.getPhone());
		assertThat(response.getBody().getEmail()).isEqualTo(requestDTO.getEmail());
		assertThat(response.getBody().getWebsite()).isEqualTo(requestDTO.getWebsite());
		assertThat(response.getBody().getTaxId()).isEqualTo(requestDTO.getTaxId());
		assertThat(response.getBody().getCurrency()).isEqualTo(requestDTO.getCurrency());
		assertThat(response.getBody().getAddressLine1()).isEqualTo(requestDTO.getAddressLine1());
		assertThat(response.getBody().getAddressLine2()).isEqualTo(requestDTO.getAddressLine2());
		assertThat(response.getBody().getCity()).isEqualTo(requestDTO.getCity());
		assertThat(response.getBody().getRegion()).isEqualTo(requestDTO.getRegion());
		assertThat(response.getBody().getCountry()).isEqualTo(requestDTO.getCountry());
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getPostalCode()).isEqualTo(requestDTO.getPostalCode());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getIsPublic()).isEqualTo(requestDTO.getIsPublic());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getIsDefault()).isEqualTo(requestDTO.getIsDefault());
	}
}
