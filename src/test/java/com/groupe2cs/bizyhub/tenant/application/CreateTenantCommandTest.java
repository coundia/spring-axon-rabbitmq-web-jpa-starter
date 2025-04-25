package com.groupe2cs.bizyhub.tenant.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import com.groupe2cs.bizyhub.tenant.domain.event.*;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
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

public class CreateTenantCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateTenantCommand command = new CreateTenantCommand(
 TenantId.create(UUID.randomUUID().toString()) ,  TenantName.create(UUID.randomUUID().toString()) ,  TenantDescription.create(UUID.randomUUID().toString()) ,  TenantDomain.create(UUID.randomUUID().toString()) ,  TenantLanguage.create(UUID.randomUUID().toString()) ,  TenantActive.create(false) ,  TenantCreatedBy.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateTenantCommand> commandCaptor = ArgumentCaptor.forClass(CreateTenantCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateTenantCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getDescription().value()).isEqualTo(
command.getDescription().value());
assertThat(sentCommand.getDomain().value()).isEqualTo(
command.getDomain().value());
assertThat(sentCommand.getLanguage().value()).isEqualTo(
command.getLanguage().value());
assertThat(sentCommand.getActive().value()).isEqualTo(
command.getActive().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
}


}
