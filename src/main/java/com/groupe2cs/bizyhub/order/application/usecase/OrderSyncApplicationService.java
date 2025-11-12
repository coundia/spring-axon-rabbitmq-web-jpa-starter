package com.groupe2cs.bizyhub.order.application.usecase;

import com.groupe2cs.bizyhub.order.application.command.CreateOrderCommand;
import com.groupe2cs.bizyhub.order.application.command.DeleteOrderCommand;
import com.groupe2cs.bizyhub.order.application.command.UpdateOrderCommand;
import com.groupe2cs.bizyhub.order.application.dto.OrderSyncRequest;
import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderSyncApplicationService {

	private final OrderGate gateService;
	private final CommandGateway commandGateway;

	public void syncOrder(OrderSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateOrderCommand command = CreateOrderCommand.builder()
							.productId(OrderProductId.create(d.getProductId()))
							.userId(OrderUserId.create(d.getUserId()))
							.identifiant(OrderIdentifiant.create(d.getIdentifiant()))
							.telephone(OrderTelephone.create(d.getTelephone()))
							.mail(OrderMail.create(d.getMail()))
							.ville(OrderVille.create(d.getVille()))
							.remoteId(OrderRemoteId.create(d.getRemoteId()))
							.localId(OrderLocalId.create(d.getLocalId()))
							.status(OrderStatus.create(d.getStatus()))
							.buyerName(OrderBuyerName.create(d.getBuyerName()))
							.address(OrderAddress.create(d.getAddress()))
							.notes(OrderNotes.create(d.getNotes()))
							.message(OrderMessage.create(d.getMessage()))
							.typeOrder(OrderTypeOrder.create(d.getTypeOrder()))
							.paymentMethod(OrderPaymentMethod.create(d.getPaymentMethod()))
							.deliveryMethod(OrderDeliveryMethod.create(d.getDeliveryMethod()))
							.amountCents(OrderAmountCents.create(d.getAmountCents()))
							.quantity(OrderQuantity.create(d.getQuantity()))
							.dateCommand(OrderDateCommand.create(d.getDateCommand()))
							.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(OrderTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(OrderCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Order with id " + d.getId());
					}

					UpdateOrderCommand update = UpdateOrderCommand.builder()
							.id(OrderId.create(d.getId()))
							.productId(OrderProductId.create(d.getProductId()))
							.userId(OrderUserId.create(d.getUserId()))
							.identifiant(OrderIdentifiant.create(d.getIdentifiant()))
							.telephone(OrderTelephone.create(d.getTelephone()))
							.mail(OrderMail.create(d.getMail()))
							.ville(OrderVille.create(d.getVille()))
							.remoteId(OrderRemoteId.create(d.getRemoteId()))
							.localId(OrderLocalId.create(d.getLocalId()))
							.status(OrderStatus.create(d.getStatus()))
							.buyerName(OrderBuyerName.create(d.getBuyerName()))
							.address(OrderAddress.create(d.getAddress()))
							.notes(OrderNotes.create(d.getNotes()))
							.message(OrderMessage.create(d.getMessage()))
							.typeOrder(OrderTypeOrder.create(d.getTypeOrder()))
							.paymentMethod(OrderPaymentMethod.create(d.getPaymentMethod()))
							.deliveryMethod(OrderDeliveryMethod.create(d.getDeliveryMethod()))
							.amountCents(OrderAmountCents.create(d.getAmountCents()))
							.quantity(OrderQuantity.create(d.getQuantity()))
							.dateCommand(OrderDateCommand.create(d.getDateCommand()))
							.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Order with id " + d.getId());
					}

					DeleteOrderCommand delete = DeleteOrderCommand.builder()
							.id(OrderId.create(d.getId()))
							.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
