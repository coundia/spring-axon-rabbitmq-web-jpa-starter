package com.groupe2cs.bizyhub.stock.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.stock.application.command.*;
import com.groupe2cs.bizyhub.stock.domain.event.*;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
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

public class CreateStockMovementCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateStockMovementCommand command = new CreateStockMovementCommand(
 StockMovementId.create(UUID.randomUUID().toString()) ,  StockMovementTypeStockMovement.create(UUID.randomUUID().toString()) ,  StockMovementQuantity.create(95) ,  StockMovementRemoteId.create(UUID.randomUUID().toString()) ,  StockMovementLocalId.create(UUID.randomUUID().toString()) ,  StockMovementAccount.create(UUID.randomUUID().toString()) ,  StockMovementCompany.create(UUID.randomUUID().toString()) ,  StockMovementSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  StockMovementProductVariant.create(UUID.randomUUID().toString()) ,  StockMovementOrderLineId.create(UUID.randomUUID().toString()) ,  StockMovementDiscriminator.create(UUID.randomUUID().toString()) ,  StockMovementCreatedBy.create(UUID.randomUUID().toString()) ,  StockMovementTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateStockMovementCommand> commandCaptor = ArgumentCaptor.forClass(CreateStockMovementCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateStockMovementCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getTypeStockMovement().value()).isEqualTo(
command.getTypeStockMovement().value());
assertThat(sentCommand.getQuantity().value()).isEqualTo(
command.getQuantity().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getLocalId().value()).isEqualTo(
command.getLocalId().value());
assertThat(sentCommand.getAccount().value()).isEqualTo(
command.getAccount().value());
assertThat(sentCommand.getCompany().value()).isEqualTo(
command.getCompany().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getProductVariant().value()).isEqualTo(
command.getProductVariant().value());
assertThat(sentCommand.getOrderLineId().value()).isEqualTo(
command.getOrderLineId().value());
assertThat(sentCommand.getDiscriminator().value()).isEqualTo(
command.getDiscriminator().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
