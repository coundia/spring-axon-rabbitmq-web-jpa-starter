package com.groupe2cs.bizyhub.products.application.CommandHandler;

import com.groupe2cs.bizyhub.products.application.Mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.event.ProductCreatedEvent;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;


@Component
@Transactional
public class ProductCommandHandler {
    private final EventBus eventBus;
    private final ProductRepository productRepository;

    public ProductCommandHandler(EventBus eventBus, ProductRepository productRepository) {
        this.eventBus = eventBus;
        this.productRepository = productRepository;
    }


    @CommandHandler
    public void handle(CreateProductCommand createProductCommand) {
        Logger.getLogger(ProductCommandHandler.class.getName()).info("CommandHandler");
        Logger.getLogger(CreateProductCommand.class.getName()).info("Creating product with name: " + createProductCommand.toString());

        ProductCreatedEvent event = new ProductCreatedEvent(createProductCommand.getId(), createProductCommand.getPrice(), createProductCommand.getName());
        Product product = ProductMapper.toEntity(createProductCommand);
        productRepository.save(product);
        eventBus.publish(GenericEventMessage.asEventMessage(event));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        Logger.getLogger(ProductCommandHandler.class.getName()).info("EventSourcingHandler");

    }
}
