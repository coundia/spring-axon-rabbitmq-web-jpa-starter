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

public class CreateTransactionEntryCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateTransactionEntryCommand command = new CreateTransactionEntryCommand(
 TransactionEntryId.create(UUID.randomUUID().toString()) ,  TransactionEntryRemoteId.create(UUID.randomUUID().toString()) ,  TransactionEntryCode.create(UUID.randomUUID().toString()) ,  TransactionEntryDescription.create(UUID.randomUUID().toString()) ,  TransactionEntryAmount.create(3763.55) ,  TransactionEntryTypeEntry.create(UUID.randomUUID().toString()) ,  TransactionEntryDateTransaction.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionEntryStatus.create(UUID.randomUUID().toString()) ,  TransactionEntryEntityName.create(UUID.randomUUID().toString()) ,  TransactionEntryEntityId.create(UUID.randomUUID().toString()) ,  TransactionEntryAccount.create(UUID.randomUUID().toString()) ,  TransactionEntrySyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionEntryCategory.create(UUID.randomUUID().toString()) ,  TransactionEntryCompany.create(UUID.randomUUID().toString()) ,  TransactionEntryCustomer.create(UUID.randomUUID().toString()) ,  TransactionEntryDebt.create(UUID.randomUUID().toString()) ,  TransactionEntryCreatedBy.create(UUID.randomUUID().toString()) ,  TransactionEntryTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateTransactionEntryCommand> commandCaptor = ArgumentCaptor.forClass(CreateTransactionEntryCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateTransactionEntryCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
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
