package com.groupe2cs.bizyhub.stock.application.mapper;

	import com.groupe2cs.bizyhub.stock.application.dto.*;
	import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
	import com.groupe2cs.bizyhub.stock.domain.*;
	import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.stock.application.command.*;

public class StockMovementMapper {

public static StockMovementResponse toResponse(StockMovement entity) {
return StockMovementResponse.builder()
		.id(entity.getId())
		.typeStockMovement(entity.getTypeStockMovement())
		.quantity(entity.getQuantity())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.account(entity.getAccount())
		.company(entity.getCompany())
		.syncAt(entity.getSyncAt())
		.productVariant(entity.getProductVariant())
		.orderLineId(entity.getOrderLineId())
		.discriminator(entity.getDiscriminator())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static StockMovementResponse toResponse(CreateStockMovementCommand command) {
return StockMovementResponse.builder()
	.id(command.getId().value())
	.typeStockMovement(command.getTypeStockMovement().value())
	.quantity(command.getQuantity().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.account(command.getAccount().value())
	.company(command.getCompany().value())
	.syncAt(command.getSyncAt().value())
	.productVariant(command.getProductVariant().value())
	.orderLineId(command.getOrderLineId().value())
	.discriminator(command.getDiscriminator().value())
.build();
}

public static StockMovementResponse toResponse(UpdateStockMovementCommand command) {
return StockMovementResponse.builder()
	.id(command.getId().value())
	.typeStockMovement(command.getTypeStockMovement().value())
	.quantity(command.getQuantity().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.account(command.getAccount().value())
	.company(command.getCompany().value())
	.syncAt(command.getSyncAt().value())
	.productVariant(command.getProductVariant().value())
	.orderLineId(command.getOrderLineId().value())
	.discriminator(command.getDiscriminator().value())
.build();
}

public static CreateStockMovementCommand toCommand(
StockMovementRequest request
) {
return CreateStockMovementCommand.builder()
	.typeStockMovement(StockMovementTypeStockMovement.create(request.getTypeStockMovement()))
	.quantity(StockMovementQuantity.create(request.getQuantity()))
	.remoteId(StockMovementRemoteId.create(request.getRemoteId()))
	.localId(StockMovementLocalId.create(request.getLocalId()))
	.account(StockMovementAccount.create(request.getAccount()))
	.company(StockMovementCompany.create(request.getCompany()))
	.syncAt(StockMovementSyncAt.create(request.getSyncAt()))
	.productVariant(StockMovementProductVariant.create(request.getProductVariant()))
	.orderLineId(StockMovementOrderLineId.create(request.getOrderLineId()))
	.discriminator(StockMovementDiscriminator.create(request.getDiscriminator()))
.build();
}

	public static UpdateStockMovementCommand toUpdateCommand(StockMovementId id, StockMovementRequest request) {
	return UpdateStockMovementCommand.builder()
	.id(id)
		.typeStockMovement(StockMovementTypeStockMovement.create(request.getTypeStockMovement()))
		.quantity(StockMovementQuantity.create(request.getQuantity()))
		.remoteId(StockMovementRemoteId.create(request.getRemoteId()))
		.localId(StockMovementLocalId.create(request.getLocalId()))
		.account(StockMovementAccount.create(request.getAccount()))
		.company(StockMovementCompany.create(request.getCompany()))
		.syncAt(StockMovementSyncAt.create(request.getSyncAt()))
		.productVariant(StockMovementProductVariant.create(request.getProductVariant()))
		.orderLineId(StockMovementOrderLineId.create(request.getOrderLineId()))
		.discriminator(StockMovementDiscriminator.create(request.getDiscriminator()))
	.build();
	}


public static DeleteStockMovementCommand toDeleteCommand(StockMovementId id) {
return DeleteStockMovementCommand.builder()
.id(id)
.build();
}
}
