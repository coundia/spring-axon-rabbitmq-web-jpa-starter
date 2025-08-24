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

public class CreateTransactionItemCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateTransactionItemCommand command = new CreateTransactionItemCommand(
 TransactionItemId.create(UUID.randomUUID().toString()) ,  TransactionItemTransaction.create(UUID.randomUUID().toString()) ,  TransactionItemProduct.create(UUID.randomUUID().toString()) ,  TransactionItemLabel.create(UUID.randomUUID().toString()) ,  TransactionItemQuantity.create(23) ,  TransactionItemUnit.create(UUID.randomUUID().toString()) ,  TransactionItemRemoteId.create(UUID.randomUUID().toString()) ,  TransactionItemSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  TransactionItemUnitPrice.create(2617.1) ,  TransactionItemTotal.create(3783.01) ,  TransactionItemNotes.create(UUID.randomUUID().toString()) ,  TransactionItemCreatedBy.create(UUID.randomUUID().toString()) ,  TransactionItemTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateTransactionItemCommand> commandCaptor = ArgumentCaptor.forClass(CreateTransactionItemCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateTransactionItemCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getTransaction().value()).isEqualTo(
command.getTransaction().value());
assertThat(sentCommand.getProduct().value()).isEqualTo(
command.getProduct().value());
assertThat(sentCommand.getLabel().value()).isEqualTo(
command.getLabel().value());
assertThat(sentCommand.getQuantity().value()).isEqualTo(
command.getQuantity().value());
assertThat(sentCommand.getUnit().value()).isEqualTo(
command.getUnit().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getUnitPrice().value()).isEqualTo(
command.getUnitPrice().value());
assertThat(sentCommand.getTotal().value()).isEqualTo(
command.getTotal().value());
assertThat(sentCommand.getNotes().value()).isEqualTo(
command.getNotes().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
