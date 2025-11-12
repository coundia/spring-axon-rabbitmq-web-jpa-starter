package com.groupe2cs.bizyhub.order.presentation.controller;

import com.groupe2cs.bizyhub.order.application.dto.OrderRequest;
import com.groupe2cs.bizyhub.order.application.dto.OrderResponse;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderCreateControllerIntegrationTest extends BaseIntegrationTests {

	@Autowired
	private CommandGateway commandGateway;


	@Autowired
	private UserRepository createdByDataRepository;
	@Autowired
	private TenantRepository tenantDataRepository;

	@Test
	void it_should_be_able_to_add_order() {

		OrderRequest requestDTO = new OrderRequest();

		requestDTO.setProductId(UUID.randomUUID().toString());
		requestDTO.setUserId(UUID.randomUUID().toString());
		requestDTO.setIdentifiant(UUID.randomUUID().toString());
		requestDTO.setTelephone(UUID.randomUUID().toString());
		requestDTO.setMail(UUID.randomUUID().toString());
		requestDTO.setVille(UUID.randomUUID().toString());
		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setBuyerName(UUID.randomUUID().toString());
		requestDTO.setAddress(UUID.randomUUID().toString());
		requestDTO.setNotes(UUID.randomUUID().toString());
		requestDTO.setMessage(UUID.randomUUID().toString());
		requestDTO.setTypeOrder(UUID.randomUUID().toString());
		requestDTO.setPaymentMethod(UUID.randomUUID().toString());
		requestDTO.setDeliveryMethod(UUID.randomUUID().toString());
		requestDTO.setAmountCents(1677.53);
		requestDTO.setQuantity(77);
		requestDTO.setDateCommand(java.time.Instant.now().plusSeconds(3600));

		String uri = "/v1/commands/order";
		ResponseEntity<OrderResponse> response = this.postForEntity(uri, requestDTO, OrderResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getProductId()).isEqualTo(requestDTO.getProductId());
		assertThat(response.getBody().getUserId()).isEqualTo(requestDTO.getUserId());
		assertThat(response.getBody().getIdentifiant()).isEqualTo(requestDTO.getIdentifiant());
		assertThat(response.getBody().getTelephone()).isEqualTo(requestDTO.getTelephone());
		assertThat(response.getBody().getMail()).isEqualTo(requestDTO.getMail());
		assertThat(response.getBody().getVille()).isEqualTo(requestDTO.getVille());
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getBuyerName()).isEqualTo(requestDTO.getBuyerName());
		assertThat(response.getBody().getAddress()).isEqualTo(requestDTO.getAddress());
		assertThat(response.getBody().getNotes()).isEqualTo(requestDTO.getNotes());
		assertThat(response.getBody().getMessage()).isEqualTo(requestDTO.getMessage());
		assertThat(response.getBody().getTypeOrder()).isEqualTo(requestDTO.getTypeOrder());
		assertThat(response.getBody().getPaymentMethod()).isEqualTo(requestDTO.getPaymentMethod());
		assertThat(response.getBody().getDeliveryMethod()).isEqualTo(requestDTO.getDeliveryMethod());
		assertThat(response.getBody().getAmountCents()).isEqualTo(requestDTO.getAmountCents());
		assertThat(response.getBody().getQuantity()).isEqualTo(requestDTO.getQuantity());
		assertThat(response.getBody().getDateCommand()).isEqualTo(requestDTO.getDateCommand());
	}
}
