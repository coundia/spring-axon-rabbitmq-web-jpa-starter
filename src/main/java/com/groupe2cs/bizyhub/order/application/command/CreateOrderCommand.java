package com.groupe2cs.bizyhub.order.application.command;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.util.Date;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;


import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private OrderId id = OrderId.create(UUID.randomUUID().toString());
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

	public CreateOrderCommand(

			OrderProductId productId,
			OrderUserId userId,
			OrderIdentifiant identifiant,
			OrderTelephone telephone,
			OrderMail mail,
			OrderVille ville,
			OrderRemoteId remoteId,
			OrderLocalId localId,
			OrderStatus status,
			OrderBuyerName buyerName,
			OrderAddress address,
			OrderNotes notes,
			OrderMessage message,
			OrderTypeOrder typeOrder,
			OrderPaymentMethod paymentMethod,
			OrderDeliveryMethod deliveryMethod,
			OrderAmountCents amountCents,
			OrderQuantity quantity,
			OrderDateCommand dateCommand,
			OrderCreatedBy createdBy,
			OrderTenant tenant
	) {
		this.id = OrderId.create(UUID.randomUUID().toString());

		this.productId = productId;
		this.userId = userId;
		this.identifiant = identifiant;
		this.telephone = telephone;
		this.mail = mail;
		this.ville = ville;
		this.remoteId = remoteId;
		this.localId = localId;
		this.status = status;
		this.buyerName = buyerName;
		this.address = address;
		this.notes = notes;
		this.message = message;
		this.typeOrder = typeOrder;
		this.paymentMethod = paymentMethod;
		this.deliveryMethod = deliveryMethod;
		this.amountCents = amountCents;
		this.quantity = quantity;
		this.dateCommand = dateCommand;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
