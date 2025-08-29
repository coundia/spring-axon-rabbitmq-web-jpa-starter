package com.groupe2cs.bizyhub.accounts.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_account() {

		AccountRequest requestDTO = new AccountRequest();

		requestDTO.setCode(UUID.randomUUID().toString());
		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setCurrency(UUID.randomUUID().toString());
		requestDTO.setTypeAccount(UUID.randomUUID().toString());
		requestDTO.setBalance(7209.07);
		requestDTO.setBalancePrev(3440.92);
		requestDTO.setBalanceBlocked(3355.26);
		requestDTO.setBalanceInit(291.32);
		requestDTO.setBalanceGoal(5366.23);
		requestDTO.setBalanceLimit(4494.36);
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setIsActive(false);
		requestDTO.setIsDefault(false);
		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));

 		String uri = "/v1/commands/account";
		ResponseEntity<AccountResponse> response = this.postForEntity(uri, requestDTO, AccountResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getCode()).isEqualTo(requestDTO.getCode());
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getCurrency()).isEqualTo(requestDTO.getCurrency());
		assertThat(response.getBody().getTypeAccount()).isEqualTo(requestDTO.getTypeAccount());
		assertThat(response.getBody().getBalance()).isEqualTo(requestDTO.getBalance());
		assertThat(response.getBody().getBalancePrev()).isEqualTo(requestDTO.getBalancePrev());
		assertThat(response.getBody().getBalanceBlocked()).isEqualTo(requestDTO.getBalanceBlocked());
		assertThat(response.getBody().getBalanceInit()).isEqualTo(requestDTO.getBalanceInit());
		assertThat(response.getBody().getBalanceGoal()).isEqualTo(requestDTO.getBalanceGoal());
		assertThat(response.getBody().getBalanceLimit()).isEqualTo(requestDTO.getBalanceLimit());
		assertThat(response.getBody().getDescription()).isEqualTo(requestDTO.getDescription());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
		assertThat(response.getBody().getIsDefault()).isEqualTo(requestDTO.getIsDefault());
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
	}
}
