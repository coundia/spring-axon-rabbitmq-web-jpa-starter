package com.groupe2cs.bizyhub.order.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;

import java.util.UUID;

import com.groupe2cs.bizyhub.order.domain.exception.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;


public class OrderAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_order_with_valid_values() {
		OrderId id = OrderId.create(UUID.randomUUID().toString());
		OrderProductId productId = OrderProductId.create(UUID.randomUUID().toString());
		OrderUserId userId = OrderUserId.create(UUID.randomUUID().toString());
		OrderIdentifiant identifiant = OrderIdentifiant.create(UUID.randomUUID().toString());
		OrderTelephone telephone = OrderTelephone.create(UUID.randomUUID().toString());
		OrderMail mail = OrderMail.create(UUID.randomUUID().toString());
		OrderVille ville = OrderVille.create(UUID.randomUUID().toString());
		OrderRemoteId remoteId = OrderRemoteId.create(UUID.randomUUID().toString());
		OrderLocalId localId = OrderLocalId.create(UUID.randomUUID().toString());
		OrderStatus status = OrderStatus.create(UUID.randomUUID().toString());
		OrderBuyerName buyerName = OrderBuyerName.create(UUID.randomUUID().toString());
		OrderAddress address = OrderAddress.create(UUID.randomUUID().toString());
		OrderNotes notes = OrderNotes.create(UUID.randomUUID().toString());
		OrderMessage message = OrderMessage.create(UUID.randomUUID().toString());
		OrderTypeOrder typeOrder = OrderTypeOrder.create(UUID.randomUUID().toString());
		OrderPaymentMethod paymentMethod = OrderPaymentMethod.create(UUID.randomUUID().toString());
		OrderDeliveryMethod deliveryMethod = OrderDeliveryMethod.create(UUID.randomUUID().toString());
		OrderAmountCents amountCents = OrderAmountCents.create(4528.16);
		OrderQuantity quantity = OrderQuantity.create(35);
		OrderDateCommand dateCommand = OrderDateCommand.create(java.time.Instant.now().plusSeconds(3600));
		OrderCreatedBy createdBy = OrderCreatedBy.create(UUID.randomUUID().toString());
		OrderTenant tenant = OrderTenant.create(UUID.randomUUID().toString());
		OrderAggregate
				aggregateOrderAggregate =
				new OrderAggregate(id,
						productId,
						userId,
						identifiant,
						telephone,
						mail,
						ville,
						remoteId,
						localId,
						status,
						buyerName,
						address,
						notes,
						message,
						typeOrder,
						paymentMethod,
						deliveryMethod,
						amountCents,
						quantity,
						dateCommand,
						createdBy,
						tenant);
		assertThat(aggregateOrderAggregate.getId()).isNotNull();
		assertThat(aggregateOrderAggregate.getId()).isEqualTo(id);
		assertThat(aggregateOrderAggregate.getProductId()).isEqualTo(productId);
		assertThat(aggregateOrderAggregate.getUserId()).isEqualTo(userId);
		assertThat(aggregateOrderAggregate.getIdentifiant()).isEqualTo(identifiant);
		assertThat(aggregateOrderAggregate.getTelephone()).isEqualTo(telephone);
		assertThat(aggregateOrderAggregate.getMail()).isEqualTo(mail);
		assertThat(aggregateOrderAggregate.getVille()).isEqualTo(ville);
		assertThat(aggregateOrderAggregate.getRemoteId()).isEqualTo(remoteId);
		assertThat(aggregateOrderAggregate.getLocalId()).isEqualTo(localId);
		assertThat(aggregateOrderAggregate.getStatus()).isEqualTo(status);
		assertThat(aggregateOrderAggregate.getBuyerName()).isEqualTo(buyerName);
		assertThat(aggregateOrderAggregate.getAddress()).isEqualTo(address);
		assertThat(aggregateOrderAggregate.getNotes()).isEqualTo(notes);
		assertThat(aggregateOrderAggregate.getMessage()).isEqualTo(message);
		assertThat(aggregateOrderAggregate.getTypeOrder()).isEqualTo(typeOrder);
		assertThat(aggregateOrderAggregate.getPaymentMethod()).isEqualTo(paymentMethod);
		assertThat(aggregateOrderAggregate.getDeliveryMethod()).isEqualTo(deliveryMethod);
		assertThat(aggregateOrderAggregate.getAmountCents()).isEqualTo(amountCents);
		assertThat(aggregateOrderAggregate.getQuantity()).isEqualTo(quantity);
		assertThat(aggregateOrderAggregate.getDateCommand()).isEqualTo(dateCommand);
		assertThat(aggregateOrderAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateOrderAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		OrderIdNotValid error = assertThrows(OrderIdNotValid.class, () -> OrderId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

}
