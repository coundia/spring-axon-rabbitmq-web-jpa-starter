package com.groupe2cs.bizyhub.sales.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.sales.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class SaleUserCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository salesDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository usersDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_saleuser() {

		SaleUserRequest requestDTO = new SaleUserRequest();

		requestDTO.setSales(com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleFixtures.randomOneViaCommand(commandGateway,salesDataRepository, user).getId().value());
		requestDTO.setUsers(com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures.randomOneViaCommand(commandGateway,usersDataRepository, user).getId().value());
		requestDTO.setDetails(UUID.randomUUID().toString());
		requestDTO.setIsActive(false);
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

 		String uri = "/v1/commands/saleUser";
		ResponseEntity<SaleUserResponse> response = this.postForEntity(uri, requestDTO, SaleUserResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getSales()).isEqualTo(requestDTO.getSales());
		assertThat(response.getBody().getUsers()).isEqualTo(requestDTO.getUsers());
		assertThat(response.getBody().getDetails()).isEqualTo(requestDTO.getDetails());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
		assertThat(response.getBody().getUpdatedAt()).isEqualTo(requestDTO.getUpdatedAt());
		assertThat(response.getBody().getReference()).isEqualTo(requestDTO.getReference());
	}
}
