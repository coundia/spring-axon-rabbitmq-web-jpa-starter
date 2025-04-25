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
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Autowired
private TransactionRepository transactionRepository;

private void waitForTransaction(String TransactionId) {
long timeout = Duration.ofSeconds(5).toMillis();
long start = System.currentTimeMillis();
while (System.currentTimeMillis() - start < timeout) {
if (transactionRepository.findById(TransactionId).isPresent()) {
return;
}
try {
Thread.sleep(100);
} catch (InterruptedException ignored) {
}
}
throw new RuntimeException("Transaction not found after timeout: " + TransactionId);
}

@Test
void it_should_be_able_to_get_all_Transactions_as_admin() {
var userId = login("admin", "admin");

//TransactionFixtures.deleteAll(transactionRepository);

List<CreateTransactionCommand> commands = TransactionFixtures
	.randomManyViaCommand(commandGateway, 5, userId);

	commands.forEach(cmd -> waitForTransaction(cmd.getId().value()));

	String uri = "/v1/queries/transactions";
	ResponseEntity<TransactionPagedResponse> response = this.getForEntity(uri, TransactionPagedResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getContent()).hasSizeGreaterThanOrEqualTo(5);
		}

		@Test
		void it_should_only_return_user_Transactions_as_normal_user() {
		var userId = login("user", "user");

		List<CreateTransactionCommand> list1 = TransactionFixtures.randomManyViaCommand(commandGateway, 3, userId);
			List<CreateTransactionCommand> list2 = TransactionFixtures.randomManyViaCommand(commandGateway, 2, userId);

				list1.forEach(cmd -> waitForTransaction(cmd.getId().value()));
				list2.forEach(cmd -> waitForTransaction(cmd.getId().value()));

				String uri = "/v1/queries/transactions";
				ResponseEntity<TransactionPagedResponse> response = this.getForEntity(uri, TransactionPagedResponse.class);

					assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
					assertThat(response.getBody()).isNotNull();
					assertThat(response.getBody().getContent())
					.allSatisfy(Transaction -> assertThat(Transaction.getCreatedBy()).isEqualTo(userId));
					}
					}
