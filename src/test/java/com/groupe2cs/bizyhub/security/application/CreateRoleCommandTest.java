package com.groupe2cs.bizyhub.security.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.security.application.command.CreateRoleCommand;
import com.groupe2cs.bizyhub.security.domain.event.RoleCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleName;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateRoleCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateRoleCommand command = new CreateRoleCommand(
				RoleId.create(UUID.randomUUID().toString()), RoleName.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateRoleCommand> commandCaptor = ArgumentCaptor.forClass(CreateRoleCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateRoleCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getName().value()).isEqualTo(
				command.getName().value());
	}

	@Test
	void test_event_serialization() throws JsonProcessingException {
		RoleCreatedEvent
				event =
				new RoleCreatedEvent(RoleId.create(UUID.randomUUID().toString()),
						RoleName.create(UUID.randomUUID().toString()));
		String json = new ObjectMapper().writeValueAsString(event);
		assertThat(json).isNotEmpty();
	}
}
