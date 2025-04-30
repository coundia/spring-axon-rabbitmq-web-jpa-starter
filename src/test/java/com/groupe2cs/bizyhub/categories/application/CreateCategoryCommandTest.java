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
				CategoryName.create(UUID.randomUUID().toString()),
				CategoryTypeCategory.create(UUID.randomUUID().toString()),
				CategoryParentId.create(UUID.randomUUID().toString()),
				CategoryIsDefault.create(false),
				CategoryIcon.create(UUID.randomUUID().toString()),
				CategoryColorHex.create(UUID.randomUUID().toString()),
				CategoryCreatedBy.create(UUID.randomUUID().toString()),
				CategoryTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateCategoryCommand> commandCaptor = ArgumentCaptor.forClass(CreateCategoryCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateCategoryCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getName().value()).isEqualTo(
				command.getName().value());
		assertThat(sentCommand.getTypeCategory().value()).isEqualTo(
				command.getTypeCategory().value());
		assertThat(sentCommand.getParentId().value()).isEqualTo(
				command.getParentId().value());
		assertThat(sentCommand.getIsDefault().value()).isEqualTo(
				command.getIsDefault().value());
		assertThat(sentCommand.getIcon().value()).isEqualTo(
				command.getIcon().value());
		assertThat(sentCommand.getColorHex().value()).isEqualTo(
				command.getColorHex().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
