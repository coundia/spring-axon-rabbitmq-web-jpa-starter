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
 ProductId.create(UUID.randomUUID().toString()) ,  ProductName.create(UUID.randomUUID().toString()) ,  ProductPrice.create(7197.61) ,  ProductDetails.create(UUID.randomUUID().toString()) ,  ProductIsActive.create(true) ,  ProductUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  ProductReference.create(UUID.randomUUID().toString()) ,  ProductCreatedBy.create(UUID.randomUUID().toString()) ,  ProductTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateProductCommand> commandCaptor = ArgumentCaptor.forClass(CreateProductCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateProductCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getPrice().value()).isEqualTo(
command.getPrice().value());
assertThat(sentCommand.getDetails().value()).isEqualTo(
command.getDetails().value());
assertThat(sentCommand.getIsActive().value()).isEqualTo(
command.getIsActive().value());
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
