package com.groupe2cs.bizyhub.debts.application;

import com.groupe2cs.bizyhub.debts.application.command.CreateDebtCommand;
import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateDebtCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateDebtCommand command = new CreateDebtCommand(
				DebtId.create(UUID.randomUUID().toString()),
				DebtRemoteId.create(UUID.randomUUID().toString()),
				DebtLocalId.create(UUID.randomUUID().toString()),
				DebtCode.create(UUID.randomUUID().toString()),
				DebtNotes.create(UUID.randomUUID().toString()),
				DebtBalance.create(7915.36),
				DebtBalanceDebt.create(4184.41),
				DebtDueDate.create(java.time.Instant.now().plusSeconds(3600)),
				DebtStatuses.create(UUID.randomUUID().toString()),
				DebtAccount.create(UUID.randomUUID().toString()),
				DebtSyncAt.create(java.time.Instant.now().plusSeconds(3600)),
				DebtCustomer.create(UUID.randomUUID().toString()),
				DebtIsActive.create(false),
				DebtCreatedBy.create(UUID.randomUUID().toString()),
				DebtTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateDebtCommand> commandCaptor = ArgumentCaptor.forClass(CreateDebtCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateDebtCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getRemoteId().value()).isEqualTo(
				command.getRemoteId().value());
		assertThat(sentCommand.getLocalId().value()).isEqualTo(
				command.getLocalId().value());
		assertThat(sentCommand.getCode().value()).isEqualTo(
				command.getCode().value());
		assertThat(sentCommand.getNotes().value()).isEqualTo(
				command.getNotes().value());
		assertThat(sentCommand.getBalance().value()).isEqualTo(
				command.getBalance().value());
		assertThat(sentCommand.getBalanceDebt().value()).isEqualTo(
				command.getBalanceDebt().value());
		assertThat(sentCommand.getDueDate().value()).isEqualTo(
				command.getDueDate().value());
		assertThat(sentCommand.getStatuses().value()).isEqualTo(
				command.getStatuses().value());
		assertThat(sentCommand.getAccount().value()).isEqualTo(
				command.getAccount().value());
		assertThat(sentCommand.getSyncAt().value()).isEqualTo(
				command.getSyncAt().value());
		assertThat(sentCommand.getCustomer().value()).isEqualTo(
				command.getCustomer().value());
		assertThat(sentCommand.getIsActive().value()).isEqualTo(
				command.getIsActive().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
