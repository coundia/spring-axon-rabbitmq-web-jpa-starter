package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

public class TransactionsDeleteControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private TransactionsRepository transactionsRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_delete_transactions() {
String existingId = TransactionsFixtures.randomOneViaCommand(commandGateway);
String uri = "/v1/commands/transactions/" + existingId;

ResponseEntity<String> rep = this.delete(uri);
assertThat(rep.getStatusCode().value()).isEqualTo(200);

Transactions found = TransactionsFixtures.byIdWaitNotExist(transactionsRepository, existingId);
assertThat(found).isNull();
}
}
