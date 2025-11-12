package com.groupe2cs.bizyhub.message.application;

import com.groupe2cs.bizyhub.message.application.command.CreateMessageCommand;
import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateMessageCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateMessageCommand command = new CreateMessageCommand(
				MessageId.create(UUID.randomUUID().toString()),
				MessageCode.create(UUID.randomUUID().toString()),
				MessageEmail.create(UUID.randomUUID().toString()),
				MessagePhone.create(UUID.randomUUID().toString()),
				MessageContent.create(UUID.randomUUID().toString()),
				MessagePlateforme.create(UUID.randomUUID().toString()),
				MessageSource.create(UUID.randomUUID().toString()),
				MessageAgent.create(UUID.randomUUID().toString()),
				MessageStatus.create(UUID.randomUUID().toString()),
				MessageDescription.create(UUID.randomUUID().toString()),
				MessageIsActive.create(true),
				MessageIsDefault.create(false),
				MessageRemoteId.create(UUID.randomUUID().toString()),
				MessageLocalId.create(UUID.randomUUID().toString()),
				MessageDepotAt.create(java.time.Instant.now().plusSeconds(3600)),
				MessageSyncAt.create(java.time.Instant.now().plusSeconds(3600)),
				MessageCreatedBy.create(UUID.randomUUID().toString()),
				MessageTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateMessageCommand> commandCaptor = ArgumentCaptor.forClass(CreateMessageCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateMessageCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getCode().value()).isEqualTo(
				command.getCode().value());
		assertThat(sentCommand.getEmail().value()).isEqualTo(
				command.getEmail().value());
		assertThat(sentCommand.getPhone().value()).isEqualTo(
				command.getPhone().value());
		assertThat(sentCommand.getContent().value()).isEqualTo(
				command.getContent().value());
		assertThat(sentCommand.getPlateforme().value()).isEqualTo(
				command.getPlateforme().value());
		assertThat(sentCommand.getSource().value()).isEqualTo(
				command.getSource().value());
		assertThat(sentCommand.getAgent().value()).isEqualTo(
				command.getAgent().value());
		assertThat(sentCommand.getStatus().value()).isEqualTo(
				command.getStatus().value());
		assertThat(sentCommand.getDescription().value()).isEqualTo(
				command.getDescription().value());
		assertThat(sentCommand.getIsActive().value()).isEqualTo(
				command.getIsActive().value());
		assertThat(sentCommand.getIsDefault().value()).isEqualTo(
				command.getIsDefault().value());
		assertThat(sentCommand.getRemoteId().value()).isEqualTo(
				command.getRemoteId().value());
		assertThat(sentCommand.getLocalId().value()).isEqualTo(
				command.getLocalId().value());
		assertThat(sentCommand.getDepotAt().value()).isEqualTo(
				command.getDepotAt().value());
		assertThat(sentCommand.getSyncAt().value()).isEqualTo(
				command.getSyncAt().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
