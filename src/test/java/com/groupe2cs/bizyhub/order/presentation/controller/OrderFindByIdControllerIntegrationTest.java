package com.groupe2cs.bizyhub.order.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.order.application.dto.*;
import com.groupe2cs.bizyhub.order.infrastructure.entity.*;
import com.groupe2cs.bizyhub.order.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.order.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class OrderFindByIdControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private OrderRepository repository;

@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_get_order_by_id() {

	String existingId = OrderFixtures.randomOneViaCommand(
	commandGateway,repository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser()).getId().value();

	 OrderFixtures.byIdWaitExist(repository, existingId);

	String uri = "/v1/queries/order/id?id=" + existingId;
	ResponseEntity<OrderResponse> response = this.getForEntity(uri, OrderResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getId()).isEqualTo(existingId);
	}
}
