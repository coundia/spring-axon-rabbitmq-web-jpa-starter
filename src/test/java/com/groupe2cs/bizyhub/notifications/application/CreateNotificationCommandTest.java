package com.groupe2cs.bizyhub.notifications.application;

import com.groupe2cs.bizyhub.notifications.application.command.CreateNotificationCommand;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateNotificationCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateNotificationCommand command = new CreateNotificationCommand(
				NotificationId.create(UUID.randomUUID().toString()),
				NotificationDeviceToken.create(UUID.randomUUID().toString()),
				NotificationTitle.create(UUID.randomUUID().toString()),
				NotificationMessage.create(UUID.randomUUID().toString()),
				NotificationStatus.create(UUID.randomUUID().toString()),
				NotificationRemoteId.create(UUID.randomUUID().toString()),
				NotificationAccount.create(UUID.randomUUID().toString()),
				NotificationLocalId.create(UUID.randomUUID().toString()),
				NotificationSyncAt.create(java.time.Instant.now().plusSeconds(3600)),
				NotificationReserved.create(UUID.randomUUID().toString()),
				NotificationErrorMessage.create(UUID.randomUUID().toString()),
				NotificationCreatedBy.create(UUID.randomUUID().toString()),
				NotificationTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateNotificationCommand>
				commandCaptor =
				ArgumentCaptor.forClass(CreateNotificationCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateNotificationCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getDeviceToken().value()).isEqualTo(
				command.getDeviceToken().value());
		assertThat(sentCommand.getTitle().value()).isEqualTo(
				command.getTitle().value());
		assertThat(sentCommand.getMessage().value()).isEqualTo(
				command.getMessage().value());
		assertThat(sentCommand.getStatus().value()).isEqualTo(
				command.getStatus().value());
		assertThat(sentCommand.getRemoteId().value()).isEqualTo(
				command.getRemoteId().value());
		assertThat(sentCommand.getAccount().value()).isEqualTo(
				command.getAccount().value());
		assertThat(sentCommand.getLocalId().value()).isEqualTo(
				command.getLocalId().value());
		assertThat(sentCommand.getSyncAt().value()).isEqualTo(
				command.getSyncAt().value());
		assertThat(sentCommand.getReserved().value()).isEqualTo(
				command.getReserved().value());
		assertThat(sentCommand.getErrorMessage().value()).isEqualTo(
				command.getErrorMessage().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
