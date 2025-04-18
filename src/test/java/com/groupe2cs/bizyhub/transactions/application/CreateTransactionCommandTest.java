package com.groupe2cs.bizyhub.transactions.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.domain.event.TransactionCreatedEvent;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateTransactionCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateTransactionCommand command = new CreateTransactionCommand(
				TransactionId.create(UUID.randomUUID().toString()),
				TransactionReference.create(UUID.randomUUID().toString()),
				TransactionAmount.create(3665.59)
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateTransactionCommand>
				commandCaptor =
				ArgumentCaptor.forClass(CreateTransactionCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateTransactionCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getReference().value()).isEqualTo(
				command.getReference().value());
		assertThat(sentCommand.getAmount().value()).isEqualTo(
				command.getAmount().value());
	}

	@Test
	void test_event_serialization() throws JsonProcessingException {
		TransactionCreatedEvent
				event =
				new TransactionCreatedEvent(TransactionId.create(UUID.randomUUID().toString()),
						TransactionReference.create(UUID.randomUUID().toString()),
						TransactionAmount.create(3665.59));
		String json = new ObjectMapper().writeValueAsString(event);
		assertThat(json).isNotEmpty();
	}
}
