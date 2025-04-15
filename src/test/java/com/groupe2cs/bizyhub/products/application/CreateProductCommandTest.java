package com.groupe2cs.bizyhub.products.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.domain.event.ProductCreatedEvent;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import com.groupe2cs.bizyhub.products.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateProductCommandTest extends BaseUnitTests {

    @Mock
    private CommandGateway commandGateway;

    @Test
    void it_should_send_command_to_command_gateway() {
        CreateProductCommand command = new CreateProductCommand(
                ProductId.create("test"), ProductName.create("test"), ProductPrice.create(99.99)
        );
        commandGateway.send(command);

        ArgumentCaptor<CreateProductCommand> commandCaptor = ArgumentCaptor.forClass(CreateProductCommand.class);
        verify(commandGateway, times(1)).send(commandCaptor.capture());

        CreateProductCommand sentCommand = commandCaptor.getValue();
        assertThat(sentCommand.getId().value()).isEqualTo("test");
        assertThat(sentCommand.getName().value()).isEqualTo("test");
        assertThat(sentCommand.getPrice().value()).isEqualTo(99.99);
    }

    @Test
    void test_event_serialization() throws JsonProcessingException {
        ProductCreatedEvent event = new ProductCreatedEvent(ProductId.create("test"), ProductName.create("test"), ProductPrice.create(99.99));
        String json = new ObjectMapper().writeValueAsString(event);
        assertThat(json).isNotEmpty();
    }
}
