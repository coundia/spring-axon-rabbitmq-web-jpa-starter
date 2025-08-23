package com.groupe2cs.bizyhub.accounts.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import com.groupe2cs.bizyhub.accounts.domain.event.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
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

public class CreateAccountCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateAccountCommand command = new CreateAccountCommand(
 AccountId.create(UUID.randomUUID().toString()) ,  AccountCode.create(UUID.randomUUID().toString()) ,  AccountName.create(UUID.randomUUID().toString()) ,  AccountStatus.create(UUID.randomUUID().toString()) ,  AccountCurrency.create(UUID.randomUUID().toString()) ,  AccountTypeAccount.create(UUID.randomUUID().toString()) ,  AccountBalance.create(1828.5) ,  AccountBalancePrev.create(9506.57) ,  AccountBalanceBlocked.create(7615.65) ,  AccountBalanceInit.create(7499.17) ,  AccountBalanceGoal.create(8881.8) ,  AccountBalanceLimit.create(5649.62) ,  AccountDescription.create(UUID.randomUUID().toString()) ,  AccountIsActive.create(false) ,  AccountIsDefault.create(true) ,  AccountSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  AccountCreatedBy.create(UUID.randomUUID().toString()) ,  AccountTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateAccountCommand> commandCaptor = ArgumentCaptor.forClass(CreateAccountCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateAccountCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getCode().value()).isEqualTo(
command.getCode().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getStatus().value()).isEqualTo(
command.getStatus().value());
assertThat(sentCommand.getCurrency().value()).isEqualTo(
command.getCurrency().value());
assertThat(sentCommand.getTypeAccount().value()).isEqualTo(
command.getTypeAccount().value());
assertThat(sentCommand.getBalance().value()).isEqualTo(
command.getBalance().value());
assertThat(sentCommand.getBalancePrev().value()).isEqualTo(
command.getBalancePrev().value());
assertThat(sentCommand.getBalanceBlocked().value()).isEqualTo(
command.getBalanceBlocked().value());
assertThat(sentCommand.getBalanceInit().value()).isEqualTo(
command.getBalanceInit().value());
assertThat(sentCommand.getBalanceGoal().value()).isEqualTo(
command.getBalanceGoal().value());
assertThat(sentCommand.getBalanceLimit().value()).isEqualTo(
command.getBalanceLimit().value());
assertThat(sentCommand.getDescription().value()).isEqualTo(
command.getDescription().value());
assertThat(sentCommand.getIsActive().value()).isEqualTo(
command.getIsActive().value());
assertThat(sentCommand.getIsDefault().value()).isEqualTo(
command.getIsDefault().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
