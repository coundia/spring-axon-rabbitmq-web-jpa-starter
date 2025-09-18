package com.groupe2cs.bizyhub.companies.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.companies.application.command.*;
import com.groupe2cs.bizyhub.companies.domain.event.*;
import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
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

public class CreateCompanyCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateCompanyCommand command = new CreateCompanyCommand(
 CompanyId.create(UUID.randomUUID().toString()) ,  CompanyRemoteId.create(UUID.randomUUID().toString()) ,  CompanyLocalId.create(UUID.randomUUID().toString()) ,  CompanyCode.create(UUID.randomUUID().toString()) ,  CompanyName.create(UUID.randomUUID().toString()) ,  CompanyDescription.create(UUID.randomUUID().toString()) ,  CompanyPhone.create(UUID.randomUUID().toString()) ,  CompanyEmail.create(UUID.randomUUID().toString()) ,  CompanyWebsite.create(UUID.randomUUID().toString()) ,  CompanyTaxId.create(UUID.randomUUID().toString()) ,  CompanyCurrency.create(UUID.randomUUID().toString()) ,  CompanyAddressLine1.create(UUID.randomUUID().toString()) ,  CompanyAddressLine2.create(UUID.randomUUID().toString()) ,  CompanyCity.create(UUID.randomUUID().toString()) ,  CompanyRegion.create(UUID.randomUUID().toString()) ,  CompanyCountry.create(UUID.randomUUID().toString()) ,  CompanyAccount.create(UUID.randomUUID().toString()) ,  CompanyPostalCode.create(UUID.randomUUID().toString()) ,  CompanyIsActive.create(false) ,  CompanyStatus.create(UUID.randomUUID().toString()) ,  CompanyIsPublic.create(true) ,  CompanySyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  CompanyIsDefault.create(true) ,  CompanyCreatedBy.create(UUID.randomUUID().toString()) ,  CompanyTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateCompanyCommand> commandCaptor = ArgumentCaptor.forClass(CreateCompanyCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateCompanyCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getLocalId().value()).isEqualTo(
command.getLocalId().value());
assertThat(sentCommand.getCode().value()).isEqualTo(
command.getCode().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getDescription().value()).isEqualTo(
command.getDescription().value());
assertThat(sentCommand.getPhone().value()).isEqualTo(
command.getPhone().value());
assertThat(sentCommand.getEmail().value()).isEqualTo(
command.getEmail().value());
assertThat(sentCommand.getWebsite().value()).isEqualTo(
command.getWebsite().value());
assertThat(sentCommand.getTaxId().value()).isEqualTo(
command.getTaxId().value());
assertThat(sentCommand.getCurrency().value()).isEqualTo(
command.getCurrency().value());
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
assertThat(sentCommand.getAccount().value()).isEqualTo(
command.getAccount().value());
assertThat(sentCommand.getPostalCode().value()).isEqualTo(
command.getPostalCode().value());
assertThat(sentCommand.getIsActive().value()).isEqualTo(
command.getIsActive().value());
assertThat(sentCommand.getStatus().value()).isEqualTo(
command.getStatus().value());
assertThat(sentCommand.getIsPublic().value()).isEqualTo(
command.getIsPublic().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getIsDefault().value()).isEqualTo(
command.getIsDefault().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
