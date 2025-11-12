package com.groupe2cs.bizyhub.order.presentation.controller;

import com.groupe2cs.bizyhub.order.application.dto.OrderDeltaDto;
import com.groupe2cs.bizyhub.order.application.dto.OrderSyncRequest;
import com.groupe2cs.bizyhub.order.infrastructure.entity.OrderFixtures;
import com.groupe2cs.bizyhub.order.infrastructure.repository.OrderRepository;
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

public class OrderSyncControllerTests extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	private OrderRepository Repository;

	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_initiate_sync_of_orders() {
		OrderSyncRequest requestDTO = OrderSyncRequest.builder()
				.deltas(List.of(
						OrderDeltaDto.builder()
								.productId(UUID.randomUUID().toString())
								.userId(UUID.randomUUID().toString())
								.identifiant(UUID.randomUUID().toString())
								.telephone(UUID.randomUUID().toString())
								.mail(UUID.randomUUID().toString())
								.ville(UUID.randomUUID().toString())
								.remoteId(UUID.randomUUID().toString())
								.localId(UUID.randomUUID().toString())
								.status(UUID.randomUUID().toString())
								.buyerName(UUID.randomUUID().toString())
								.address(UUID.randomUUID().toString())
								.notes(UUID.randomUUID().toString())
								.message(UUID.randomUUID().toString())
								.typeOrder(UUID.randomUUID().toString())
								.paymentMethod(UUID.randomUUID().toString())
								.deliveryMethod(UUID.randomUUID().toString())
								.amountCents(5867.15)
								.quantity(7)
								.dateCommand(java.time.Instant.now().plusSeconds(3600))
								.type("CREATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/order/sync";
		HttpEntity<OrderSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_update_of_orders() {

		String
				existingId =
				OrderFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();

		OrderSyncRequest requestDTO = OrderSyncRequest.builder()
				.deltas(List.of(
						OrderDeltaDto.builder()
								.id(existingId)
								.productId(UUID.randomUUID().toString())
								.userId(UUID.randomUUID().toString())
								.identifiant(UUID.randomUUID().toString())
								.telephone(UUID.randomUUID().toString())
								.mail(UUID.randomUUID().toString())
								.ville(UUID.randomUUID().toString())
								.remoteId(UUID.randomUUID().toString())
								.localId(UUID.randomUUID().toString())
								.status(UUID.randomUUID().toString())
								.buyerName(UUID.randomUUID().toString())
								.address(UUID.randomUUID().toString())
								.notes(UUID.randomUUID().toString())
								.message(UUID.randomUUID().toString())
								.typeOrder(UUID.randomUUID().toString())
								.paymentMethod(UUID.randomUUID().toString())
								.deliveryMethod(UUID.randomUUID().toString())
								.amountCents(5867.15)
								.quantity(7)
								.dateCommand(java.time.Instant.now().plusSeconds(3600))
								.type("UPDATE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/order/sync";
		HttpEntity<OrderSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_initiate_delete_of_orders() {
		String
				existingId =
				OrderFixtures.randomOneViaCommand(commandGateway, Repository, getCurrentUser()).getId().value();
		OrderSyncRequest requestDTO = OrderSyncRequest.builder()
				.deltas(List.of(
						OrderDeltaDto.builder()
								.id(existingId)
								.type("DELETE")
								.build()
				))
				.build();

		String uri = "/api/v1/commands/order/sync";
		HttpEntity<OrderSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}

	@Test
	void it_should_handle_empty_delta_list() {

		OrderSyncRequest requestDTO = OrderSyncRequest.builder()
				.deltas(List.of())
				.build();

		String uri = "/api/v1/commands/order/sync";
		HttpEntity<OrderSyncRequest> request = new HttpEntity<>(requestDTO, headers);
		ResponseEntity<ApiResponseDto> response = testRestTemplate.postForEntity(uri, request, ApiResponseDto.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getCode()).isEqualTo(1);
		assertThat(response.getBody().getMessage()).isEqualTo("Sync in progress");
	}
}