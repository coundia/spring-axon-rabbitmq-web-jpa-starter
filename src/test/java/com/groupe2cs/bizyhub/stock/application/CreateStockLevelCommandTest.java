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

public class CreateStockLevelCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateStockLevelCommand command = new CreateStockLevelCommand(
 StockLevelId.create(UUID.randomUUID().toString()) ,  StockLevelRemoteId.create(UUID.randomUUID().toString()) ,  StockLevelLocalId.create(UUID.randomUUID().toString()) ,  StockLevelStockOnHand.create(28) ,  StockLevelStockAllocated.create(33) ,  StockLevelAccount.create(UUID.randomUUID().toString()) ,  StockLevelProductVariant.create(UUID.randomUUID().toString()) ,  StockLevelSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  StockLevelCompany.create(UUID.randomUUID().toString()) ,  StockLevelCreatedBy.create(UUID.randomUUID().toString()) ,  StockLevelTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateStockLevelCommand> commandCaptor = ArgumentCaptor.forClass(CreateStockLevelCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateStockLevelCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getLocalId().value()).isEqualTo(
command.getLocalId().value());
assertThat(sentCommand.getStockOnHand().value()).isEqualTo(
command.getStockOnHand().value());
assertThat(sentCommand.getStockAllocated().value()).isEqualTo(
command.getStockAllocated().value());
assertThat(sentCommand.getAccount().value()).isEqualTo(
command.getAccount().value());
assertThat(sentCommand.getProductVariant().value()).isEqualTo(
command.getProductVariant().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getCompany().value()).isEqualTo(
command.getCompany().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
