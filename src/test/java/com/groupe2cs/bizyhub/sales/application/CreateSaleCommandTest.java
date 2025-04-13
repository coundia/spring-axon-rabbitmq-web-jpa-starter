package com.groupe2cs.bizyhub.sales.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupe2cs.bizyhub.sales.application.command.CreateSaleCommand;
import com.groupe2cs.bizyhub.sales.domain.event.SaleCreatedEvent;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleFacture;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleQuantity;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleTotal_price;
import com.groupe2cs.bizyhub.sales.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateSaleCommandTest extends BaseUnitTests {

    @Mock
    private CommandGateway commandGateway;

    @Test
    void it_should_send_command_to_command_gateway() {
        CreateSaleCommand command =
                new CreateSaleCommand(
                        SaleId.create("test"),
                        SaleQuantity.create(42),
                        SaleTotal_price.create(99.99),
                        SaleFacture.create("test"));
        commandGateway.send(command);

        ArgumentCaptor<CreateSaleCommand> commandCaptor =
                ArgumentCaptor.forClass(CreateSaleCommand.class);
        verify(commandGateway, times(1)).send(commandCaptor.capture());

        CreateSaleCommand sentCommand = commandCaptor.getValue();
        assertThat(sentCommand.getId().value()).isEqualTo("test");
        assertThat(sentCommand.getQuantity().value()).isEqualTo(42);
        assertThat(sentCommand.getTotal_price().value()).isEqualTo(99.99);
        assertThat(sentCommand.getFacture().value()).isEqualTo("test");
    }

    @Test
    void test_event_serialization() throws JsonProcessingException {
        SaleCreatedEvent event =
                new SaleCreatedEvent(
                        SaleId.create("test"),
                        SaleQuantity.create(42),
                        SaleTotal_price.create(99.99),
                        SaleFacture.create("test"));
        String json = new ObjectMapper().writeValueAsString(event);
        assertThat(json).isNotEmpty();
    }
}
