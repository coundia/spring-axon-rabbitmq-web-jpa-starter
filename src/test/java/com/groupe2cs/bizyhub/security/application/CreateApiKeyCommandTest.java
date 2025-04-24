package com.groupe2cs.bizyhub.security.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.security.application.command.CreateApiKeyCommand;
import com.groupe2cs.bizyhub.security.domain.event.ApiKeyCreatedEvent;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateApiKeyCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateApiKeyCommand command = new CreateApiKeyCommand(
				ApiKeyId.create(UUID.randomUUID().toString()),
				ApiKeyKey.create(UUID.randomUUID().toString()),
				ApiKeyUsername.create(UUID.randomUUID().toString()),
				ApiKeyCreatedAt.create(java.time.Instant.now().plusSeconds(3600)),
				ApiKeyExpiration.create(java.time.Instant.now().plusSeconds(3600)),
				ApiKeyCreatedBy.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateApiKeyCommand> commandCaptor = ArgumentCaptor.forClass(CreateApiKeyCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateApiKeyCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getKey().value()).isEqualTo(
				command.getKey().value());
		assertThat(sentCommand.getUsername().value()).isEqualTo(
				command.getUsername().value());
		assertThat(sentCommand.getCreatedAt().value()).isEqualTo(
				command.getCreatedAt().value());
		assertThat(sentCommand.getExpiration().value()).isEqualTo(
				command.getExpiration().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
	}

	@Test
	void test_event_serialization() throws JsonProcessingException {
		ApiKeyCreatedEvent
				event =
				new ApiKeyCreatedEvent(ApiKeyId.create(UUID.randomUUID().toString()),
						ApiKeyKey.create(UUID.randomUUID().toString()),
						ApiKeyUsername.create(UUID.randomUUID().toString()),
						ApiKeyCreatedAt.create(java.time.Instant.now().plusSeconds(3600)),
						ApiKeyExpiration.create(java.time.Instant.now().plusSeconds(3600)),
						ApiKeyCreatedBy.create(UUID.randomUUID().toString()));
		String json = new ObjectMapper().writeValueAsString(event);
		assertThat(json).isNotEmpty();
	}
}
