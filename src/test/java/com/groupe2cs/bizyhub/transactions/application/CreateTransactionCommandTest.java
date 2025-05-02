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
 TransactionId.create(UUID.randomUUID().toString()) ,  TransactionAmount.create(4662.49) ,  TransactionDateOperation.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionDescription.create(UUID.randomUUID().toString()) ,  TransactionReference.create(UUID.randomUUID().toString()) ,  TransactionIsRecurring.create(false) ,  TransactionIsExcluToRapport.create(false) ,  TransactionStatus.create(UUID.randomUUID().toString()) ,  TransactionBalance.create(UUID.randomUUID().toString()) ,  TransactionCategory.create(UUID.randomUUID().toString()) ,  TransactionUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionCreatedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionCreatedBy.create(UUID.randomUUID().toString()) ,  TransactionTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateTransactionCommand> commandCaptor = ArgumentCaptor.forClass(CreateTransactionCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateTransactionCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getAmount().value()).isEqualTo(
command.getAmount().value());
assertThat(sentCommand.getDateOperation().value()).isEqualTo(
command.getDateOperation().value());
assertThat(sentCommand.getDescription().value()).isEqualTo(
command.getDescription().value());
assertThat(sentCommand.getReference().value()).isEqualTo(
command.getReference().value());
assertThat(sentCommand.getIsRecurring().value()).isEqualTo(
command.getIsRecurring().value());
assertThat(sentCommand.getIsExcluToRapport().value()).isEqualTo(
command.getIsExcluToRapport().value());
assertThat(sentCommand.getStatus().value()).isEqualTo(
command.getStatus().value());
assertThat(sentCommand.getBalance().value()).isEqualTo(
command.getBalance().value());
assertThat(sentCommand.getCategory().value()).isEqualTo(
command.getCategory().value());
assertThat(sentCommand.getUpdatedAt().value()).isEqualTo(
command.getUpdatedAt().value());
assertThat(sentCommand.getCreatedAt().value()).isEqualTo(
command.getCreatedAt().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
