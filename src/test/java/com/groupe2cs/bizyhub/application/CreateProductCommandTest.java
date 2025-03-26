package com.groupe2cs.bizyhub.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.event.ProductCreatedEvent;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateProductCommandTest extends BaseUnitTests {

    @Mock
    private CommandGateway commandGateway;

    @Test
    void it_should_send_command_to_command_gateway() {
        CreateProductCommand command = new CreateProductCommand( "Product 1",100.0);

        commandGateway.send(command);

        ArgumentCaptor<CreateProductCommand> commandCaptor = ArgumentCaptor.forClass(CreateProductCommand.class);
        verify(commandGateway, times(1)).send(commandCaptor.capture());

        CreateProductCommand sentCommand = commandCaptor.getValue();
        assert(sentCommand.getPrice() == 100.0);
        assert(sentCommand.getName().equals("Product 1"));
    }

    @Test
    void testEventSerialization() throws JsonProcessingException {
        ProductCreatedEvent event = new ProductCreatedEvent("1", 100.0, "Product 1");
        String json = new ObjectMapper().writeValueAsString(event);
        Assertions.assertEquals("{\"id\":\"1\",\"price\":100.0,\"name\":\"Product 1\"}", json);
    }

}
