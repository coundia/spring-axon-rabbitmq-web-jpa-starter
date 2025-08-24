package com.groupe2cs.bizyhub.sync.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sync.application.command.*;
import com.groupe2cs.bizyhub.sync.domain.event.*;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
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

public class CreateSyncStateCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateSyncStateCommand command = new CreateSyncStateCommand(
 SyncStateId.create(UUID.randomUUID().toString()) ,  SyncStateEntityTable.create(UUID.randomUUID().toString()) ,  SyncStateRemoteId.create(UUID.randomUUID().toString()) ,  SyncStateSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  SyncStateLastSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  SyncStateLastCursor.create(UUID.randomUUID().toString()) ,  SyncStateCreatedBy.create(UUID.randomUUID().toString()) ,  SyncStateTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateSyncStateCommand> commandCaptor = ArgumentCaptor.forClass(CreateSyncStateCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateSyncStateCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getEntityTable().value()).isEqualTo(
command.getEntityTable().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getLastSyncAt().value()).isEqualTo(
command.getLastSyncAt().value());
assertThat(sentCommand.getLastCursor().value()).isEqualTo(
command.getLastCursor().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
