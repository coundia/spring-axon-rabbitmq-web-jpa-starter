package com.groupe2cs.bizyhub.transactions.application;

import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionUserCommand;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateTransactionUserCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateTransactionUserCommand command = new CreateTransactionUserCommand(
				TransactionUserId.create(UUID.randomUUID().toString()),
				TransactionUserName.create(UUID.randomUUID().toString()),
				TransactionUserTransaction.create(UUID.randomUUID().toString()),
				TransactionUserUser.create(UUID.randomUUID().toString()),
				TransactionUserUsername.create(UUID.randomUUID().toString()),
				TransactionUserDetails.create(UUID.randomUUID().toString()),
				TransactionUserIsActive.create(true),
				TransactionUserCreatedBy.create(UUID.randomUUID().toString()),
				TransactionUserTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateTransactionUserCommand>
				commandCaptor =
				ArgumentCaptor.forClass(CreateTransactionUserCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateTransactionUserCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getName().value()).isEqualTo(
				command.getName().value());
		assertThat(sentCommand.getTransaction().value()).isEqualTo(
				command.getTransaction().value());
		assertThat(sentCommand.getUser().value()).isEqualTo(
				command.getUser().value());
		assertThat(sentCommand.getUsername().value()).isEqualTo(
				command.getUsername().value());
		assertThat(sentCommand.getDetails().value()).isEqualTo(
				command.getDetails().value());
		assertThat(sentCommand.getIsActive().value()).isEqualTo(
				command.getIsActive().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
