package com.groupe2cs.bizyhub.security.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.security.application.command.CreatePasswordResetCommand;
import com.groupe2cs.bizyhub.security.domain.event.PasswordResetCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetExpiration;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetToken;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetUsername;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreatePasswordResetCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreatePasswordResetCommand command = new CreatePasswordResetCommand(
				PasswordResetId.create(UUID.randomUUID().toString()),
				PasswordResetToken.create(UUID.randomUUID().toString()),
				PasswordResetUsername.create(UUID.randomUUID().toString()),
				PasswordResetExpiration.create(java.time.Instant.now().plusSeconds(3600))
		);
		commandGateway.send(command);

		ArgumentCaptor<CreatePasswordResetCommand>
				commandCaptor =
				ArgumentCaptor.forClass(CreatePasswordResetCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreatePasswordResetCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getToken().value()).isEqualTo(
				command.getToken().value());
		assertThat(sentCommand.getUsername().value()).isEqualTo(
				command.getUsername().value());
		assertThat(sentCommand.getExpiration().value()).isEqualTo(
				command.getExpiration().value());
	}

	@Test
	void test_event_serialization() throws JsonProcessingException {
		PasswordResetCreatedEvent
				event =
				new PasswordResetCreatedEvent(PasswordResetId.create(UUID.randomUUID().toString()),
						PasswordResetToken.create(UUID.randomUUID().toString()),
						PasswordResetUsername.create(UUID.randomUUID().toString()),
						PasswordResetExpiration.create(java.time.Instant.now().plusSeconds(3600)));
		String json = new ObjectMapper().writeValueAsString(event);
		assertThat(json).isNotEmpty();
	}
}
