package com.groupe2cs.bizyhub.settings.application;

import com.groupe2cs.bizyhub.settings.application.command.CreateSettingCommand;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateSettingCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateSettingCommand command = new CreateSettingCommand(
				SettingId.create(UUID.randomUUID().toString()),
				SettingName.create(UUID.randomUUID().toString()),
				SettingValue.create(UUID.randomUUID().toString()),
				SettingLocale.create(UUID.randomUUID().toString()),
				SettingRemoteId.create(UUID.randomUUID().toString()),
				SettingLocalId.create(UUID.randomUUID().toString()),
				SettingAccount.create(UUID.randomUUID().toString()),
				SettingDetails.create(UUID.randomUUID().toString()),
				SettingSyncAt.create(java.time.Instant.now().plusSeconds(3600)),
				SettingIsActive.create(false),
				SettingCreatedBy.create(UUID.randomUUID().toString()),
				SettingTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateSettingCommand> commandCaptor = ArgumentCaptor.forClass(CreateSettingCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateSettingCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getName().value()).isEqualTo(
				command.getName().value());
		assertThat(sentCommand.getValue().value()).isEqualTo(
				command.getValue().value());
		assertThat(sentCommand.getLocale().value()).isEqualTo(
				command.getLocale().value());
		assertThat(sentCommand.getRemoteId().value()).isEqualTo(
				command.getRemoteId().value());
		assertThat(sentCommand.getLocalId().value()).isEqualTo(
				command.getLocalId().value());
		assertThat(sentCommand.getAccount().value()).isEqualTo(
				command.getAccount().value());
		assertThat(sentCommand.getDetails().value()).isEqualTo(
				command.getDetails().value());
		assertThat(sentCommand.getSyncAt().value()).isEqualTo(
				command.getSyncAt().value());
		assertThat(sentCommand.getIsActive().value()).isEqualTo(
				command.getIsActive().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
