package com.groupe2cs.bizyhub.units.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.units.application.command.*;
import com.groupe2cs.bizyhub.units.domain.event.*;
import com.groupe2cs.bizyhub.units.domain.valueObject.*;
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

public class CreateUnitCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateUnitCommand command = new CreateUnitCommand(
 UnitId.create(UUID.randomUUID().toString()) ,  UnitRemoteId.create(UUID.randomUUID().toString()) ,  UnitLocalId.create(UUID.randomUUID().toString()) ,  UnitCode.create(UUID.randomUUID().toString()) ,  UnitName.create(UUID.randomUUID().toString()) ,  UnitSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  UnitDescription.create(UUID.randomUUID().toString()) ,  UnitCreatedBy.create(UUID.randomUUID().toString()) ,  UnitTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateUnitCommand> commandCaptor = ArgumentCaptor.forClass(CreateUnitCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateUnitCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getLocalId().value()).isEqualTo(
command.getLocalId().value());
assertThat(sentCommand.getCode().value()).isEqualTo(
command.getCode().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getDescription().value()).isEqualTo(
command.getDescription().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
