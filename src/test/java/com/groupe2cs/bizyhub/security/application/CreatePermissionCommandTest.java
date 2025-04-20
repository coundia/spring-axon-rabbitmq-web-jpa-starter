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

public class CreatePermissionCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreatePermissionCommand command = new CreatePermissionCommand(
 PermissionId.create(UUID.randomUUID().toString()) ,  PermissionName.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreatePermissionCommand> commandCaptor = ArgumentCaptor.forClass(CreatePermissionCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreatePermissionCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
}

@Test
void test_event_serialization() throws JsonProcessingException {
PermissionCreatedEvent event = new PermissionCreatedEvent( PermissionId.create(UUID.randomUUID().toString()),  PermissionName.create(UUID.randomUUID().toString()));
String json = new ObjectMapper().writeValueAsString(event);
assertThat(json).isNotEmpty();
}
}
