package com.groupe2cs.bizyhub.balances.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.balances.application.dto.*;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.*;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.balances.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class BalanceCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_balance() {

		BalanceRequest requestDTO = new BalanceRequest();

		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setCurrency(UUID.randomUUID().toString());
		requestDTO.setCurrentBalance(5442.8);
		requestDTO.setPreviousBalance(9136.02);
		requestDTO.setLastUpdated(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setIsDefault(true);
		requestDTO.setOrdre(97);
		requestDTO.setIsArchived(true);
		requestDTO.setIsAllowDebit(false);
		requestDTO.setIsAllowCredit(false);
		requestDTO.setIsExcluTotal(true);
		requestDTO.setActivateNotification(false);
		requestDTO.setSyncedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

 		String uri = "/v1/commands/balance";
		ResponseEntity<BalanceResponse> response = this.postForEntity(uri, requestDTO, BalanceResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getCurrency()).isEqualTo(requestDTO.getCurrency());
		assertThat(response.getBody().getCurrentBalance()).isEqualTo(requestDTO.getCurrentBalance());
		assertThat(response.getBody().getPreviousBalance()).isEqualTo(requestDTO.getPreviousBalance());
		assertThat(response.getBody().getLastUpdated()).isEqualTo(requestDTO.getLastUpdated());
		assertThat(response.getBody().getIsDefault()).isEqualTo(requestDTO.getIsDefault());
		assertThat(response.getBody().getOrdre()).isEqualTo(requestDTO.getOrdre());
		assertThat(response.getBody().getIsArchived()).isEqualTo(requestDTO.getIsArchived());
		assertThat(response.getBody().getIsAllowDebit()).isEqualTo(requestDTO.getIsAllowDebit());
		assertThat(response.getBody().getIsAllowCredit()).isEqualTo(requestDTO.getIsAllowCredit());
		assertThat(response.getBody().getIsExcluTotal()).isEqualTo(requestDTO.getIsExcluTotal());
		assertThat(response.getBody().getActivateNotification()).isEqualTo(requestDTO.getActivateNotification());
		assertThat(response.getBody().getSyncedAt()).isEqualTo(requestDTO.getSyncedAt());
		assertThat(response.getBody().getUpdatedAt()).isEqualTo(requestDTO.getUpdatedAt());
		assertThat(response.getBody().getReference()).isEqualTo(requestDTO.getReference());
	}
}
