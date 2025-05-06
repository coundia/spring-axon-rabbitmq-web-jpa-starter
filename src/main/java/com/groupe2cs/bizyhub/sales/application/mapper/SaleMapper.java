package com.groupe2cs.bizyhub.sales.application.mapper;

	import com.groupe2cs.bizyhub.sales.application.dto.*;
	import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
	import com.groupe2cs.bizyhub.sales.domain.*;
	import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.sales.application.command.*;

public class SaleMapper {

public static SaleResponse toResponse(Sale entity) {
return SaleResponse.builder()
		.id(entity.getId())
		.name(entity.getName())
		.amount(entity.getAmount())
		.details(entity.getDetails())
		.isActive(entity.getIsActive())
		.product(entity.getProduct() != null ? entity.getProduct().getId() : null)
		.updatedAt(entity.getUpdatedAt())
		.reference(entity.getReference())
.build();
}

public static SaleResponse toResponse(CreateSaleCommand command) {
return SaleResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.amount(command.getAmount().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.product(command.getProduct().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static SaleResponse toResponse(UpdateSaleCommand command) {
return SaleResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.amount(command.getAmount().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.product(command.getProduct().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CreateSaleCommand toCommand(
SaleRequest request
) {
return CreateSaleCommand.builder()
	.name(SaleName.create(request.getName()))
	.amount(SaleAmount.create(request.getAmount()))
	.details(SaleDetails.create(request.getDetails()))
	.isActive(SaleIsActive.create(request.getIsActive()))
	.product(SaleProduct.create(request.getProduct()))
	.updatedAt(SaleUpdatedAt.create(request.getUpdatedAt()))
	.reference(SaleReference.create(request.getReference()))
.build();
}

	public static UpdateSaleCommand toUpdateCommand(SaleId id, SaleRequest request) {
	return UpdateSaleCommand.builder()
	.id(id)
		.name(SaleName.create(request.getName()))
		.amount(SaleAmount.create(request.getAmount()))
		.details(SaleDetails.create(request.getDetails()))
		.isActive(SaleIsActive.create(request.getIsActive()))
		.product(SaleProduct.create(request.getProduct()))
		.updatedAt(SaleUpdatedAt.create(request.getUpdatedAt()))
		.reference(SaleReference.create(request.getReference()))
	.build();
	}


public static DeleteSaleCommand toDeleteCommand(SaleId id) {
return DeleteSaleCommand.builder()
.id(id)
.build();
}
}
