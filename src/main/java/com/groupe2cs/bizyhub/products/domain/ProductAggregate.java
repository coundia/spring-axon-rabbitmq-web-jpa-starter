package com.groupe2cs.bizyhub.products.domain;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.domain.event.*;
import com.groupe2cs.bizyhub.products.application.command.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

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
private ProductDetails details;
private ProductIsActive isActive;
private ProductUpdatedAt updatedAt;
private ProductReference reference;
private ProductCreatedBy createdBy;
private ProductTenant tenant;


@CommandHandler
public ProductAggregate(CreateProductCommand command) {
apply(new ProductCreatedEvent(
		command.getId(),
		command.getName(),
		command.getPrice(),
		command.getDetails(),
		command.getIsActive(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteProductCommand command) {
	apply(new ProductDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateProductCommand command) {
apply(new ProductUpdatedEvent(
		command.getId(),
		command.getName(),
		command.getPrice(),
		command.getDetails(),
		command.getIsActive(),
		command.getUpdatedAt(),
		command.getReference(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(ProductCreatedEvent event) {
	this.id = event.getId();
	this.name = event.getName();
	this.price = event.getPrice();
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
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
	this.details = event.getDetails();
	this.isActive = event.getIsActive();
	this.updatedAt = event.getUpdatedAt();
	this.reference = event.getReference();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
