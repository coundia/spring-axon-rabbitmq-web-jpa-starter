package com.groupe2cs.bizyhub.accounts.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import com.groupe2cs.bizyhub.accounts.domain.event.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
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

public class CreateAccountCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateAccountCommand command = new CreateAccountCommand(
 AccountId.create(UUID.randomUUID().toString()) ,  AccountName.create(UUID.randomUUID().toString()) ,  AccountCurrency.create(UUID.randomUUID().toString()) ,  AccountCurrentBalance.create(6999.99) ,  AccountPreviousBalance.create(8506.97) ,  AccountDetails.create(UUID.randomUUID().toString()) ,  AccountIsActive.create(false) ,  AccountUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  AccountReference.create(UUID.randomUUID().toString()) ,  AccountCreatedBy.create(UUID.randomUUID().toString()) ,  AccountTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateAccountCommand> commandCaptor = ArgumentCaptor.forClass(CreateAccountCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateAccountCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getCurrency().value()).isEqualTo(
command.getCurrency().value());
assertThat(sentCommand.getCurrentBalance().value()).isEqualTo(
command.getCurrentBalance().value());
assertThat(sentCommand.getPreviousBalance().value()).isEqualTo(
command.getPreviousBalance().value());
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
