package com.groupe2cs.bizyhub.transactions.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionItemCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_transactionitem() {

		TransactionItemRequest requestDTO = new TransactionItemRequest();

		requestDTO.setTransaction(UUID.randomUUID().toString());
		requestDTO.setProduct(UUID.randomUUID().toString());
		requestDTO.setLabel(UUID.randomUUID().toString());
		requestDTO.setQuantity(26);
		requestDTO.setUnit(UUID.randomUUID().toString());
		requestDTO.setAccount(UUID.randomUUID().toString());
		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setUnitPrice(1893.57);
		requestDTO.setTotal(5060.91);
		requestDTO.setNotes(UUID.randomUUID().toString());

 		String uri = "/v1/commands/transactionItem";
		ResponseEntity<TransactionItemResponse> response = this.postForEntity(uri, requestDTO, TransactionItemResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getTransaction()).isEqualTo(requestDTO.getTransaction());
		assertThat(response.getBody().getProduct()).isEqualTo(requestDTO.getProduct());
		assertThat(response.getBody().getLabel()).isEqualTo(requestDTO.getLabel());
		assertThat(response.getBody().getQuantity()).isEqualTo(requestDTO.getQuantity());
		assertThat(response.getBody().getUnit()).isEqualTo(requestDTO.getUnit());
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getUnitPrice()).isEqualTo(requestDTO.getUnitPrice());
		assertThat(response.getBody().getTotal()).isEqualTo(requestDTO.getTotal());
		assertThat(response.getBody().getNotes()).isEqualTo(requestDTO.getNotes());
	}
}
