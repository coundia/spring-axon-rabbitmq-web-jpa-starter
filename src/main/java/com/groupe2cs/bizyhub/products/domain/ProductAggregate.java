package com.groupe2cs.bizyhub.products.domain;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.command.DeleteProductCommand;
import com.groupe2cs.bizyhub.products.application.command.UpdateProductCommand;
import com.groupe2cs.bizyhub.products.domain.event.ProductCreatedEvent;
import com.groupe2cs.bizyhub.products.domain.event.ProductDeletedEvent;
import com.groupe2cs.bizyhub.products.domain.event.ProductUpdatedEvent;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private ProductId id;
    private ProductName name;
    private ProductPrice price;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        apply(new ProductCreatedEvent(command.getId(), command.getName(), command.getPrice()));
    }

    @CommandHandler
    public void handle(DeleteProductCommand command) {
        apply(new ProductDeletedEvent(command.getId()));
    }

    @CommandHandler
    public void handle(UpdateProductCommand command) {
        apply(new ProductUpdatedEvent(command.getId(), command.getName(), command.getPrice()));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.price = event.getPrice();
    }

    @EventSourcingHandler
    public void on(ProductDeletedEvent event) {
        this.id = event.getId();
    }

    @EventSourcingHandler
    public void on(ProductUpdatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.price = event.getPrice();
    }
}
