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

public class CreateTransactionCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateTransactionCommand command = new CreateTransactionCommand(
 TransactionId.create(UUID.randomUUID().toString()) ,  TransactionName.create(UUID.randomUUID().toString()) ,  TransactionAmount.create(1670.4) ,  TransactionDetails.create(UUID.randomUUID().toString()) ,  TransactionIsActive.create(false) ,  TransactionAccount.create(UUID.randomUUID().toString()) ,  TransactionCategory.create(UUID.randomUUID().toString()) ,  TransactionTypeTransactionRaw.create(UUID.randomUUID().toString()) ,  TransactionDateTransaction.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionReference.create(UUID.randomUUID().toString()) ,  TransactionCreatedBy.create(UUID.randomUUID().toString()) ,  TransactionTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateTransactionCommand> commandCaptor = ArgumentCaptor.forClass(CreateTransactionCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateTransactionCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getAmount().value()).isEqualTo(
command.getAmount().value());
assertThat(sentCommand.getDetails().value()).isEqualTo(
command.getDetails().value());
assertThat(sentCommand.getIsActive().value()).isEqualTo(
command.getIsActive().value());
assertThat(sentCommand.getAccount().value()).isEqualTo(
command.getAccount().value());
assertThat(sentCommand.getCategory().value()).isEqualTo(
command.getCategory().value());
assertThat(sentCommand.getTypeTransactionRaw().value()).isEqualTo(
command.getTypeTransactionRaw().value());
assertThat(sentCommand.getDateTransaction().value()).isEqualTo(
command.getDateTransaction().value());
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
