package com.groupe2cs.bizyhub.security.application;

import com.groupe2cs.bizyhub.security.application.command.CreateRolePermissionCommand;
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

public class CreateRolePermissionCommandTest extends BaseUnitTests {

	@Mock
	private CommandGateway commandGateway;

	@Test
	void it_should_send_command_to_command_gateway() {
		CreateRolePermissionCommand command = new CreateRolePermissionCommand(
				RolePermissionId.create(UUID.randomUUID().toString()),
				RolePermissionRole.create(UUID.randomUUID().toString()),
				RolePermissionPermission.create(UUID.randomUUID().toString()),
				RolePermissionCreatedBy.create(UUID.randomUUID().toString()),
				RolePermissionTenant.create(UUID.randomUUID().toString())
		);
		commandGateway.send(command);

		ArgumentCaptor<CreateRolePermissionCommand>
				commandCaptor =
				ArgumentCaptor.forClass(CreateRolePermissionCommand.class);
		verify(commandGateway, times(1)).send(commandCaptor.capture());

		CreateRolePermissionCommand sentCommand = commandCaptor.getValue();
		assertThat(sentCommand.getId().value()).isEqualTo(
				command.getId().value());
		assertThat(sentCommand.getRole().value()).isEqualTo(
				command.getRole().value());
		assertThat(sentCommand.getPermission().value()).isEqualTo(
				command.getPermission().value());
		assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
				command.getCreatedBy().value());
		assertThat(sentCommand.getTenant().value()).isEqualTo(
				command.getTenant().value());
	}


}
