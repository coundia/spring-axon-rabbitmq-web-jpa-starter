package com.groupe2cs.bizyhub.accounts.application;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountUserCommand;
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

public class CreateAccountUserCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateAccountUserCommand command = new CreateAccountUserCommand(
				AccountUserId.create(UUID.randomUUID().toString()),
				AccountUserName.create(UUID.randomUUID().toString()),
				AccountUserAccount.create(UUID.randomUUID().toString()),
				AccountUserUser.create(UUID.randomUUID().toString()),
				AccountUserUsername.create(UUID.randomUUID().toString()),
				AccountUserDetails.create(UUID.randomUUID().toString()),
				AccountUserIsActive.create(true),
				AccountUserCreatedBy.create(UUID.randomUUID().toString()),
				AccountUserTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateAccountUserCommand>
				commandCaptor =
				ArgumentCaptor.forClass(CreateAccountUserCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateAccountUserCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getName().value()).isEqualTo(
				command.getName().value());
		assertThat(sentCommand.getAccount().value()).isEqualTo(
				command.getAccount().value());
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
