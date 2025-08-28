package com.groupe2cs.bizyhub.stock.domain;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import com.groupe2cs.bizyhub.stock.domain.event.*;
import com.groupe2cs.bizyhub.stock.application.command.*;
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
public class StockLevelAggregate {

@AggregateIdentifier
private StockLevelId id;
private StockLevelRemoteId remoteId;
private StockLevelLocalId localId;
private StockLevelStockOnHand stockOnHand;
private StockLevelStockAllocated stockAllocated;
private StockLevelAccount account;
private StockLevelProductVariant productVariant;
private StockLevelSyncAt syncAt;
private StockLevelCompany company;
private StockLevelCreatedBy createdBy;
private StockLevelTenant tenant;


@CommandHandler
public StockLevelAggregate(CreateStockLevelCommand command) {
apply(new StockLevelCreatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getStockOnHand(),
		command.getStockAllocated(),
		command.getAccount(),
		command.getProductVariant(),
		command.getSyncAt(),
		command.getCompany(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@CommandHandler
public void handle(DeleteStockLevelCommand command) {
	apply(new StockLevelDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateStockLevelCommand command) {
apply(new StockLevelUpdatedEvent(
		command.getId(),
		command.getRemoteId(),
		command.getLocalId(),
		command.getStockOnHand(),
		command.getStockAllocated(),
		command.getAccount(),
		command.getProductVariant(),
		command.getSyncAt(),
		command.getCompany(),
		command.getCreatedBy(),
		command.getTenant()
));
}

@EventSourcingHandler
public void on(StockLevelCreatedEvent event) {
	this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.stockOnHand = event.getStockOnHand();
	this.stockAllocated = event.getStockAllocated();
	this.account = event.getAccount();
	this.productVariant = event.getProductVariant();
	this.syncAt = event.getSyncAt();
	this.company = event.getCompany();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

@EventSourcingHandler
public void on(StockLevelDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(StockLevelUpdatedEvent event) {
this.id = event.getId();
	this.remoteId = event.getRemoteId();
	this.localId = event.getLocalId();
	this.stockOnHand = event.getStockOnHand();
	this.stockAllocated = event.getStockAllocated();
	this.account = event.getAccount();
	this.productVariant = event.getProductVariant();
	this.syncAt = event.getSyncAt();
	this.company = event.getCompany();
	this.createdBy = event.getCreatedBy();
	this.tenant = event.getTenant();
}

}
