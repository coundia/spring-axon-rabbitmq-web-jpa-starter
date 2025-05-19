package com.groupe2cs.bizyhub.categories.application.mapper;

	import com.groupe2cs.bizyhub.categories.application.dto.*;
	import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
	import com.groupe2cs.bizyhub.categories.domain.*;
	import com.groupe2cs.bizyhub.categories.infrastructure.entity.*;
	import com.groupe2cs.bizyhub.categories.application.command.*;

public class CategoryMapper {

public static CategoryResponse toResponse(Category entity) {
return CategoryResponse.builder()
		.id(entity.getId())
		.name(entity.getName())
		.typeCategoryRaw(entity.getTypeCategoryRaw())
		.details(entity.getDetails())
		.isActive(entity.getIsActive())
		.updatedAt(entity.getUpdatedAt())
		.reference(entity.getReference())
    .createdBy(entity.getCreatedBy().getUsername())
    .tenant(entity.getTenant().getName())
.build();
}

public static CategoryResponse toResponse(CreateCategoryCommand command) {
return CategoryResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.typeCategoryRaw(command.getTypeCategoryRaw().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CategoryResponse toResponse(UpdateCategoryCommand command) {
return CategoryResponse.builder()
	.id(command.getId().value())
	.name(command.getName().value())
	.typeCategoryRaw(command.getTypeCategoryRaw().value())
	.details(command.getDetails().value())
	.isActive(command.getIsActive().value())
	.updatedAt(command.getUpdatedAt().value())
	.reference(command.getReference().value())
.build();
}

public static CreateCategoryCommand toCommand(
CategoryRequest request
) {
return CreateCategoryCommand.builder()
	.name(CategoryName.create(request.getName()))
	.typeCategoryRaw(CategoryTypeCategoryRaw.create(request.getTypeCategoryRaw()))
	.details(CategoryDetails.create(request.getDetails()))
	.isActive(CategoryIsActive.create(request.getIsActive()))
	.updatedAt(CategoryUpdatedAt.create(request.getUpdatedAt()))
	.reference(CategoryReference.create(request.getReference()))
.build();
}

	public static UpdateCategoryCommand toUpdateCommand(CategoryId id, CategoryRequest request) {
	return UpdateCategoryCommand.builder()
	.id(id)
		.name(CategoryName.create(request.getName()))
		.typeCategoryRaw(CategoryTypeCategoryRaw.create(request.getTypeCategoryRaw()))
		.details(CategoryDetails.create(request.getDetails()))
		.isActive(CategoryIsActive.create(request.getIsActive()))
		.updatedAt(CategoryUpdatedAt.create(request.getUpdatedAt()))
		.reference(CategoryReference.create(request.getReference()))
	.build();
	}


public static DeleteCategoryCommand toDeleteCommand(CategoryId id) {
return DeleteCategoryCommand.builder()
.id(id)
.build();
}
}
