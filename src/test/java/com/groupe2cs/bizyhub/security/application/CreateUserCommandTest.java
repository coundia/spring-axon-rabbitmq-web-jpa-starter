package com.groupe2cs.bizyhub.security.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.security.application.command.CreateUserCommand;
import com.groupe2cs.bizyhub.security.domain.event.UserCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserPassword;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserUsername;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateUserCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateUserCommand command = new CreateUserCommand(
				UserId.create(UUID.randomUUID().toString()),
				UserUsername.create(UUID.randomUUID().toString()),
				UserPassword.create(UUID.randomUUID().toString()),
				UserCreatedBy.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateUserCommand> commandCaptor = ArgumentCaptor.forClass(CreateUserCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateUserCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getUsername().value()).isEqualTo(
				command.getUsername().value());
		assertThat(sentCommand.getPassword().value()).isEqualTo(
				command.getPassword().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
	}

	@Test
	void test_event_serialization() throws JsonProcessingException {
		UserCreatedEvent
				event =
				new UserCreatedEvent(UserId.create(UUID.randomUUID().toString()),
						UserUsername.create(UUID.randomUUID().toString()),
						UserPassword.create(UUID.randomUUID().toString()),
						UserCreatedBy.create(UUID.randomUUID().toString()));
		String json = new ObjectMapper().writeValueAsString(event);
		assertThat(json).isNotEmpty();
	}
}
