package com.groupe2cs.bizyhub.customers.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.customers.application.command.*;
import com.groupe2cs.bizyhub.customers.domain.event.*;
import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
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

public class CreateCustomerCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateCustomerCommand command = new CreateCustomerCommand(
 CustomerId.create(UUID.randomUUID().toString()) ,  CustomerRemoteId.create(UUID.randomUUID().toString()) ,  CustomerLocalId.create(UUID.randomUUID().toString()) ,  CustomerCode.create(UUID.randomUUID().toString()) ,  CustomerFirstName.create(UUID.randomUUID().toString()) ,  CustomerLastName.create(UUID.randomUUID().toString()) ,  CustomerFullName.create(UUID.randomUUID().toString()) ,  CustomerBalance.create(1237.83) ,  CustomerBalanceDebt.create(5108.02) ,  CustomerPhone.create(UUID.randomUUID().toString()) ,  CustomerEmail.create(UUID.randomUUID().toString()) ,  CustomerNotes.create(UUID.randomUUID().toString()) ,  CustomerStatus.create(UUID.randomUUID().toString()) ,  CustomerAccount.create(UUID.randomUUID().toString()) ,  CustomerCompany.create(UUID.randomUUID().toString()) ,  CustomerAddressLine1.create(UUID.randomUUID().toString()) ,  CustomerAddressLine2.create(UUID.randomUUID().toString()) ,  CustomerCity.create(UUID.randomUUID().toString()) ,  CustomerRegion.create(UUID.randomUUID().toString()) ,  CustomerCountry.create(UUID.randomUUID().toString()) ,  CustomerPostalCode.create(UUID.randomUUID().toString()) ,  CustomerSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  CustomerIsActive.create(false) ,  CustomerCreatedBy.create(UUID.randomUUID().toString()) ,  CustomerTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateCustomerCommand> commandCaptor = ArgumentCaptor.forClass(CreateCustomerCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateCustomerCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getLocalId().value()).isEqualTo(
command.getLocalId().value());
assertThat(sentCommand.getCode().value()).isEqualTo(
command.getCode().value());
assertThat(sentCommand.getFirstName().value()).isEqualTo(
command.getFirstName().value());
assertThat(sentCommand.getLastName().value()).isEqualTo(
command.getLastName().value());
assertThat(sentCommand.getFullName().value()).isEqualTo(
command.getFullName().value());
assertThat(sentCommand.getBalance().value()).isEqualTo(
command.getBalance().value());
assertThat(sentCommand.getBalanceDebt().value()).isEqualTo(
command.getBalanceDebt().value());
assertThat(sentCommand.getPhone().value()).isEqualTo(
command.getPhone().value());
assertThat(sentCommand.getEmail().value()).isEqualTo(
command.getEmail().value());
assertThat(sentCommand.getNotes().value()).isEqualTo(
command.getNotes().value());
assertThat(sentCommand.getStatus().value()).isEqualTo(
command.getStatus().value());
assertThat(sentCommand.getAccount().value()).isEqualTo(
command.getAccount().value());
assertThat(sentCommand.getCompany().value()).isEqualTo(
command.getCompany().value());
assertThat(sentCommand.getAddressLine1().value()).isEqualTo(
command.getAddressLine1().value());
assertThat(sentCommand.getAddressLine2().value()).isEqualTo(
command.getAddressLine2().value());
assertThat(sentCommand.getCity().value()).isEqualTo(
command.getCity().value());
assertThat(sentCommand.getRegion().value()).isEqualTo(
command.getRegion().value());
assertThat(sentCommand.getCountry().value()).isEqualTo(
command.getCountry().value());
assertThat(sentCommand.getPostalCode().value()).isEqualTo(
command.getPostalCode().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getIsActive().value()).isEqualTo(
command.getIsActive().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
