package com.groupe2cs.bizyhub.sales.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sales.application.command.*;
import com.groupe2cs.bizyhub.sales.domain.event.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
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

public class CreateSaleUserCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateSaleUserCommand command = new CreateSaleUserCommand(
 SaleUserId.create(UUID.randomUUID().toString()) ,  SaleUserSales.create(UUID.randomUUID().toString()) ,  SaleUserUsers.create(UUID.randomUUID().toString()) ,  SaleUserDetails.create(UUID.randomUUID().toString()) ,  SaleUserIsActive.create(true) ,  SaleUserUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  SaleUserReference.create(UUID.randomUUID().toString()) ,  SaleUserCreatedBy.create(UUID.randomUUID().toString()) ,  SaleUserTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateSaleUserCommand> commandCaptor = ArgumentCaptor.forClass(CreateSaleUserCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateSaleUserCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getSales().value()).isEqualTo(
command.getSales().value());
assertThat(sentCommand.getUsers().value()).isEqualTo(
command.getUsers().value());
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
