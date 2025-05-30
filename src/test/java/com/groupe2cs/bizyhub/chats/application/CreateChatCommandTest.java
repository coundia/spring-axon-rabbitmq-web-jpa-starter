package com.groupe2cs.bizyhub.chats.application;

import com.groupe2cs.bizyhub.chats.application.command.CreateChatCommand;
import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateChatCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateChatCommand command = new CreateChatCommand(
				ChatId.create(UUID.randomUUID().toString()),
				ChatMessages.create(UUID.randomUUID().toString()),
				ChatResponsesJson.create(UUID.randomUUID().toString()),
				ChatResponses.create(UUID.randomUUID().toString()),
				ChatState.create(UUID.randomUUID().toString()),
				ChatAccount.create(UUID.randomUUID().toString()),
				ChatFiles.create(UUID.randomUUID().toString()),
				ChatCreatedBy.create(UUID.randomUUID().toString()),
				ChatTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateChatCommand> commandCaptor = ArgumentCaptor.forClass(CreateChatCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateChatCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getMessages().value()).isEqualTo(
				command.getMessages().value());
		assertThat(sentCommand.getResponsesJson().value()).isEqualTo(
				command.getResponsesJson().value());
		assertThat(sentCommand.getResponses().value()).isEqualTo(
				command.getResponses().value());
		assertThat(sentCommand.getState().value()).isEqualTo(
				command.getState().value());
		assertThat(sentCommand.getAccount().value()).isEqualTo(
				command.getAccount().value());
		assertThat(sentCommand.getFiles().value()).isEqualTo(
				command.getFiles().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
