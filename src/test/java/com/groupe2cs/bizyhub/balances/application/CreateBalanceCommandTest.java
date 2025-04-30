package com.groupe2cs.bizyhub.balances.application;

import com.groupe2cs.bizyhub.balances.application.command.CreateBalanceCommand;
import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateBalanceCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateBalanceCommand command = new CreateBalanceCommand(
				BalanceId.create(UUID.randomUUID().toString()),
				BalanceName.create(UUID.randomUUID().toString()),
				BalanceCurrency.create(UUID.randomUUID().toString()),
				BalanceCurrentBalance.create(1238.58),
				BalancePreviousBalance.create(5531.79),
				BalanceLastUpdated.create(java.time.Instant.now().plusSeconds(3600)),
				BalanceIsDefault.create(false),
				BalanceOrdre.create(3),
				BalanceIsArchived.create(false),
				BalanceIsAllowDebit.create(true),
				BalanceIsAllowCredit.create(true),
				BalanceIsExcluTotal.create(true),
				BalanceActivateNotification.create(true),
				BalanceSyncedAt.create(java.time.Instant.now().plusSeconds(3600)),
				BalanceCreatedBy.create(UUID.randomUUID().toString()),
				BalanceTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateBalanceCommand> commandCaptor = ArgumentCaptor.forClass(CreateBalanceCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateBalanceCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getName().value()).isEqualTo(
				command.getName().value());
		assertThat(sentCommand.getCurrency().value()).isEqualTo(
				command.getCurrency().value());
		assertThat(sentCommand.getCurrentBalance().value()).isEqualTo(
				command.getCurrentBalance().value());
		assertThat(sentCommand.getPreviousBalance().value()).isEqualTo(
				command.getPreviousBalance().value());
		assertThat(sentCommand.getLastUpdated().value()).isEqualTo(
				command.getLastUpdated().value());
		assertThat(sentCommand.getIsDefault().value()).isEqualTo(
				command.getIsDefault().value());
		assertThat(sentCommand.getOrdre().value()).isEqualTo(
				command.getOrdre().value());
		assertThat(sentCommand.getIsArchived().value()).isEqualTo(
				command.getIsArchived().value());
		assertThat(sentCommand.getIsAllowDebit().value()).isEqualTo(
				command.getIsAllowDebit().value());
		assertThat(sentCommand.getIsAllowCredit().value()).isEqualTo(
				command.getIsAllowCredit().value());
		assertThat(sentCommand.getIsExcluTotal().value()).isEqualTo(
				command.getIsExcluTotal().value());
		assertThat(sentCommand.getActivateNotification().value()).isEqualTo(
				command.getActivateNotification().value());
		assertThat(sentCommand.getSyncedAt().value()).isEqualTo(
				command.getSyncedAt().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
