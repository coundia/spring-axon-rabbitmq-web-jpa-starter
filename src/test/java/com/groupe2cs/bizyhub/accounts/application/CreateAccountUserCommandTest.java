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

public class CreateAccountUserCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateAccountUserCommand command = new CreateAccountUserCommand(
 AccountUserId.create(UUID.randomUUID().toString()) ,  AccountUserAccount.create(UUID.randomUUID().toString()) ,  AccountUserUser.create(UUID.randomUUID().toString()) ,  AccountUserIdentity.create(UUID.randomUUID().toString()) ,  AccountUserPhone.create(UUID.randomUUID().toString()) ,  AccountUserEmail.create(UUID.randomUUID().toString()) ,  AccountUserRole.create(UUID.randomUUID().toString()) ,  AccountUserStatus.create(UUID.randomUUID().toString()) ,  AccountUserInvitedBy.create(UUID.randomUUID().toString()) ,  AccountUserSyncAt.create(java.time.Instant.now().plusSeconds(3600)) ,  AccountUserAcceptedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  AccountUserRevokedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  AccountUserMessage.create(UUID.randomUUID().toString()) ,  AccountUserRemoteId.create(UUID.randomUUID().toString()) ,  AccountUserLocalId.create(UUID.randomUUID().toString()) ,  AccountUserIsActive.create(true) ,  AccountUserCreatedBy.create(UUID.randomUUID().toString()) ,  AccountUserTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateAccountUserCommand> commandCaptor = ArgumentCaptor.forClass(CreateAccountUserCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateAccountUserCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getAccount().value()).isEqualTo(
command.getAccount().value());
assertThat(sentCommand.getUser().value()).isEqualTo(
command.getUser().value());
assertThat(sentCommand.getIdentity().value()).isEqualTo(
command.getIdentity().value());
assertThat(sentCommand.getPhone().value()).isEqualTo(
command.getPhone().value());
assertThat(sentCommand.getEmail().value()).isEqualTo(
command.getEmail().value());
assertThat(sentCommand.getRole().value()).isEqualTo(
command.getRole().value());
assertThat(sentCommand.getStatus().value()).isEqualTo(
command.getStatus().value());
assertThat(sentCommand.getInvitedBy().value()).isEqualTo(
command.getInvitedBy().value());
assertThat(sentCommand.getSyncAt().value()).isEqualTo(
command.getSyncAt().value());
assertThat(sentCommand.getAcceptedAt().value()).isEqualTo(
command.getAcceptedAt().value());
assertThat(sentCommand.getRevokedAt().value()).isEqualTo(
command.getRevokedAt().value());
assertThat(sentCommand.getMessage().value()).isEqualTo(
command.getMessage().value());
assertThat(sentCommand.getRemoteId().value()).isEqualTo(
command.getRemoteId().value());
assertThat(sentCommand.getLocalId().value()).isEqualTo(
command.getLocalId().value());
assertThat(sentCommand.getIsActive().value()).isEqualTo(
command.getIsActive().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
