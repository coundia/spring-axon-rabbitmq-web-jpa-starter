package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
import com.groupe2cs.bizyhub.tenant.presentation.controller.TenantFixtures;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class TransactionDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private TransactionRepository transactionRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_delete_transaction() {
	String existingId = TransactionFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();
	String uri = "/v1/commands/transaction/" + existingId;

	ResponseEntity<String> rep = this.delete(uri);
	assertThat(rep.getStatusCode().value()).isEqualTo(200);

	Transaction found = TransactionFixtures.byIdWaitNotExist(transactionRepository, existingId);
	assertThat(found).isNull();
	}
}
