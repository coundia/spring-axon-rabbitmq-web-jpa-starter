package com.groupe2cs.bizyhub.settings.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.settings.application.command.*;
import com.groupe2cs.bizyhub.settings.domain.event.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
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

public class CreateSettingCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateSettingCommand command = new CreateSettingCommand(
 SettingId.create(UUID.randomUUID().toString()) ,  SettingName.create(UUID.randomUUID().toString()) ,  SettingValue.create(UUID.randomUUID().toString()) ,  SettingLocale.create(UUID.randomUUID().toString()) ,  SettingDetails.create(UUID.randomUUID().toString()) ,  SettingIsActive.create(true) ,  SettingUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  SettingReference.create(UUID.randomUUID().toString()) ,  SettingCreatedBy.create(UUID.randomUUID().toString()) ,  SettingTenant.create(UUID.randomUUID().toString()) 
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
assertThat(sentCommand.getDetails().value()).isEqualTo(
command.getDetails().value());
assertThat(sentCommand.getIsActive().value()).isEqualTo(
command.getIsActive().value());
assertThat(sentCommand.getUpdatedAt().value()).isEqualTo(
command.getUpdatedAt().value());
assertThat(sentCommand.getReference().value()).isEqualTo(
command.getReference().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
