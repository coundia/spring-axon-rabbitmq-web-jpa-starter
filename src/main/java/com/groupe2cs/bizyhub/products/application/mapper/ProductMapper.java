package com.groupe2cs.bizyhub.products.application.mapper;

	import com.groupe2cs.bizyhub.products.application.dto.*;
	import com.groupe2cs.bizyhub.products.domain.valueObject.*;
	import com.groupe2cs.bizyhub.products.domain.*;
	import com.groupe2cs.bizyhub.products.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.products.application.command.*;

public class ProductMapper {

public static ProductResponse toResponse(Product entity) {
return ProductResponse.builder()
		.id(entity.getId())
		.remoteId(entity.getRemoteId())
		.localId(entity.getLocalId())
		.code(entity.getCode())
		.name(entity.getName())
		.description(entity.getDescription())
		.status(entity.getStatus())
		.isPublic(entity.getIsPublic())
		.hasSold(entity.getHasSold())
		.hasPrice(entity.getHasPrice())
		.level(entity.getLevel())
		.quantity(entity.getQuantity())
		.barcode(entity.getBarcode())
		.company(entity.getCompany())
		.unit(entity.getUnit())
		.syncAt(entity.getSyncAt())
		.category(entity.getCategory())
		.account(entity.getAccount())
		.defaultPrice(entity.getDefaultPrice())
		.statuses(entity.getStatuses())
		.purchasePrice(entity.getPurchasePrice())
    .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getUsername(): null)
    .tenant(entity.getTenant() != null ? entity.getTenant().getId() : null)
.build();
}

public static ProductResponse toResponse(CreateProductCommand command) {
return ProductResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.code(command.getCode().value())
	.name(command.getName().value())
	.description(command.getDescription().value())
	.status(command.getStatus().value())
	.isPublic(command.getIsPublic().value())
	.hasSold(command.getHasSold().value())
	.hasPrice(command.getHasPrice().value())
	.level(command.getLevel().value())
	.quantity(command.getQuantity().value())
	.barcode(command.getBarcode().value())
	.company(command.getCompany().value())
	.unit(command.getUnit().value())
	.syncAt(command.getSyncAt().value())
	.category(command.getCategory().value())
	.account(command.getAccount().value())
	.defaultPrice(command.getDefaultPrice().value())
	.statuses(command.getStatuses().value())
	.purchasePrice(command.getPurchasePrice().value())
.build();
}

public static ProductResponse toResponse(UpdateProductCommand command) {
return ProductResponse.builder()
	.id(command.getId().value())
	.remoteId(command.getRemoteId().value())
	.localId(command.getLocalId().value())
	.code(command.getCode().value())
	.name(command.getName().value())
	.description(command.getDescription().value())
	.status(command.getStatus().value())
	.isPublic(command.getIsPublic().value())
	.hasSold(command.getHasSold().value())
	.hasPrice(command.getHasPrice().value())
	.level(command.getLevel().value())
	.quantity(command.getQuantity().value())
	.barcode(command.getBarcode().value())
	.company(command.getCompany().value())
	.unit(command.getUnit().value())
	.syncAt(command.getSyncAt().value())
	.category(command.getCategory().value())
	.account(command.getAccount().value())
	.defaultPrice(command.getDefaultPrice().value())
	.statuses(command.getStatuses().value())
	.purchasePrice(command.getPurchasePrice().value())
.build();
}

public static CreateProductCommand toCommand(
ProductRequest request
) {
return CreateProductCommand.builder()
	.remoteId(ProductRemoteId.create(request.getRemoteId()))
	.localId(ProductLocalId.create(request.getLocalId()))
	.code(ProductCode.create(request.getCode()))
	.name(ProductName.create(request.getName()))
	.description(ProductDescription.create(request.getDescription()))
	.status(ProductStatus.create(request.getStatus()))
	.isPublic(ProductIsPublic.create(request.getIsPublic()))
	.hasSold(ProductHasSold.create(request.getHasSold()))
	.hasPrice(ProductHasPrice.create(request.getHasPrice()))
	.level(ProductLevel.create(request.getLevel()))
	.quantity(ProductQuantity.create(request.getQuantity()))
	.barcode(ProductBarcode.create(request.getBarcode()))
	.company(ProductCompany.create(request.getCompany()))
	.unit(ProductUnit.create(request.getUnit()))
	.syncAt(ProductSyncAt.create(request.getSyncAt()))
	.category(ProductCategory.create(request.getCategory()))
	.account(ProductAccount.create(request.getAccount()))
	.defaultPrice(ProductDefaultPrice.create(request.getDefaultPrice()))
	.statuses(ProductStatuses.create(request.getStatuses()))
	.purchasePrice(ProductPurchasePrice.create(request.getPurchasePrice()))
.build();
}

	public static UpdateProductCommand toUpdateCommand(ProductId id, ProductRequest request) {
	return UpdateProductCommand.builder()
	.id(id)
		.remoteId(ProductRemoteId.create(request.getRemoteId()))
		.localId(ProductLocalId.create(request.getLocalId()))
		.code(ProductCode.create(request.getCode()))
		.name(ProductName.create(request.getName()))
		.description(ProductDescription.create(request.getDescription()))
		.status(ProductStatus.create(request.getStatus()))
		.isPublic(ProductIsPublic.create(request.getIsPublic()))
		.hasSold(ProductHasSold.create(request.getHasSold()))
		.hasPrice(ProductHasPrice.create(request.getHasPrice()))
		.level(ProductLevel.create(request.getLevel()))
		.quantity(ProductQuantity.create(request.getQuantity()))
		.barcode(ProductBarcode.create(request.getBarcode()))
		.company(ProductCompany.create(request.getCompany()))
		.unit(ProductUnit.create(request.getUnit()))
		.syncAt(ProductSyncAt.create(request.getSyncAt()))
		.category(ProductCategory.create(request.getCategory()))
		.account(ProductAccount.create(request.getAccount()))
		.defaultPrice(ProductDefaultPrice.create(request.getDefaultPrice()))
		.statuses(ProductStatuses.create(request.getStatuses()))
		.purchasePrice(ProductPurchasePrice.create(request.getPurchasePrice()))
	.build();
	}


public static DeleteProductCommand toDeleteCommand(ProductId id) {
return DeleteProductCommand.builder()
.id(id)
.build();
}
}
