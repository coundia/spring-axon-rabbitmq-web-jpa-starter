package com.groupe2cs.bizyhub.transactions.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.transactions.domain.event.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
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

public class CreateTransactionsCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateTransactionsCommand command = new CreateTransactionsCommand(
 TransactionsId.create(UUID.randomUUID().toString()) ,  TransactionsReference.create(UUID.randomUUID().toString()) ,  TransactionsAmount.create(6516.01) 
);
commandGateway.send(command);

ArgumentCaptor<CreateTransactionsCommand> commandCaptor = ArgumentCaptor.forClass(CreateTransactionsCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateTransactionsCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getReference().value()).isEqualTo(
command.getReference().value());
assertThat(sentCommand.getAmount().value()).isEqualTo(
command.getAmount().value());
}

@Test
void test_event_serialization() throws JsonProcessingException {
TransactionsCreatedEvent event = new TransactionsCreatedEvent( TransactionsId.create(UUID.randomUUID().toString()),  TransactionsReference.create(UUID.randomUUID().toString()),  TransactionsAmount.create(6516.01));
String json = new ObjectMapper().writeValueAsString(event);
assertThat(json).isNotEmpty();
}
}
