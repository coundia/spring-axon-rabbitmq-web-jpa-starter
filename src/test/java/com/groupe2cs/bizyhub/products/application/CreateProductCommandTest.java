package com.groupe2cs.bizyhub.products.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.products.application.command.*;
import com.groupe2cs.bizyhub.products.domain.event.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
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

public class CreateProductCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateProductCommand command = new CreateProductCommand(
 ProductId.create(UUID.randomUUID().toString()) ,  ProductRemoteId.create(UUID.randomUUID().toString()) ,  ProductCode.create(UUID.randomUUID().toString()) ,  ProductName.create(UUID.randomUUID().toString()) ,  ProductDescription.create(UUID.randomUUID().toString()) ,  ProductBarcode.create(UUID.randomUUID().toString()) ,  ProductUnit.create(UUID.randomUUID().toString()) ,  ProductSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  ProductCategory.create(UUID.randomUUID().toString()) ,  ProductDefaultPrice.create(7840.56) ,  ProductStatuses.create(UUID.randomUUID().toString()) ,  ProductPurchasePrice.create(9583.15) ,  ProductCreatedBy.create(UUID.randomUUID().toString()) ,  ProductTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateProductCommand> commandCaptor = ArgumentCaptor.forClass(CreateProductCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateProductCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getCode().value()).isEqualTo(
command.getCode().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getDescription().value()).isEqualTo(
command.getDescription().value());
assertThat(sentCommand.getBarcode().value()).isEqualTo(
command.getBarcode().value());
assertThat(sentCommand.getUnit().value()).isEqualTo(
command.getUnit().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getCategory().value()).isEqualTo(
command.getCategory().value());
assertThat(sentCommand.getDefaultPrice().value()).isEqualTo(
command.getDefaultPrice().value());
assertThat(sentCommand.getStatuses().value()).isEqualTo(
command.getStatuses().value());
assertThat(sentCommand.getPurchasePrice().value()).isEqualTo(
command.getPurchasePrice().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
