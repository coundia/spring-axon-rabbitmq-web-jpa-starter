package com.groupe2cs.bizyhub.security.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.domain.event.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateUserRoleCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateUserRoleCommand command = new CreateUserRoleCommand(
				UserRoleId.create(UUID.randomUUID().toString()),
				UserRoleUser.create(UUID.randomUUID().toString()),
				UserRoleRole.create(UUID.randomUUID().toString()),
				UserRoleCreatedBy.create(UUID.randomUUID().toString()),
				UserRoleTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateUserRoleCommand> commandCaptor = ArgumentCaptor.forClass(CreateUserRoleCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateUserRoleCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getUser().value()).isEqualTo(
				command.getUser().value());
		assertThat(sentCommand.getRole().value()).isEqualTo(
				command.getRole().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
