package com.groupe2cs.bizyhub.fileManager.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.fileManager.application.command.*;
import com.groupe2cs.bizyhub.fileManager.domain.event.*;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
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

public class CreateFileManagerCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateFileManagerCommand command = new CreateFileManagerCommand(
 FileManagerId.create(UUID.randomUUID().toString()) ,  FileManagerName.create(UUID.randomUUID().toString()) ,  FileManagerDetails.create(UUID.randomUUID().toString()) ,  FileManagerObjectId.create(UUID.randomUUID().toString()) ,  FileManagerObjectName.create(UUID.randomUUID().toString()) ,  FileManagerOriginalName.create(UUID.randomUUID().toString()) ,  FileManagerMimeType.create(UUID.randomUUID().toString()) ,  FileManagerSize.create(2808L) ,  FileManagerPath.create(UUID.randomUUID().toString()) ,  FileManagerUri.create(UUID.randomUUID().toString()) ,  FileManagerIsPublic.create(false) ,  FileManagerCreatedBy.create(UUID.randomUUID().toString()) ,  FileManagerTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateFileManagerCommand> commandCaptor = ArgumentCaptor.forClass(CreateFileManagerCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateFileManagerCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getDetails().value()).isEqualTo(
command.getDetails().value());
assertThat(sentCommand.getObjectId().value()).isEqualTo(
command.getObjectId().value());
assertThat(sentCommand.getObjectName().value()).isEqualTo(
command.getObjectName().value());
assertThat(sentCommand.getOriginalName().value()).isEqualTo(
command.getOriginalName().value());
assertThat(sentCommand.getMimeType().value()).isEqualTo(
command.getMimeType().value());
assertThat(sentCommand.getSize().value()).isEqualTo(
command.getSize().value());
assertThat(sentCommand.getPath().value()).isEqualTo(
command.getPath().value());
assertThat(sentCommand.getUri().value()).isEqualTo(
command.getUri().value());
assertThat(sentCommand.getIsPublic().value()).isEqualTo(
command.getIsPublic().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
