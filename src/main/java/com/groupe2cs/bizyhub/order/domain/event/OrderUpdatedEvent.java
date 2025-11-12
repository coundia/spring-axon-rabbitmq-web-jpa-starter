package com.groupe2cs.bizyhub.order.domain.event;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderUpdatedEvent implements Serializable {

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


}
