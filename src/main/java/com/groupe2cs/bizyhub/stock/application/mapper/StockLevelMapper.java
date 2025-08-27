package com.groupe2cs.bizyhub.stock.application.mapper;

	import com.groupe2cs.bizyhub.stock.application.dto.*;
	import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
	import com.groupe2cs.bizyhub.stock.domain.*;
	import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.stock.application.command.*;

public class StockLevelMapper {

public static StockLevelResponse toResponse(StockLevel entity) {
return StockLevelResponse.builder()
		.id(entity.getId())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.stockOnHand(entity.getStockOnHand())
		.stockAllocated(entity.getStockAllocated())
		.productVariant(entity.getProductVariant())
		.syncAt(entity.getSyncAt())
		.company(entity.getCompany())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static StockLevelResponse toResponse(CreateStockLevelCommand command) {
return StockLevelResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.stockOnHand(command.getStockOnHand().value())
	.stockAllocated(command.getStockAllocated().value())
	.productVariant(command.getProductVariant().value())
	.syncAt(command.getSyncAt().value())
	.company(command.getCompany().value())
.build();
}

public static StockLevelResponse toResponse(UpdateStockLevelCommand command) {
return StockLevelResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.stockOnHand(command.getStockOnHand().value())
	.stockAllocated(command.getStockAllocated().value())
	.productVariant(command.getProductVariant().value())
	.syncAt(command.getSyncAt().value())
	.company(command.getCompany().value())
.build();
}

public static CreateStockLevelCommand toCommand(
StockLevelRequest request
) {
return CreateStockLevelCommand.builder()
	.remoteId(StockLevelRemoteId.create(request.getRemoteId()))
	.localId(StockLevelLocalId.create(request.getLocalId()))
	.stockOnHand(StockLevelStockOnHand.create(request.getStockOnHand()))
	.stockAllocated(StockLevelStockAllocated.create(request.getStockAllocated()))
	.productVariant(StockLevelProductVariant.create(request.getProductVariant()))
	.syncAt(StockLevelSyncAt.create(request.getSyncAt()))
	.company(StockLevelCompany.create(request.getCompany()))
.build();
}

	public static UpdateStockLevelCommand toUpdateCommand(StockLevelId id, StockLevelRequest request) {
	return UpdateStockLevelCommand.builder()
	.id(id)
		.remoteId(StockLevelRemoteId.create(request.getRemoteId()))
		.localId(StockLevelLocalId.create(request.getLocalId()))
		.stockOnHand(StockLevelStockOnHand.create(request.getStockOnHand()))
		.stockAllocated(StockLevelStockAllocated.create(request.getStockAllocated()))
		.productVariant(StockLevelProductVariant.create(request.getProductVariant()))
		.syncAt(StockLevelSyncAt.create(request.getSyncAt()))
		.company(StockLevelCompany.create(request.getCompany()))
	.build();
	}


public static DeleteStockLevelCommand toDeleteCommand(StockLevelId id) {
return DeleteStockLevelCommand.builder()
.id(id)
.build();
}
}
