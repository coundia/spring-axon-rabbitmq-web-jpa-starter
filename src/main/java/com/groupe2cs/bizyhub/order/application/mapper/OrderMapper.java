package com.groupe2cs.bizyhub.order.application.mapper;

	import com.groupe2cs.bizyhub.order.application.dto.*;
	import com.groupe2cs.bizyhub.order.domain.valueObject.*;
	import com.groupe2cs.bizyhub.order.domain.*;
	import com.groupe2cs.bizyhub.order.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.order.application.command.*;

public class OrderMapper {

public static OrderResponse toResponse(Order entity) {
return OrderResponse.builder()
		.id(entity.getId())
		.productId(entity.getProductId())
		.userId(entity.getUserId())
		.identifiant(entity.getIdentifiant())
		.telephone(entity.getTelephone())
		.mail(entity.getMail())
		.ville(entity.getVille())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.status(entity.getStatus())
		.buyerName(entity.getBuyerName())
		.address(entity.getAddress())
		.notes(entity.getNotes())
		.message(entity.getMessage())
		.typeOrder(entity.getTypeOrder())
		.paymentMethod(entity.getPaymentMethod())
		.deliveryMethod(entity.getDeliveryMethod())
		.amountCents(entity.getAmountCents())
		.quantity(entity.getQuantity())
		.dateCommand(entity.getDateCommand())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static OrderResponse toResponse(CreateOrderCommand command) {
return OrderResponse.builder()
	.id(command.getId().value())
	.productId(command.getProductId().value())
	.userId(command.getUserId().value())
	.identifiant(command.getIdentifiant().value())
	.telephone(command.getTelephone().value())
	.mail(command.getMail().value())
	.ville(command.getVille().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.status(command.getStatus().value())
	.buyerName(command.getBuyerName().value())
	.address(command.getAddress().value())
	.notes(command.getNotes().value())
	.message(command.getMessage().value())
	.typeOrder(command.getTypeOrder().value())
	.paymentMethod(command.getPaymentMethod().value())
	.deliveryMethod(command.getDeliveryMethod().value())
	.amountCents(command.getAmountCents().value())
	.quantity(command.getQuantity().value())
	.dateCommand(command.getDateCommand().value())
.build();
}

public static OrderResponse toResponse(UpdateOrderCommand command) {
return OrderResponse.builder()
	.id(command.getId().value())
	.productId(command.getProductId().value())
	.userId(command.getUserId().value())
	.identifiant(command.getIdentifiant().value())
	.telephone(command.getTelephone().value())
	.mail(command.getMail().value())
	.ville(command.getVille().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.status(command.getStatus().value())
	.buyerName(command.getBuyerName().value())
	.address(command.getAddress().value())
	.notes(command.getNotes().value())
	.message(command.getMessage().value())
	.typeOrder(command.getTypeOrder().value())
	.paymentMethod(command.getPaymentMethod().value())
	.deliveryMethod(command.getDeliveryMethod().value())
	.amountCents(command.getAmountCents().value())
	.quantity(command.getQuantity().value())
	.dateCommand(command.getDateCommand().value())
.build();
}

public static CreateOrderCommand toCommand(
OrderRequest request
) {
return CreateOrderCommand.builder()
	.productId(OrderProductId.create(request.getProductId()))
	.userId(OrderUserId.create(request.getUserId()))
	.identifiant(OrderIdentifiant.create(request.getIdentifiant()))
	.telephone(OrderTelephone.create(request.getTelephone()))
	.mail(OrderMail.create(request.getMail()))
	.ville(OrderVille.create(request.getVille()))
	.remoteId(OrderRemoteId.create(request.getRemoteId()))
	.localId(OrderLocalId.create(request.getLocalId()))
	.status(OrderStatus.create(request.getStatus()))
	.buyerName(OrderBuyerName.create(request.getBuyerName()))
	.address(OrderAddress.create(request.getAddress()))
	.notes(OrderNotes.create(request.getNotes()))
	.message(OrderMessage.create(request.getMessage()))
	.typeOrder(OrderTypeOrder.create(request.getTypeOrder()))
	.paymentMethod(OrderPaymentMethod.create(request.getPaymentMethod()))
	.deliveryMethod(OrderDeliveryMethod.create(request.getDeliveryMethod()))
	.amountCents(OrderAmountCents.create(request.getAmountCents()))
	.quantity(OrderQuantity.create(request.getQuantity()))
	.dateCommand(OrderDateCommand.create(request.getDateCommand()))
.build();
}

	public static UpdateOrderCommand toUpdateCommand(OrderId id, OrderRequest request) {
	return UpdateOrderCommand.builder()
	.id(id)
		.productId(OrderProductId.create(request.getProductId()))
		.userId(OrderUserId.create(request.getUserId()))
		.identifiant(OrderIdentifiant.create(request.getIdentifiant()))
		.telephone(OrderTelephone.create(request.getTelephone()))
		.mail(OrderMail.create(request.getMail()))
		.ville(OrderVille.create(request.getVille()))
		.remoteId(OrderRemoteId.create(request.getRemoteId()))
		.localId(OrderLocalId.create(request.getLocalId()))
		.status(OrderStatus.create(request.getStatus()))
		.buyerName(OrderBuyerName.create(request.getBuyerName()))
		.address(OrderAddress.create(request.getAddress()))
		.notes(OrderNotes.create(request.getNotes()))
		.message(OrderMessage.create(request.getMessage()))
		.typeOrder(OrderTypeOrder.create(request.getTypeOrder()))
		.paymentMethod(OrderPaymentMethod.create(request.getPaymentMethod()))
		.deliveryMethod(OrderDeliveryMethod.create(request.getDeliveryMethod()))
		.amountCents(OrderAmountCents.create(request.getAmountCents()))
		.quantity(OrderQuantity.create(request.getQuantity()))
		.dateCommand(OrderDateCommand.create(request.getDateCommand()))
	.build();
	}


public static DeleteOrderCommand toDeleteCommand(OrderId id) {
return DeleteOrderCommand.builder()
.id(id)
.build();
}
}
