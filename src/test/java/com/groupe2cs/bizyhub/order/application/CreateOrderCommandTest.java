package com.groupe2cs.bizyhub.order.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.order.application.command.*;
import com.groupe2cs.bizyhub.order.domain.event.*;
import com.groupe2cs.bizyhub.order.domain.valueObject.*;
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

public class CreateOrderCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateOrderCommand command = new CreateOrderCommand(
 OrderId.create(UUID.randomUUID().toString()) ,  OrderProductId.create(UUID.randomUUID().toString()) ,  OrderUserId.create(UUID.randomUUID().toString()) ,  OrderIdentifiant.create(UUID.randomUUID().toString()) ,  OrderTelephone.create(UUID.randomUUID().toString()) ,  OrderMail.create(UUID.randomUUID().toString()) ,  OrderVille.create(UUID.randomUUID().toString()) ,  OrderRemoteId.create(UUID.randomUUID().toString()) ,  OrderLocalId.create(UUID.randomUUID().toString()) ,  OrderStatus.create(UUID.randomUUID().toString()) ,  OrderBuyerName.create(UUID.randomUUID().toString()) ,  OrderAddress.create(UUID.randomUUID().toString()) ,  OrderNotes.create(UUID.randomUUID().toString()) ,  OrderMessage.create(UUID.randomUUID().toString()) ,  OrderTypeOrder.create(UUID.randomUUID().toString()) ,  OrderPaymentMethod.create(UUID.randomUUID().toString()) ,  OrderDeliveryMethod.create(UUID.randomUUID().toString()) ,  OrderAmountCents.create(3545.36) ,  OrderQuantity.create(50) ,  OrderDateCommand.create(java.time.Instant.now().plusSeconds(3600)) ,  OrderCreatedBy.create(UUID.randomUUID().toString()) ,  OrderTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateOrderCommand> commandCaptor = ArgumentCaptor.forClass(CreateOrderCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateOrderCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getProductId().value()).isEqualTo(
command.getProductId().value());
assertThat(sentCommand.getUserId().value()).isEqualTo(
command.getUserId().value());
assertThat(sentCommand.getIdentifiant().value()).isEqualTo(
command.getIdentifiant().value());
assertThat(sentCommand.getTelephone().value()).isEqualTo(
command.getTelephone().value());
assertThat(sentCommand.getMail().value()).isEqualTo(
command.getMail().value());
assertThat(sentCommand.getVille().value()).isEqualTo(
command.getVille().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getLocalId().value()).isEqualTo(
command.getLocalId().value());
assertThat(sentCommand.getStatus().value()).isEqualTo(
command.getStatus().value());
assertThat(sentCommand.getBuyerName().value()).isEqualTo(
command.getBuyerName().value());
assertThat(sentCommand.getAddress().value()).isEqualTo(
command.getAddress().value());
assertThat(sentCommand.getNotes().value()).isEqualTo(
command.getNotes().value());
assertThat(sentCommand.getMessage().value()).isEqualTo(
command.getMessage().value());
assertThat(sentCommand.getTypeOrder().value()).isEqualTo(
command.getTypeOrder().value());
assertThat(sentCommand.getPaymentMethod().value()).isEqualTo(
command.getPaymentMethod().value());
assertThat(sentCommand.getDeliveryMethod().value()).isEqualTo(
command.getDeliveryMethod().value());
assertThat(sentCommand.getAmountCents().value()).isEqualTo(
command.getAmountCents().value());
assertThat(sentCommand.getQuantity().value()).isEqualTo(
command.getQuantity().value());
assertThat(sentCommand.getDateCommand().value()).isEqualTo(
command.getDateCommand().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
