package com.groupe2cs.bizyhub.sales.application.mapper;

	import com.groupe2cs.bizyhub.sales.application.dto.*;
	import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
	import com.groupe2cs.bizyhub.sales.domain.*;
	import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.sales.application.command.*;

public class SaleUserMapper {

public static SaleUserResponse toResponse(SaleUser entity) {
return SaleUserResponse.builder()
		.id(entity.getId())
		.sales(entity.getSales() != null ? entity.getSales().getId() : null)
		.users(entity.getUsers() != null ? entity.getUsers().getId() : null)
		.details(entity.getDetails())
		.isActive(entity.getIsActive())
		.updatedAt(entity.getUpdatedAt())
		.reference(entity.getReference())
.build();
}

public static SaleUserResponse toResponse(CreateSaleUserCommand command) {
return SaleUserResponse.builder()
	.id(command.getId().value())
	.sales(command.getSales().value())
	.users(command.getUsers().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static SaleUserResponse toResponse(UpdateSaleUserCommand command) {
return SaleUserResponse.builder()
	.id(command.getId().value())
	.sales(command.getSales().value())
	.users(command.getUsers().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CreateSaleUserCommand toCommand(
SaleUserRequest request
) {
return CreateSaleUserCommand.builder()
	.sales(SaleUserSales.create(request.getSales()))
	.users(SaleUserUsers.create(request.getUsers()))
	.details(SaleUserDetails.create(request.getDetails()))
	.isActive(SaleUserIsActive.create(request.getIsActive()))
	.updatedAt(SaleUserUpdatedAt.create(request.getUpdatedAt()))
	.reference(SaleUserReference.create(request.getReference()))
.build();
}

	public static UpdateSaleUserCommand toUpdateCommand(SaleUserId id, SaleUserRequest request) {
	return UpdateSaleUserCommand.builder()
	.id(id)
		.sales(SaleUserSales.create(request.getSales()))
		.users(SaleUserUsers.create(request.getUsers()))
		.details(SaleUserDetails.create(request.getDetails()))
		.isActive(SaleUserIsActive.create(request.getIsActive()))
		.updatedAt(SaleUserUpdatedAt.create(request.getUpdatedAt()))
		.reference(SaleUserReference.create(request.getReference()))
	.build();
	}


public static DeleteSaleUserCommand toDeleteCommand(SaleUserId id) {
return DeleteSaleUserCommand.builder()
.id(id)
.build();
}
}
