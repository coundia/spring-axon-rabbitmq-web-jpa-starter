package com.groupe2cs.bizyhub.debts.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.debts.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class DebtCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private com.groupe2cs.bizyhub.customers.infrastructure.repository.CustomerRepository customerDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_debt() {

		DebtRequest requestDTO = new DebtRequest();

		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setCode(UUID.randomUUID().toString());
		requestDTO.setNotes(UUID.randomUUID().toString());
		requestDTO.setBalance(9691.93);
		requestDTO.setBalanceDebt(1046.47);
		requestDTO.setDueDate(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setStatuses(UUID.randomUUID().toString());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setCustomer(com.groupe2cs.bizyhub.customers.infrastructure.entity.CustomerFixtures.randomOneViaCommand(commandGateway,customerDataRepository, user).getId().value());
		requestDTO.setIsActive(true);

 		String uri = "/v1/commands/debt";
		ResponseEntity<DebtResponse> response = this.postForEntity(uri, requestDTO, DebtResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getCode()).isEqualTo(requestDTO.getCode());
		assertThat(response.getBody().getNotes()).isEqualTo(requestDTO.getNotes());
		assertThat(response.getBody().getBalance()).isEqualTo(requestDTO.getBalance());
		assertThat(response.getBody().getBalanceDebt()).isEqualTo(requestDTO.getBalanceDebt());
		assertThat(response.getBody().getDueDate()).isEqualTo(requestDTO.getDueDate());
		assertThat(response.getBody().getStatuses()).isEqualTo(requestDTO.getStatuses());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getCustomer()).isEqualTo(requestDTO.getCustomer());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
	}
}
