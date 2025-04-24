package com.groupe2cs.bizyhub.security.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.security.application.command.CreateUserRoleCommand;
import com.groupe2cs.bizyhub.security.domain.event.UserRoleCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleRole;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleUser;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
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
				UserRoleCreatedBy.create(UUID.randomUUID().toString())
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
	}

	@Test
	void test_event_serialization() throws JsonProcessingException {
		UserRoleCreatedEvent
				event =
				new UserRoleCreatedEvent(UserRoleId.create(UUID.randomUUID().toString()),
						UserRoleUser.create(UUID.randomUUID().toString()),
						UserRoleRole.create(UUID.randomUUID().toString()),
						UserRoleCreatedBy.create(UUID.randomUUID().toString()));
		String json = new ObjectMapper().writeValueAsString(event);
		assertThat(json).isNotEmpty();
	}
}
