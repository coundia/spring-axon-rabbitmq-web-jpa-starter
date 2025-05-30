package com.groupe2cs.bizyhub.accounts.application;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountCommand;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateAccountCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateAccountCommand command = new CreateAccountCommand(
				AccountId.create(UUID.randomUUID().toString()),
				AccountName.create(UUID.randomUUID().toString()),
				AccountCurrency.create(UUID.randomUUID().toString()),
				AccountCurrentBalance.create(4189.24),
				AccountPreviousBalance.create(6299.51),
				AccountDetails.create(UUID.randomUUID().toString()),
				AccountIsActive.create(false),
				AccountCreatedBy.create(UUID.randomUUID().toString()),
				AccountTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateAccountCommand> commandCaptor = ArgumentCaptor.forClass(CreateAccountCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateAccountCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getName().value()).isEqualTo(
				command.getName().value());
		assertThat(sentCommand.getCurrency().value()).isEqualTo(
				command.getCurrency().value());
		assertThat(sentCommand.getCurrentBalance().value()).isEqualTo(
				command.getCurrentBalance().value());
		assertThat(sentCommand.getPreviousBalance().value()).isEqualTo(
				command.getPreviousBalance().value());
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
