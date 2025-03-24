package com.groupe2cs.bizyhub.application;

import com.groupe2cs.bizyhub.products.application.CommandHandler.ProductCommandHandler;
import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.event.ProductCreatedEvent;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;


public class ProductCommandHandlerTest extends BaseUnitTests {

    @Mock
    private EventBus eventBus;

    @Mock
    private ProductRepository productRepository;

    private ProductCommandHandler productCommandHandler;

    @Mock
    private CommandGateway commandGateway;

    @BeforeEach
    public void setup() {
        productCommandHandler = new ProductCommandHandler(eventBus, productRepository);
    }

    @Test
    void it_should_persist_product_and_publish_event() {
        CreateProductCommand command = new CreateProductCommand("1", 100.0, "Product 1");

        productCommandHandler.handle(command);

        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(productCaptor.capture());

        Product savedProduct = productCaptor.getValue();

        assert(savedProduct.getPrice() == 100.0);
        assert(savedProduct.getName().equals("Product 1"));

        ArgumentCaptor<GenericEventMessage<ProductCreatedEvent>> eventCaptor = ArgumentCaptor.forClass(GenericEventMessage.class);
        verify(eventBus).publish(eventCaptor.capture());

        ProductCreatedEvent event = eventCaptor.getValue().getPayload();

        assert(event.getId().equals("1"));
        assert(event.getPrice() == 100.0);
        assert(event.getName().equals("Product 1"));
    }
}
