package com.groupe2cs.bizyhub.products.domain;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.command.DeleteProductCommand;
import com.groupe2cs.bizyhub.products.application.command.UpdateProductCommand;
import com.groupe2cs.bizyhub.products.domain.event.ProductCreatedEvent;
import com.groupe2cs.bizyhub.products.domain.event.ProductDeletedEvent;
import com.groupe2cs.bizyhub.products.domain.event.ProductUpdatedEvent;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
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
	private ProductRemoteId remoteId;
	private ProductLocalId localId;
	private ProductCode code;
	private ProductName name;
	private ProductDescription description;
	private ProductStatus status;
	private ProductIsPublic isPublic;
	private ProductHasSold hasSold;
	private ProductHasPrice hasPrice;
	private ProductLevel level;
	private ProductQuantity quantity;
	private ProductBarcode barcode;
	private ProductCompany company;
	private ProductUnit unit;
	private ProductSyncAt syncAt;
	private ProductCategory category;
	private ProductAccount account;
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
				command.getLocalId(),
				command.getCode(),
				command.getName(),
				command.getDescription(),
				command.getStatus(),
				command.getIsPublic(),
				command.getHasSold(),
				command.getHasPrice(),
				command.getLevel(),
				command.getQuantity(),
				command.getBarcode(),
				command.getCompany(),
				command.getUnit(),
				command.getSyncAt(),
				command.getCategory(),
				command.getAccount(),
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
				command.getLocalId(),
				command.getCode(),
				command.getName(),
				command.getDescription(),
				command.getStatus(),
				command.getIsPublic(),
				command.getHasSold(),
				command.getHasPrice(),
				command.getLevel(),
				command.getQuantity(),
				command.getBarcode(),
				command.getCompany(),
				command.getUnit(),
				command.getSyncAt(),
				command.getCategory(),
				command.getAccount(),
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
		this.localId = event.getLocalId();
		this.code = event.getCode();
		this.name = event.getName();
		this.description = event.getDescription();
		this.status = event.getStatus();
		this.isPublic = event.getIsPublic();
		this.hasSold = event.getHasSold();
		this.hasPrice = event.getHasPrice();
		this.level = event.getLevel();
		this.quantity = event.getQuantity();
		this.barcode = event.getBarcode();
		this.company = event.getCompany();
		this.unit = event.getUnit();
		this.syncAt = event.getSyncAt();
		this.category = event.getCategory();
		this.account = event.getAccount();
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
		this.localId = event.getLocalId();
		this.code = event.getCode();
		this.name = event.getName();
		this.description = event.getDescription();
		this.status = event.getStatus();
		this.isPublic = event.getIsPublic();
		this.hasSold = event.getHasSold();
		this.hasPrice = event.getHasPrice();
		this.level = event.getLevel();
		this.quantity = event.getQuantity();
		this.barcode = event.getBarcode();
		this.company = event.getCompany();
		this.unit = event.getUnit();
		this.syncAt = event.getSyncAt();
		this.category = event.getCategory();
		this.account = event.getAccount();
		this.defaultPrice = event.getDefaultPrice();
		this.statuses = event.getStatuses();
		this.purchasePrice = event.getPurchasePrice();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
