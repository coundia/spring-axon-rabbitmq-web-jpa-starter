package com.groupe2cs.bizyhub.accounts.application;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountCommand;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateAccountCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateAccountCommand command = new CreateAccountCommand(
				AccountId.create(UUID.randomUUID().toString()),
				AccountCode.create(UUID.randomUUID().toString()),
				AccountName.create(UUID.randomUUID().toString()),
				AccountStatus.create(UUID.randomUUID().toString()),
				AccountCurrency.create(UUID.randomUUID().toString()),
				AccountTypeAccount.create(UUID.randomUUID().toString()),
				AccountBalance.create(2079.16),
				AccountBalancePrev.create(2379.73),
				AccountBalanceBlocked.create(5252.75),
				AccountBalanceInit.create(4767.8),
				AccountBalanceGoal.create(9283.56),
				AccountBalanceLimit.create(4294.49),
				AccountDescription.create(UUID.randomUUID().toString()),
				AccountIsActive.create(true),
				AccountIsDefault.create(false),
				AccountRemoteId.create(UUID.randomUUID().toString()),
				AccountLocalId.create(UUID.randomUUID().toString()),
				AccountSyncAt.create(java.time.Instant.now().plusSeconds(3600)),
				AccountCreatedBy.create(UUID.randomUUID().toString()),
				AccountTenant.create(UUID.randomUUID().toString())
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
		assertThat(sentCommand.getRemoteId().value()).isEqualTo(
				command.getRemoteId().value());
		assertThat(sentCommand.getLocalId().value()).isEqualTo(
				command.getLocalId().value());
		assertThat(sentCommand.getSyncAt().value()).isEqualTo(
				command.getSyncAt().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
