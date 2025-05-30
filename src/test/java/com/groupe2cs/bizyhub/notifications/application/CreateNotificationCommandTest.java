package com.groupe2cs.bizyhub.notifications.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.notifications.application.command.*;
import com.groupe2cs.bizyhub.notifications.domain.event.*;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
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

public class CreateNotificationCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateNotificationCommand command = new CreateNotificationCommand(
 NotificationId.create(UUID.randomUUID().toString()) ,  NotificationDeviceToken.create(UUID.randomUUID().toString()) ,  NotificationTitle.create(UUID.randomUUID().toString()) ,  NotificationMessage.create(UUID.randomUUID().toString()) ,  NotificationStatus.create(UUID.randomUUID().toString()) ,  NotificationReserved.create(UUID.randomUUID().toString()) ,  NotificationErrorMessage.create(UUID.randomUUID().toString()) ,  NotificationCreatedBy.create(UUID.randomUUID().toString()) ,  NotificationTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateNotificationCommand> commandCaptor = ArgumentCaptor.forClass(CreateNotificationCommand.class);
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
