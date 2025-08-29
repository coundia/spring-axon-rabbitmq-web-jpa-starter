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

public class CreateChangeLogCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateChangeLogCommand command = new CreateChangeLogCommand(
 ChangeLogId.create(UUID.randomUUID().toString()) ,  ChangeLogEntityTable.create(UUID.randomUUID().toString()) ,  ChangeLogAccount.create(UUID.randomUUID().toString()) ,  ChangeLogRemoteId.create(UUID.randomUUID().toString()) ,  ChangeLogLocalId.create(UUID.randomUUID().toString()) ,  ChangeLogOperation.create(UUID.randomUUID().toString()) ,  ChangeLogPayload.create(UUID.randomUUID().toString()) ,  ChangeLogStatus.create(UUID.randomUUID().toString()) ,  ChangeLogSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  ChangeLogAttempts.create(33) ,  ChangeLogError.create(UUID.randomUUID().toString()) ,  ChangeLogCreatedBy.create(UUID.randomUUID().toString()) ,  ChangeLogTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateChangeLogCommand> commandCaptor = ArgumentCaptor.forClass(CreateChangeLogCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateChangeLogCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getEntityTable().value()).isEqualTo(
command.getEntityTable().value());
assertThat(sentCommand.getAccount().value()).isEqualTo(
command.getAccount().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getLocalId().value()).isEqualTo(
command.getLocalId().value());
assertThat(sentCommand.getOperation().value()).isEqualTo(
command.getOperation().value());
assertThat(sentCommand.getPayload().value()).isEqualTo(
command.getPayload().value());
assertThat(sentCommand.getStatus().value()).isEqualTo(
command.getStatus().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getAttempts().value()).isEqualTo(
command.getAttempts().value());
assertThat(sentCommand.getError().value()).isEqualTo(
command.getError().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
