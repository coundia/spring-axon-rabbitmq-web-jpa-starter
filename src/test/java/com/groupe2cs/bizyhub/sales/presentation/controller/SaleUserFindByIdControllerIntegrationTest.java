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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class SaleUserFindByIdControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private SaleUserRepository repository;

@Autowired
private com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository salesDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository usersDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_get_saleuser_by_id() {

	String existingId = SaleUserFixtures.randomOneViaCommand(
	commandGateway,repository,
        salesDataRepository,
        usersDataRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser()).getId().value();

	 SaleUserFixtures.byIdWaitExist(repository, existingId);

	String uri = "/v1/queries/saleUser/id?id=" + existingId;
	ResponseEntity<SaleUserResponse> response = this.getForEntity(uri, SaleUserResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
