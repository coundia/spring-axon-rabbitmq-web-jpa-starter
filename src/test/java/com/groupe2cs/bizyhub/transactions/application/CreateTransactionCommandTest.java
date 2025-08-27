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
 TransactionId.create(UUID.randomUUID().toString()) ,  TransactionRemoteId.create(UUID.randomUUID().toString()) ,  TransactionLocalId.create(UUID.randomUUID().toString()) ,  TransactionCode.create(UUID.randomUUID().toString()) ,  TransactionDescription.create(UUID.randomUUID().toString()) ,  TransactionAmount.create(3561.94) ,  TransactionTypeEntry.create(UUID.randomUUID().toString()) ,  TransactionDateTransaction.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionStatus.create(UUID.randomUUID().toString()) ,  TransactionEntityName.create(UUID.randomUUID().toString()) ,  TransactionEntityId.create(UUID.randomUUID().toString()) ,  TransactionAccount.create(UUID.randomUUID().toString()) ,  TransactionSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionCategory.create(UUID.randomUUID().toString()) ,  TransactionCompany.create(UUID.randomUUID().toString()) ,  TransactionCustomer.create(UUID.randomUUID().toString()) ,  TransactionDebt.create(UUID.randomUUID().toString()) ,  TransactionCreatedBy.create(UUID.randomUUID().toString()) ,  TransactionTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateTransactionCommand> commandCaptor = ArgumentCaptor.forClass(CreateTransactionCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateTransactionCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getLocalId().value()).isEqualTo(
command.getLocalId().value());
assertThat(sentCommand.getCode().value()).isEqualTo(
command.getCode().value());
assertThat(sentCommand.getDescription().value()).isEqualTo(
command.getDescription().value());
assertThat(sentCommand.getAmount().value()).isEqualTo(
command.getAmount().value());
assertThat(sentCommand.getTypeEntry().value()).isEqualTo(
command.getTypeEntry().value());
assertThat(sentCommand.getDateTransaction().value()).isEqualTo(
command.getDateTransaction().value());
assertThat(sentCommand.getStatus().value()).isEqualTo(
command.getStatus().value());
assertThat(sentCommand.getEntityName().value()).isEqualTo(
command.getEntityName().value());
assertThat(sentCommand.getEntityId().value()).isEqualTo(
command.getEntityId().value());
assertThat(sentCommand.getAccount().value()).isEqualTo(
command.getAccount().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getCategory().value()).isEqualTo(
command.getCategory().value());
assertThat(sentCommand.getCompany().value()).isEqualTo(
command.getCompany().value());
assertThat(sentCommand.getCustomer().value()).isEqualTo(
command.getCustomer().value());
assertThat(sentCommand.getDebt().value()).isEqualTo(
command.getDebt().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
