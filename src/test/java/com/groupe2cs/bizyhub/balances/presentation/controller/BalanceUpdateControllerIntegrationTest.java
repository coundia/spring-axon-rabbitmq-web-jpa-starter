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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class BalanceUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private BalanceRepository balanceRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;

@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_update_balance() {

	String existingId = BalanceFixtures.randomOneViaCommand(
	commandGateway,balanceRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser() ).getId().value();

	CreateBalanceCommand updated = BalanceFixtures.randomOneViaCommand(commandGatewayUpdate,
    balanceRepository,
            createdByDataRepository,
            tenantDataRepository,
     getCurrentUser());

	BalanceFixtures.byIdWaitExist(balanceRepository, existingId);
	BalanceFixtures.byIdWaitExist(balanceRepository, updated.getId().value());

	BalanceRequest requestDTO = new BalanceRequest();
	 requestDTO.setName(UUID.randomUUID().toString());
	 requestDTO.setCurrency(UUID.randomUUID().toString());
	 requestDTO.setCurrentBalance(8877.08);
	 requestDTO.setPreviousBalance(7682.77);
	 requestDTO.setLastUpdated(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setIsDefault(false);
	 requestDTO.setOrdre(77);
	 requestDTO.setIsArchived(false);
	 requestDTO.setIsAllowDebit(true);
	 requestDTO.setIsAllowCredit(true);
	 requestDTO.setIsExcluTotal(true);
	 requestDTO.setActivateNotification(false);
	 requestDTO.setSyncedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setReference(UUID.randomUUID().toString());

	String uri = "/v1/commands/balance/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
