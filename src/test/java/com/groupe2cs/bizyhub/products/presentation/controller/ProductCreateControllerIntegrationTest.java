package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
import com.groupe2cs.bizyhub.products.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.products.application.command.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_product() {

		ProductRequest requestDTO = new ProductRequest();

		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setCode(UUID.randomUUID().toString());
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setIsPublic(true);
		requestDTO.setHasSold(false);
		requestDTO.setHasPrice(true);
		requestDTO.setLevel(UUID.randomUUID().toString());
		requestDTO.setQuantity(29);
		requestDTO.setBarcode(UUID.randomUUID().toString());
		requestDTO.setCompany(UUID.randomUUID().toString());
		requestDTO.setUnit(UUID.randomUUID().toString());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setCategory(UUID.randomUUID().toString());
		requestDTO.setAccount(UUID.randomUUID().toString());
		requestDTO.setDefaultPrice(8031.22);
		requestDTO.setStatuses(UUID.randomUUID().toString());
		requestDTO.setPurchasePrice(3681.27);

		String uri = "/v1/commands/product";
		ResponseEntity<ProductResponse> response = this.postForEntity(uri, requestDTO, ProductResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getCode()).isEqualTo(requestDTO.getCode());
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getDescription()).isEqualTo(requestDTO.getDescription());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getIsPublic()).isEqualTo(requestDTO.getIsPublic());
		assertThat(response.getBody().getHasSold()).isEqualTo(requestDTO.getHasSold());
		assertThat(response.getBody().getHasPrice()).isEqualTo(requestDTO.getHasPrice());
		assertThat(response.getBody().getLevel()).isEqualTo(requestDTO.getLevel());
		assertThat(response.getBody().getQuantity()).isEqualTo(requestDTO.getQuantity());
		assertThat(response.getBody().getBarcode()).isEqualTo(requestDTO.getBarcode());
		assertThat(response.getBody().getCompany()).isEqualTo(requestDTO.getCompany());
		assertThat(response.getBody().getUnit()).isEqualTo(requestDTO.getUnit());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getCategory()).isEqualTo(requestDTO.getCategory());
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getDefaultPrice()).isEqualTo(requestDTO.getDefaultPrice());
		assertThat(response.getBody().getStatuses()).isEqualTo(requestDTO.getStatuses());
		assertThat(response.getBody().getPurchasePrice()).isEqualTo(requestDTO.getPurchasePrice());
	}
}
