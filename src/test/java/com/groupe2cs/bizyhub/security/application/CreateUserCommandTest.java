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

public class CreateUserCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateUserCommand command = new CreateUserCommand(
				UserId.create(UUID.randomUUID().toString()),
				UserUsername.create(UUID.randomUUID().toString()),
				UserPassword.create(UUID.randomUUID().toString()),
				UserFirstName.create(UUID.randomUUID().toString()),
				UserLastName.create(UUID.randomUUID().toString()),
				UserEmail.create(UUID.randomUUID().toString()),
				UserTelephone.create(UUID.randomUUID().toString()),
				UserLimitPerDay.create(88),
				UserIsPremium.create(false),
				UserEnabled.create(false),
				UserIsBan.create(true),
				UserMessage.create(UUID.randomUUID().toString()),
				UserCreatedBy.create(UUID.randomUUID().toString()),
				UserTenant.create(UUID.randomUUID().toString())
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
		assertThat(sentCommand.getFirstName().value()).isEqualTo(
				command.getFirstName().value());
		assertThat(sentCommand.getLastName().value()).isEqualTo(
				command.getLastName().value());
		assertThat(sentCommand.getEmail().value()).isEqualTo(
				command.getEmail().value());
		assertThat(sentCommand.getTelephone().value()).isEqualTo(
				command.getTelephone().value());
		assertThat(sentCommand.getLimitPerDay().value()).isEqualTo(
				command.getLimitPerDay().value());
		assertThat(sentCommand.getIsPremium().value()).isEqualTo(
				command.getIsPremium().value());
		assertThat(sentCommand.getEnabled().value()).isEqualTo(
				command.getEnabled().value());
		assertThat(sentCommand.getIsBan().value()).isEqualTo(
				command.getIsBan().value());
		assertThat(sentCommand.getMessage().value()).isEqualTo(
				command.getMessage().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
