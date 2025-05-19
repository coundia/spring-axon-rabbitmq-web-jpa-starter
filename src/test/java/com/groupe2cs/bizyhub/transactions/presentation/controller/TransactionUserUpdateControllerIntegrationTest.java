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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionUserUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private TransactionUserRepository transactionuserRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;

@Autowired
private com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository transactionDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository userDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_update_transactionuser() {

	String existingId = TransactionUserFixtures.randomOneViaCommand(
	commandGateway,transactionuserRepository,
        transactionDataRepository,
        userDataRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser() ).getId().value();

	CreateTransactionUserCommand updated = TransactionUserFixtures.randomOneViaCommand(commandGatewayUpdate,
    transactionuserRepository,
            transactionDataRepository,
            userDataRepository,
            createdByDataRepository,
            tenantDataRepository,
     getCurrentUser());

	TransactionUserFixtures.byIdWaitExist(transactionuserRepository, existingId);
	TransactionUserFixtures.byIdWaitExist(transactionuserRepository, updated.getId().value());

	TransactionUserRequest requestDTO = new TransactionUserRequest();
	 requestDTO.setName(UUID.randomUUID().toString());
	 requestDTO.setTransaction( updated.getTransaction().value());
	 requestDTO.setUser( updated.getUser().value());
	 requestDTO.setUsername(UUID.randomUUID().toString());
	 requestDTO.setDetails(UUID.randomUUID().toString());
	 requestDTO.setIsActive(false);
	 requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setReference(UUID.randomUUID().toString());

	String uri = "/v1/commands/transactionUser/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
