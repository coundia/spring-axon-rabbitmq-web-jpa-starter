package com.groupe2cs.bizyhub.order.presentation.controller;

import com.groupe2cs.bizyhub.order.infrastructure.entity.Order;
import com.groupe2cs.bizyhub.order.infrastructure.entity.OrderFixtures;
import com.groupe2cs.bizyhub.order.infrastructure.repository.OrderRepository;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderDeleteControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_delete_order() {
		String existingId = OrderFixtures.randomOneViaCommand(commandGateway, orderRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()).getId().value();

		OrderFixtures.byIdWaitExist(orderRepository, existingId);

		String uri = "/v1/commands/order/" + existingId;

		ResponseEntity<String> rep = this.delete(uri);
		assertThat(rep.getStatusCode().value()).isEqualTo(200);

		Order found = OrderFixtures.byIdWaitNotExist(orderRepository, existingId);
		assertThat(found).isNull();
	}
}
