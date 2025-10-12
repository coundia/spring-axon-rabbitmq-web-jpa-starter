package com.groupe2cs.bizyhub.security.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.domain.event.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
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

public class CreateApiKeyCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateApiKeyCommand command = new CreateApiKeyCommand(
				ApiKeyId.create(UUID.randomUUID().toString()),
				ApiKeyAppKey.create(UUID.randomUUID().toString()),
				ApiKeyUsername.create(UUID.randomUUID().toString()),
				ApiKeyActive.create(false),
				ApiKeyCreatedAt.create(java.time.Instant.now().plusSeconds(3600)),
				ApiKeyExpiration.create(java.time.Instant.now().plusSeconds(3600)),
				ApiKeyCreatedBy.create(UUID.randomUUID().toString()),
				ApiKeyTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateApiKeyCommand> commandCaptor = ArgumentCaptor.forClass(CreateApiKeyCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateApiKeyCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getAppKey().value()).isEqualTo(
				command.getAppKey().value());
		assertThat(sentCommand.getUsername().value()).isEqualTo(
				command.getUsername().value());
		assertThat(sentCommand.getActive().value()).isEqualTo(
				command.getActive().value());
		assertThat(sentCommand.getCreatedAt().value()).isEqualTo(
				command.getCreatedAt().value());
		assertThat(sentCommand.getExpiration().value()).isEqualTo(
				command.getExpiration().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
