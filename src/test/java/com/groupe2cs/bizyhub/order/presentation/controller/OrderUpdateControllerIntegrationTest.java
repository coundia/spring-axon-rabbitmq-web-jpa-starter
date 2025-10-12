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
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderUpdateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private CommandGateway commandGatewayUpdate;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_update_order() {

		String existingId = OrderFixtures.randomOneViaCommand(
				commandGateway, orderRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		).getId().value();

		CreateOrderCommand updated = OrderFixtures.randomOneViaCommand(
				commandGatewayUpdate, orderRepository,
				createdByDataRepository,
				tenantDataRepository,
				getCurrentUser()
		);

		OrderFixtures.byIdWaitExist(orderRepository, existingId);
		OrderFixtures.byIdWaitExist(orderRepository, updated.getId().value());

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("productId", UUID.randomUUID().toString());
		body.add("userId", UUID.randomUUID().toString());
		body.add("identifiant", UUID.randomUUID().toString());
		body.add("telephone", UUID.randomUUID().toString());
		body.add("mail", UUID.randomUUID().toString());
		body.add("ville", UUID.randomUUID().toString());
		body.add("remoteId", UUID.randomUUID().toString());
		body.add("localId", UUID.randomUUID().toString());
		body.add("status", UUID.randomUUID().toString());
		body.add("buyerName", UUID.randomUUID().toString());
		body.add("address", UUID.randomUUID().toString());
		body.add("notes", UUID.randomUUID().toString());
		body.add("message", UUID.randomUUID().toString());
		body.add("typeOrder", UUID.randomUUID().toString());
		body.add("paymentMethod", UUID.randomUUID().toString());
		body.add("deliveryMethod", UUID.randomUUID().toString());
		body.add("amountCents", 4723.39);
		body.add("quantity", 75);
		body.add("dateCommand", java.time.Instant.now().plusSeconds(3600));

		HttpHeaders multipartHeaders = new HttpHeaders();
		multipartHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, multipartHeaders);

		String uri = "/api/v1/commands/order/" + existingId;
		ResponseEntity<String> response = testRestTemplate.exchange(
				uri,
				HttpMethod.PUT,
				requestEntity,
				String.class
		);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
