package com.groupe2cs.bizyhub.order.domain;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import com.groupe2cs.bizyhub.order.domain.event.*;
import com.groupe2cs.bizyhub.order.application.command.*;
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
public class OrderAggregate {

	@AggregateIdentifier
	private OrderId id;
	private OrderProductId productId;
	private OrderUserId userId;
	private OrderIdentifiant identifiant;
	private OrderTelephone telephone;
	private OrderMail mail;
	private OrderVille ville;
	private OrderRemoteId remoteId;
	private OrderLocalId localId;
	private OrderStatus status;
	private OrderBuyerName buyerName;
	private OrderAddress address;
	private OrderNotes notes;
	private OrderMessage message;
	private OrderTypeOrder typeOrder;
	private OrderPaymentMethod paymentMethod;
	private OrderDeliveryMethod deliveryMethod;
	private OrderAmountCents amountCents;
	private OrderQuantity quantity;
	private OrderDateCommand dateCommand;
	private OrderCreatedBy createdBy;
	private OrderTenant tenant;


	@CommandHandler
	public OrderAggregate(CreateOrderCommand command) {
		apply(new OrderCreatedEvent(
				command.getId(),
				command.getProductId(),
				command.getUserId(),
				command.getIdentifiant(),
				command.getTelephone(),
				command.getMail(),
				command.getVille(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getStatus(),
				command.getBuyerName(),
				command.getAddress(),
				command.getNotes(),
				command.getMessage(),
				command.getTypeOrder(),
				command.getPaymentMethod(),
				command.getDeliveryMethod(),
				command.getAmountCents(),
				command.getQuantity(),
				command.getDateCommand(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@CommandHandler
	public void handle(DeleteOrderCommand command) {
		apply(new OrderDeletedEvent(
				command.getId()
		));
	}

	@CommandHandler
	public void handle(UpdateOrderCommand command) {
		apply(new OrderUpdatedEvent(
				command.getId(),
				command.getProductId(),
				command.getUserId(),
				command.getIdentifiant(),
				command.getTelephone(),
				command.getMail(),
				command.getVille(),
				command.getRemoteId(),
				command.getLocalId(),
				command.getStatus(),
				command.getBuyerName(),
				command.getAddress(),
				command.getNotes(),
				command.getMessage(),
				command.getTypeOrder(),
				command.getPaymentMethod(),
				command.getDeliveryMethod(),
				command.getAmountCents(),
				command.getQuantity(),
				command.getDateCommand(),
				command.getCreatedBy(),
				command.getTenant()
		));
	}

	@EventSourcingHandler
	public void on(OrderCreatedEvent event) {
		this.id = event.getId();
		this.productId = event.getProductId();
		this.userId = event.getUserId();
		this.identifiant = event.getIdentifiant();
		this.telephone = event.getTelephone();
		this.mail = event.getMail();
		this.ville = event.getVille();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.status = event.getStatus();
		this.buyerName = event.getBuyerName();
		this.address = event.getAddress();
		this.notes = event.getNotes();
		this.message = event.getMessage();
		this.typeOrder = event.getTypeOrder();
		this.paymentMethod = event.getPaymentMethod();
		this.deliveryMethod = event.getDeliveryMethod();
		this.amountCents = event.getAmountCents();
		this.quantity = event.getQuantity();
		this.dateCommand = event.getDateCommand();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

	@EventSourcingHandler
	public void on(OrderDeletedEvent event) {
		this.id = event.getId();
	}

	@EventSourcingHandler
	public void on(OrderUpdatedEvent event) {
		this.id = event.getId();
		this.productId = event.getProductId();
		this.userId = event.getUserId();
		this.identifiant = event.getIdentifiant();
		this.telephone = event.getTelephone();
		this.mail = event.getMail();
		this.ville = event.getVille();
		this.remoteId = event.getRemoteId();
		this.localId = event.getLocalId();
		this.status = event.getStatus();
		this.buyerName = event.getBuyerName();
		this.address = event.getAddress();
		this.notes = event.getNotes();
		this.message = event.getMessage();
		this.typeOrder = event.getTypeOrder();
		this.paymentMethod = event.getPaymentMethod();
		this.deliveryMethod = event.getDeliveryMethod();
		this.amountCents = event.getAmountCents();
		this.quantity = event.getQuantity();
		this.dateCommand = event.getDateCommand();
		this.createdBy = event.getCreatedBy();
		this.tenant = event.getTenant();
	}

}
