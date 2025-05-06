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
		.name(entity.getName())
		.price(entity.getPrice())
		.details(entity.getDetails())
		.isActive(entity.getIsActive())
		.updatedAt(entity.getUpdatedAt())
		.reference(entity.getReference())
.build();
}

public static ProductResponse toResponse(CreateProductCommand command) {
return ProductResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.price(command.getPrice().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static ProductResponse toResponse(UpdateProductCommand command) {
return ProductResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.price(command.getPrice().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CreateProductCommand toCommand(
ProductRequest request
) {
return CreateProductCommand.builder()
	.name(ProductName.create(request.getName()))
	.price(ProductPrice.create(request.getPrice()))
	.details(ProductDetails.create(request.getDetails()))
	.isActive(ProductIsActive.create(request.getIsActive()))
	.updatedAt(ProductUpdatedAt.create(request.getUpdatedAt()))
	.reference(ProductReference.create(request.getReference()))
.build();
}

	public static UpdateProductCommand toUpdateCommand(ProductId id, ProductRequest request) {
	return UpdateProductCommand.builder()
	.id(id)
		.name(ProductName.create(request.getName()))
		.price(ProductPrice.create(request.getPrice()))
		.details(ProductDetails.create(request.getDetails()))
		.isActive(ProductIsActive.create(request.getIsActive()))
		.updatedAt(ProductUpdatedAt.create(request.getUpdatedAt()))
		.reference(ProductReference.create(request.getReference()))
	.build();
	}


public static DeleteProductCommand toDeleteCommand(ProductId id) {
return DeleteProductCommand.builder()
.id(id)
.build();
}
}
