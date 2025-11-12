package com.groupe2cs.bizyhub.categories.application;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateCategoryCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateCategoryCommand command = new CreateCategoryCommand(
				CategoryId.create(UUID.randomUUID().toString()),
				CategoryCode.create(UUID.randomUUID().toString()),
				CategoryName.create(UUID.randomUUID().toString()),
				CategoryRemoteId.create(UUID.randomUUID().toString()),
				CategoryLocalId.create(UUID.randomUUID().toString()),
				CategoryAccount.create(UUID.randomUUID().toString()),
				CategoryStatus.create(UUID.randomUUID().toString()),
				CategoryIsPublic.create(false),
				CategoryDescription.create(UUID.randomUUID().toString()),
				CategoryTypeEntry.create(UUID.randomUUID().toString()),
				CategoryVersion.create(69),
				CategorySyncAt.create(java.time.Instant.now().plusSeconds(3600)),
				CategoryCreatedBy.create(UUID.randomUUID().toString()),
				CategoryTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateCategoryCommand> commandCaptor = ArgumentCaptor.forClass(CreateCategoryCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateCategoryCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getCode().value()).isEqualTo(
				command.getCode().value());
		assertThat(sentCommand.getName().value()).isEqualTo(
				command.getName().value());
		assertThat(sentCommand.getRemoteId().value()).isEqualTo(
				command.getRemoteId().value());
		assertThat(sentCommand.getLocalId().value()).isEqualTo(
				command.getLocalId().value());
		assertThat(sentCommand.getAccount().value()).isEqualTo(
				command.getAccount().value());
		assertThat(sentCommand.getStatus().value()).isEqualTo(
				command.getStatus().value());
		assertThat(sentCommand.getIsPublic().value()).isEqualTo(
				command.getIsPublic().value());
		assertThat(sentCommand.getDescription().value()).isEqualTo(
				command.getDescription().value());
		assertThat(sentCommand.getTypeEntry().value()).isEqualTo(
				command.getTypeEntry().value());
		assertThat(sentCommand.getVersion().value()).isEqualTo(
				command.getVersion().value());
		assertThat(sentCommand.getSyncAt().value()).isEqualTo(
				command.getSyncAt().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
