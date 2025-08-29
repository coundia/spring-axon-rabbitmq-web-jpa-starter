package com.groupe2cs.bizyhub.stock.domain;

import com.groupe2cs.bizyhub.stock.application.command.CreateStockMovementCommand;
import com.groupe2cs.bizyhub.stock.application.command.DeleteStockMovementCommand;
import com.groupe2cs.bizyhub.stock.application.command.UpdateStockMovementCommand;
import com.groupe2cs.bizyhub.stock.domain.event.StockMovementCreatedEvent;
import com.groupe2cs.bizyhub.stock.domain.event.StockMovementDeletedEvent;
import com.groupe2cs.bizyhub.stock.domain.event.StockMovementUpdatedEvent;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
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
public class StockMovementAggregate {

	@AggregateIdentifier
	private StockMovementId id;
	private StockMovementTypeStockMovement typeStockMovement;
	private StockMovementQuantity quantity;
	private StockMovementRemoteId remoteId;
	private StockMovementLocalId localId;
	private StockMovementAccount account;
	private StockMovementCompany company;
	private StockMovementSyncAt syncAt;
	private StockMovementProductVariant productVariant;
	private StockMovementOrderLineId orderLineId;
	private StockMovementDiscriminator discriminator;
	private StockMovementCreatedBy createdBy;
	private StockMovementTenant tenant;


	@CommandHandler
	public StockMovementAggregate(CreateStockMovementCommand command) {
		apply(new StockMovementCreatedEvent(
				command.getId(),
				command.getTypeStockMovement(),
				command.getQuantity(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getAccount(),
				command.getCompany(),
				command.getSyncAt(),
				command.getProductVariant(),
				command.getOrderLineId(),
				command.getDiscriminator(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteStockMovementCommand command) {
		apply(new StockMovementDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateStockMovementCommand command) {
		apply(new StockMovementUpdatedEvent(
				command.getId(),
				command.getTypeStockMovement(),
				command.getQuantity(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getAccount(),
				command.getCompany(),
				command.getSyncAt(),
				command.getProductVariant(),
				command.getOrderLineId(),
				command.getDiscriminator(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(StockMovementCreatedEvent event) {
		this.id = event.getId();
		this.typeStockMovement = event.getTypeStockMovement();
		this.quantity = event.getQuantity();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.account = event.getAccount();
		this.company = event.getCompany();
		this.syncAt = event.getSyncAt();
		this.productVariant = event.getProductVariant();
		this.orderLineId = event.getOrderLineId();
		this.discriminator = event.getDiscriminator();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(StockMovementDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(StockMovementUpdatedEvent event) {
		this.id = event.getId();
		this.typeStockMovement = event.getTypeStockMovement();
		this.quantity = event.getQuantity();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.account = event.getAccount();
		this.company = event.getCompany();
		this.syncAt = event.getSyncAt();
		this.productVariant = event.getProductVariant();
		this.orderLineId = event.getOrderLineId();
		this.discriminator = event.getDiscriminator();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
