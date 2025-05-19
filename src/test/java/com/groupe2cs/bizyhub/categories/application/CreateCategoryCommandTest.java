package com.groupe2cs.bizyhub.categories.application;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.categories.application.command.*;
import com.groupe2cs.bizyhub.categories.domain.event.*;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
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

public class CreateCategoryCommandTest extends BaseUnitTests {

@Mock
private CommandGateway commandGateway;

@Test
void it_should_send_command_to_command_gateway() {
CreateCategoryCommand command = new CreateCategoryCommand(
 CategoryId.create(UUID.randomUUID().toString()) ,  CategoryName.create(UUID.randomUUID().toString()) ,  CategoryTypeCategoryRaw.create(UUID.randomUUID().toString()) ,  CategoryDetails.create(UUID.randomUUID().toString()) ,  CategoryIsActive.create(false) ,  CategoryUpdatedAt.create(java.time.Instant.now().plusSeconds(3600)) ,  CategoryReference.create(UUID.randomUUID().toString()) ,  CategoryCreatedBy.create(UUID.randomUUID().toString()) ,  CategoryTenant.create(UUID.randomUUID().toString()) 
);
commandGateway.send(command);

ArgumentCaptor<CreateCategoryCommand> commandCaptor = ArgumentCaptor.forClass(CreateCategoryCommand.class);
verify(commandGateway, times(1)).send(commandCaptor.capture());

CreateCategoryCommand sentCommand = commandCaptor.getValue();
assertThat(sentCommand.getId().value()).isEqualTo(
command.getId().value());
assertThat(sentCommand.getName().value()).isEqualTo(
command.getName().value());
assertThat(sentCommand.getTypeCategoryRaw().value()).isEqualTo(
command.getTypeCategoryRaw().value());
assertThat(sentCommand.getDetails().value()).isEqualTo(
command.getDetails().value());
assertThat(sentCommand.getIsActive().value()).isEqualTo(
command.getIsActive().value());
assertThat(sentCommand.getUpdatedAt().value()).isEqualTo(
command.getUpdatedAt().value());
assertThat(sentCommand.getReference().value()).isEqualTo(
command.getReference().value());
assertThat(sentCommand.getCreatedBy().value()).isEqualTo(
command.getCreatedBy().value());
assertThat(sentCommand.getTenant().value()).isEqualTo(
command.getTenant().value());
}


}
