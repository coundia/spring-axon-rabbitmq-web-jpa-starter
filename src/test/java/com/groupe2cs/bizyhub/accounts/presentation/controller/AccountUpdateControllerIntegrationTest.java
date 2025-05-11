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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private AccountRepository accountRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;

@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_update_account() {

	String existingId = AccountFixtures.randomOneViaCommand(
	commandGateway,accountRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser() ).getId().value();

	CreateAccountCommand updated = AccountFixtures.randomOneViaCommand(commandGatewayUpdate,
    accountRepository,
            createdByDataRepository,
            tenantDataRepository,
     getCurrentUser());

	AccountFixtures.byIdWaitExist(accountRepository, existingId);
	AccountFixtures.byIdWaitExist(accountRepository, updated.getId().value());

	AccountRequest requestDTO = new AccountRequest();
	 requestDTO.setName(UUID.randomUUID().toString());
	 requestDTO.setCurrency(UUID.randomUUID().toString());
	 requestDTO.setCurrentBalance(6448.17);
	 requestDTO.setPreviousBalance(7658.91);
	 requestDTO.setDetails(UUID.randomUUID().toString());
	 requestDTO.setIsActive(true);
	 requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setReference(UUID.randomUUID().toString());

	String uri = "/v1/commands/account/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
