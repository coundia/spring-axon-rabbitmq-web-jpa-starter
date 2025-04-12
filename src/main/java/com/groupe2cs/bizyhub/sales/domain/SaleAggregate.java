package com.groupe2cs.bizyhub.sales.domain;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.domain.event.*;
import com.groupe2cs.bizyhub.sales.application.command.*;
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
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class SaleAggregate {

@AggregateIdentifier
private SaleId id;
private SaleQuantity quantity;
private SaleTotal_price total_price;
private SaleFacture facture;


@CommandHandler
public SaleAggregate(CreateSaleCommand command) {
apply(new SaleCreatedEvent(
		command.getId(),
		command.getQuantity(),
		command.getTotal_price(),
		command.getFacture()
));
}

@CommandHandler
public void handle(DeleteSaleCommand command) {
	apply(new SaleDeletedEvent(
		command.getId()
	));
}

@CommandHandler
public void handle(UpdateSaleCommand command) {
apply(new SaleUpdatedEvent(
		command.getId(),
		command.getQuantity(),
		command.getTotal_price(),
		command.getFacture()
));
}

@EventSourcingHandler
public void on(SaleCreatedEvent event) {
	this.id = event.getId();
	this.quantity = event.getQuantity();
	this.total_price = event.getTotal_price();
	this.facture = event.getFacture();
}

@EventSourcingHandler
public void on(SaleDeletedEvent event) {
this.id = event.getId();
}

@EventSourcingHandler
public void on(SaleUpdatedEvent event) {
this.id = event.getId();
	this.quantity = event.getQuantity();
	this.total_price = event.getTotal_price();
	this.facture = event.getFacture();
}

}
