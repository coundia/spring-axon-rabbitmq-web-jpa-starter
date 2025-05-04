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

public class CreateSettingsCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateSettingsCommand command = new CreateSettingsCommand(
 SettingsId.create(UUID.randomUUID().toString()) ,  SettingsName.create(UUID.randomUUID().toString()) ,  SettingsReference.create(UUID.randomUUID().toString()) ,  SettingsUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  SettingsStringValue.create(UUID.randomUUID().toString()) ,  SettingsDescriptions.create(UUID.randomUUID().toString()) ,  SettingsIsActive.create(true) ,  SettingsCreatedBy.create(UUID.randomUUID().toString()) ,  SettingsTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateSettingsCommand> commandCaptor = ArgumentCaptor.forClass(CreateSettingsCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateSettingsCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getReference().value()).isEqualTo(
command.getReference().value());
assertThat(sentCommand.getUpdatedAt().value()).isEqualTo(
command.getUpdatedAt().value());
assertThat(sentCommand.getStringValue().value()).isEqualTo(
command.getStringValue().value());
assertThat(sentCommand.getDescriptions().value()).isEqualTo(
command.getDescriptions().value());
assertThat(sentCommand.getIsActive().value()).isEqualTo(
command.getIsActive().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
