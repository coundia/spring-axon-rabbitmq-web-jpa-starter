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

public class CreateVerificationCodeCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateVerificationCodeCommand command = new CreateVerificationCodeCommand(
 VerificationCodeId.create(UUID.randomUUID().toString()) ,  VerificationCodeToken.create(UUID.randomUUID().toString()) ,  VerificationCodeUsername.create(UUID.randomUUID().toString()) ,  VerificationCodeEmail.create(UUID.randomUUID().toString()) ,  VerificationCodeCode.create(UUID.randomUUID().toString()) ,  VerificationCodeStatus.create(UUID.randomUUID().toString()) ,  VerificationCodeSource.create(UUID.randomUUID().toString()) ,  VerificationCodeExpiration.create(java.time.Instant.now().plusSeconds(3600)) ,  VerificationCodeCreatedBy.create(UUID.randomUUID().toString()) ,  VerificationCodeTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateVerificationCodeCommand> commandCaptor = ArgumentCaptor.forClass(CreateVerificationCodeCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateVerificationCodeCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getToken().value()).isEqualTo(
command.getToken().value());
assertThat(sentCommand.getUsername().value()).isEqualTo(
command.getUsername().value());
assertThat(sentCommand.getEmail().value()).isEqualTo(
command.getEmail().value());
assertThat(sentCommand.getCode().value()).isEqualTo(
command.getCode().value());
assertThat(sentCommand.getStatus().value()).isEqualTo(
command.getStatus().value());
assertThat(sentCommand.getSource().value()).isEqualTo(
command.getSource().value());
assertThat(sentCommand.getExpiration().value()).isEqualTo(
command.getExpiration().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
