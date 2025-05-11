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

public class TransactionUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private TransactionRepository transactionRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;

@Autowired
private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository ;
@Autowired
private com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository categoryDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_update_transaction() {

	String existingId = TransactionFixtures.randomOneViaCommand(
	commandGateway,transactionRepository,
        accountDataRepository,
        categoryDataRepository,
        createdByDataRepository,
        tenantDataRepository,
	 getCurrentUser() ).getId().value();

	CreateTransactionCommand updated = TransactionFixtures.randomOneViaCommand(commandGatewayUpdate,
    transactionRepository,
            accountDataRepository,
            categoryDataRepository,
            createdByDataRepository,
            tenantDataRepository,
     getCurrentUser());

	TransactionFixtures.byIdWaitExist(transactionRepository, existingId);
	TransactionFixtures.byIdWaitExist(transactionRepository, updated.getId().value());

	TransactionRequest requestDTO = new TransactionRequest();
	 requestDTO.setName(UUID.randomUUID().toString());
	 requestDTO.setAmount(7133.57);
	 requestDTO.setDetails(UUID.randomUUID().toString());
	 requestDTO.setIsActive(false);
	 requestDTO.setAccount( updated.getAccount().value());
	 requestDTO.setCategory( updated.getCategory().value());
	 requestDTO.setTypeTransactionRaw(UUID.randomUUID().toString());
	 requestDTO.setDateTransaction(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setReference(UUID.randomUUID().toString());

	String uri = "/v1/commands/transaction/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}
