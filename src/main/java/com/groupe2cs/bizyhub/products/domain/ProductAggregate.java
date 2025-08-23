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
private ProductRemoteId remoteId;
private ProductCode code;
private ProductName name;
private ProductDescription description;
private ProductBarcode barcode;
private ProductUnit unit;
private ProductSyncAt syncAt;
private ProductCategory category;
private ProductDefaultPrice defaultPrice;
private ProductStatuses statuses;
private ProductPurchasePrice purchasePrice;
private ProductCreatedBy createdBy;
private ProductTenant tenant;


@CommandHandler
public ProductAggregate(CreateProductCommand command) {
apply(new ProductCreatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getCode(),
		command.getName(),
		command.getDescription(),
		command.getBarcode(),
		command.getUnit(),
		command.getSyncAt(),
		command.getCategory(),
		command.getDefaultPrice(),
		command.getStatuses(),
		command.getPurchasePrice(),
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
		command.getRemoteId(),
		command.getCode(),
		command.getName(),
		command.getDescription(),
		command.getBarcode(),
		command.getUnit(),
		command.getSyncAt(),
		command.getCategory(),
		command.getDefaultPrice(),
		command.getStatuses(),
		command.getPurchasePrice(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(ProductCreatedEvent event) {
	this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.code = event.getCode();
	this.name = event.getName();
	this.description = event.getDescription();
	this.barcode = event.getBarcode();
	this.unit = event.getUnit();
	this.syncAt = event.getSyncAt();
	this.category = event.getCategory();
	this.defaultPrice = event.getDefaultPrice();
	this.statuses = event.getStatuses();
	this.purchasePrice = event.getPurchasePrice();
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
	this.remoteId = event.getRemoteId();
	this.code = event.getCode();
	this.name = event.getName();
	this.description = event.getDescription();
	this.barcode = event.getBarcode();
	this.unit = event.getUnit();
	this.syncAt = event.getSyncAt();
	this.category = event.getCategory();
	this.defaultPrice = event.getDefaultPrice();
	this.statuses = event.getStatuses();
	this.purchasePrice = event.getPurchasePrice();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
